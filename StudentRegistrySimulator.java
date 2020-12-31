// Ralph Liton 500958086
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeMap;

//import Scheduler.ExceptionHandling;

public class StudentRegistrySimulator 
{
	
	
  public static void main(String[] args) throws  FileNotFoundException, InputMismatchException, NoSuchElementException
  {
	Registry registry = null;
	Scheduler schedule = null;
	try {
		registry = new Registry();
		schedule = new Scheduler(registry.getCourses());
	} 
	catch (FileNotFoundException e)
	{
		System.out.println("students.txt file not found.");
	}
	catch (InputMismatchException ime)
	{
		System.out.println("Too many characters. Line should only contain STUDENT NAME and ID.c");
	}
	catch (NoSuchElementException nse)
	{
		System.out.println("Bad File Format student.txt.");
	}

	

	
	//  Scheduler schedule = new Scheduler(StudentRegistrySimulator.
	
	  Scanner scanner = new Scanner(System.in);
	  System.out.print(">");
	  
	  
	  while (scanner.hasNextLine())
	  {
		  String inputLine = scanner.nextLine();
		  if (inputLine == null || inputLine.equals("")) continue;
		  
		  Scanner commandLine = new Scanner(inputLine);
		  String command = commandLine.next();
		  
		  if (command == null || command.equals("")) continue;
		  
		  else if (command.equalsIgnoreCase("L") || command.equalsIgnoreCase("LIST"))
		  {
			  System.out.println("\n" + "Current Student Registry:");
			  registry.printAllStudents();
		  }
		  else if (command.equalsIgnoreCase("Q") || command.equalsIgnoreCase("QUIT"))
			  return;

			  
		else if (command.equalsIgnoreCase("COMMANDS"))
		{
			System.out.println("List Of Commands: ");
			System.out.println("L:" + "\t" + " Prints Current Student Registry.") ;
			System.out.println("Q:" + "\t" + " Quit the Student Registry Simulator.");
			System.out.println("REG:" + "\t" + " Adds a new Student to Registry.");
			System.out.println("DEL:" + "\t" + " Delete a student from Registry.");
			System.out.println("ADDC:" + "\t" + " Adds a Student to a Course.");
			System.out.println("DROPC:" + "\t" + " Drops a Student from a Course.");
			System.out.println("PAC:" + "\t" + " Prints all Active Courses.");
			System.out.println("PCL:" + "\t" + " Prints Class List.");
			System.out.println("PGR:" + "\t" + " Prints grades for all students in a Course.");
			System.out.println("PSC:" + "\t" + " Prints all Credit Courses of a Student.");
			System.out.println("PST:" + "\t" + " Prints Student Transcript.");
			System.out.println("SFG:" + "\t" + " Sets the Final Grade of a Student.");
			System.out.println("SCN:" + "\t" + " Sorts all the Students in a Course by Name.");
			System.out.println("SCI:" + "\t" + " Sorts all the Students in a Course by StudentID.");
			System.out.println("SCH:" + "\t" + " Schedule a Course.");
			System.out.println("CSCH:" + "\t" + " Clear a Course from Schedule.");
			System.out.println("PSCH:" + "\t" + " Prints the Current Schedule.");
		}
		
		  else if (command.equalsIgnoreCase("REG"))
		  {
			  System.out.print("Please enter your name: ");
			  String studentName = scanner.nextLine(); 
			  while (!isStringOnlyAlphabet(studentName))
			  {
				  System.out.print("Please provide a valid name: ");
				  studentName = scanner.nextLine();
			  }
			  
			  System.out.print("Please enter you student ID: ");
			  String studentID = scanner.nextLine();
			  while (!isNumeric(studentID))
			  {
				  System.out.print("Please provide a valid student ID: ");
				  studentID = scanner.nextLine();
			  }

			registry.addNewStudent(studentName, studentID);

			  // register a new student in registry
			  // get name and student id string 
			  // e.g. reg JohnBoy 74345
			  // Checks:
			  //  ensure name is all alphabetic characters
			  //  ensure id string is all numeric characters
			  
		  }
		  else if (command.equalsIgnoreCase("DEL"))
		  {
			  System.out.print("Please enter student ID to delete: ");
			  String studentID = scanner.nextLine();
			  while (!isNumeric(studentID))
			  {
				  System.out.print("Please provide valid student ID: ");
				  studentID = scanner.nextLine();
				  
			  }
			  	registry.removeStudent(studentID);

			  // delete a student from registry
			  // get student id
			  // ensure numeric
			  // remove student from registry
		  }
		  
		  else if (command.equalsIgnoreCase("ADDC")) 
		  {
			  System.out.print("Please enter student ID: ");
			  String studentID = scanner.nextLine();
			  while (!isNumeric(studentID))
			  {
				  System.out.print("Please provide a valid ID: ");
				  studentID = scanner.nextLine();
			  }

			  System.out.print("Please enter the Course Code: ");
			  String courseCode = scanner.nextLine();
			  
			registry.addCourse(studentID, courseCode);

			 // add a student to an active course
			 // get student id and course code strings
			 // add student to course (see class Registry)
			  
		  }
		  else if (command.equalsIgnoreCase("DROPC"))
		  {
			  System.out.print("Please enter student ID: ");
			  String studentID = scanner.nextLine();
			  while(!isNumeric(studentID))
			  {
				  System.out.print("Please enter valid student ID: ");
				  studentID = scanner.nextLine();
			  }
				  
			  System.out.print("Please enter course code: ");
			  String courseCode = scanner.nextLine();
			  registry.dropCourse(studentID, courseCode);

			  // get student id and course code strings
			  // drop student from course (see class Registry)
		  }
		  else if (command.equalsIgnoreCase("PAC"))
		  {
			System.out.println();
			registry.printActiveCourses();

			// print all active courses
		  }		  
		  else if (command.equalsIgnoreCase("PCL"))
		  {
			  System.out.print("Please enter Course Code: ");
			  String courseCode = scanner.nextLine();
			  System.out.println();
			  registry.printClassList(courseCode);

			  // get course code string
			  // print class list (i.e. students) for this course
			  
		  }
		  else if (command.equalsIgnoreCase("PGR"))
		  {
			  System.out.print("Please enter Course Code: ");
			  String courseCode = scanner.nextLine();
			  System.out.println();
			  registry.printGrades(courseCode);

			  // get course code string
			  // print name, id and grade of all students in active course
		  }
		  else if (command.equalsIgnoreCase("PSC"))
		  {
			  System.out.print("Please enter a student ID: ");
			  String studentID = scanner.nextLine();
			  System.out.println();
			  while (!isNumeric(studentID))
			  {
				  System.out.print("Please enter a valid student ID: ");
				  studentID = scanner.nextLine();
				  System.out.println();
				  

			  }
			  registry.printStudentCourses(studentID);

			  // get student id string
			  // print all credit courses of student


			  
		  }
		  else if (command.equalsIgnoreCase("PST"))
		  {
			  System.out.print("Please enter a student ID: ");
			  String studentID = scanner.nextLine();
			  while (!isNumeric(studentID))
			  {
				  System.out.print("Please enter a valid student ID: ");
				  studentID = scanner.nextLine();
			  }

			  registry.printStudentTranscript(studentID);
			  // get student id string
			  // print student transcript
			  
		  }
		  else if (command.equalsIgnoreCase("SFG"))
		  {
			  System.out.print("Please enter Course Code: ");
			  String courseCode = scanner.nextLine();

			  System.out.print("Please enter student ID: ");
			  String studentID = scanner.nextLine();
			  while(!isNumeric(studentID))
			  {
				  System.out.print("Please enter a valid student ID: ");
				  studentID = scanner.nextLine();
			  }

			  System.out.print("Please enter grade: ");
			  double grade = scanner.nextDouble();

			  registry.setFinalGrade(courseCode, studentID, grade);
			  // set final grade of student
			  // get course code, student id, numeric grade
			  // use registry to set final grade of this student (see class Registry)
		  }
		  else if (command.equalsIgnoreCase("SCN"))
		  {
			  System.out.print("Please enter Course Code: ");
			  String courseCode = scanner.nextLine();
			  System.out.println();
			  System.out.println("Sorting List in course by Name...");
			  System.out.println("See Sorted Class List of " + courseCode + " " + "in PCL.");
			  
			  registry.sortCourseByName(courseCode);
			  // get course code
			  // sort list of students in course by name (i.e. alphabetically)
			  // see class Registry
			  
		  }
		  else if (command.equalsIgnoreCase("SCI"))
		  {
			System.out.print("Please enter Course Code: ");
			String courseCode = scanner.nextLine();
			System.out.println();
			System.out.println("Sorting List in course by Student ID...");
			System.out.println("See Sorted Class List of " + courseCode + " " + "in PCL.");


			registry.sortCourseById(courseCode);
			
			// get course code
			// sort list of students in course by student id
			// see class Registry
		  }
		  else if (command.equalsIgnoreCase("SCH"))
		  {
			  try{
			  System.out.println("Please enter the Course Code, Day, Start Time, and Duration to Schedule: ");
			  System.out.print("Course Code: ");
			  String courseCode = scanner.next();
			  System.out.print("Day: ");
			  String day = scanner.next();
			  System.out.print("Start Time: ");
			  int start = scanner.nextInt();
			  System.out.print("Duration: ");
			  int duration = scanner.nextInt();
			  

			  schedule.setDayAndTime(courseCode, day, start, duration);

			  }
			  catch(ExceptionH e)
			  {
				System.out.println(e.getMessage());
			  }
			  catch(InputMismatchException e)
			  {
				  System.out.println("Please input proper values");
			  }
		  }
		  else if (command.equalsIgnoreCase("PSCH"))
		  {
			schedule.printSchedule();
		  }

		  else if (command.equalsIgnoreCase("CSCH"))
		  {
			  System.out.println("Please enter the Course Code to clear:");
			  String courseCode = scanner.next();
			  schedule.clearSchedule(courseCode);
		  }

		  System.out.print("\n>");
		  
	  }
  }

  private static boolean isStringOnlyAlphabet(String str) 
  { 
	  // write method to check if string str contains only alphabetic characters 
	  for (int i =0; i <str.length() - 1; i++)
	  {
		  char ch = str.charAt(i);
		  if (!Character.isAlphabetic(ch))
			  return false;
	  }
	  return true;
  } 
  
  public static boolean isNumeric(String str)
  {
      // write method to check if string str contains only numeric characters
	 for (int i = 0; i < str.length() - 1; i++) 
	 {
		 char ch = str.charAt(i);
		 if (!Character.isDigit(ch))
				  return false;
	 }
	 if (str.length() < 5)
		 {
		 	System.out.println("Error: ID must be 5 digits.");
			return false;
		 }
	  return true;
  }

 
  
}