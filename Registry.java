// Ralph Liton 
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File ;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer ;
import java.util.TreeMap;



public class Registry
{
   private TreeMap<String,Student> students = new TreeMap<String, Student>();
   private TreeMap<String, ActiveCourse> courses = new TreeMap<String, ActiveCourse>();
   private Scanner scanner;
   
   public Registry() throws FileNotFoundException, InputMismatchException, NoSuchElementException
   {
	// Add some students
	   // in A2 we will read from a file
	try{
		File reader = new File("students.txt") ;
		scanner = new Scanner(reader);

		while (scanner.hasNextLine())												
		{
			String line = scanner.nextLine();
			StringTokenizer st = new StringTokenizer(line);	
			// Checking if any of the lines exceed two tokens since the student file should only have two tokens: Name and ID
			if (st.countTokens() > 2)
			{
				throw new InputMismatchException();
			}
			else continue;
		}
		
		scanner = new Scanner(new File("students.txt"));	
		// Resets the scanner to start from the beginning and reads in the student file


		String a = scanner.next(); String b = scanner.next();
		String c = scanner.next(); String d = scanner.next();
		String e = scanner.next(); String f = scanner.next();
		String g = scanner.next(); String h = scanner.next();
		String i = scanner.next(); String j = scanner.next();
		String k = scanner.next(); String l = scanner.next();

		Student s1 = new Student(a, b);
		Student s2 = new Student(c,d);
		Student s3 = new Student(e,f);
		Student s4 = new Student(g,h);	
		Student s5 = new Student (i,j);
		Student s6 = new Student(k,l);
		
		students.put(b, s1);
		students.put(d, s2);
		students.put(f, s3);
		students.put(h, s4);
		students.put(j, s5);
		students.put(l, s6);

		System.out.println("Welcome to the Student Registry Simulator. ");
		System.out.println();
		System.out.println("Type and Enter COMMANDS to view the commands associated with the Student Registry Simulator.");

		

	   // sort the students alphabetically - see class Student
	   
	   ArrayList<Student> list = new ArrayList<Student>();
	   
	   // Add some active courses with students
	   String courseName = "Computer Science II";
	   String courseCode = "CPS209";
	   String descr = "Learn how to write complex programs!";
	   String format = "3Lec 2Lab";
	   list.add(s2); list.add(s3); list.add(s4);
	   courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list)); // the list are the students in this course
	   courses.put(courseCode.toLowerCase(), new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   // Add course to student list of courses
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s3.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	  
	   // CPS511
	   list.clear();
	   courseName = "Computer Graphics";
	   courseCode = "CPS511";
	   descr = "Learn how to write cool graphics programs";
	   format = "3Lec";
	   list.add(s1); list.add(s5); list.add(s6);
	   courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"F2020",list));
	   courses.put(courseCode.toLowerCase(), new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	   
	   // CPS643
	   list.clear();
	   courseName = "Virtual Reality";
	   courseCode = "CPS643";
	   descr = "Learn how to write extremely cool virtual reality programs";
	   format = "3Lec 2Lab";
	   list.add(s1); list.add(s2); list.add(s4); list.add(s6);
	   courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   courses.put(courseCode.toLowerCase(), new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	   s1.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s2.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	   s6.addCourse(courseName,courseCode,descr,format,"W2020", 0); 

	 // CPS706
	 list.clear();
     courseName = "Computer Networks";
     courseCode = "CPS706";
     descr = "Learn about Computer Networking";
     format = "3Lec 1Lab";
	 courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	 courses.put(courseCode.toLowerCase(), new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	 s2.addCourse(courseName,courseCode,descr,format,"W2020", 0);
	 s3.addCourse(courseName,courseCode,descr,format,"W2020", 0);  

	 
	// CPS616
	list.clear();
     courseName = "Algorithms";
     courseCode = "CPS616";
     descr = "Learn about Algorithms";
     format = "3Lec 1Lab";
	 courses.put(courseCode, new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	 courses.put(courseCode.toLowerCase(), new ActiveCourse(courseName,courseCode,descr,format,"W2020",list));
	 s4.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	 s5.addCourse(courseName,courseCode,descr,format,"W2020", 0); 
	
	}
	catch (FileNotFoundException fe)
	{
		throw fe;
	}
	catch (InputMismatchException ime)
	{
		throw ime;
	}
	catch (NoSuchElementException nse)
	{
		throw nse;
	}
   }

   public TreeMap<String, ActiveCourse> getCourses()
   {
		return courses;
   }
   
   /**
	Adds Student to Registry
	@param name	Student Name
	@param id		Student Id
	@return true if Student has been added
	@return fale if Student is already in Registry
    */
   public boolean addNewStudent(String name, String id)
   {
	   Student student = new Student(name, id);		// Creates a new Student Object from given parameters
	   for (Student i : students.values())
	   if (i.equals(student))
	   {	
		   System.out.println("Student is already in Registry.");
		   return false;
	   }students.put(id, student);
	   System.out.println(name + " " + id + " has been added to the Registry.");
	   return true;
	   
	   // Create a new student object
	   // check to ensure student is not already in registry
	   // if not, add them and return true, otherwise return false
	   // make use of equals method in class Student
   }
 
   /**
	Removes Student from Registry
	Find student in students arraylist
    If found, remove this student and return true
	@param studentId
	@return true if Student has been removed
    */
   public boolean removeStudent(String studentId)
   {
		for (Student idChecker : students.values())	// Iterating over Student ArrayList
		{
			if(idChecker.getId().equals(studentId))	// Checks if the given StudentID matches Student ID in Student ArrayList
			{
				students.remove(studentId);	// removes the Student from the Student ArrayList
				System.out.println(idChecker.getName() + " " + studentId + " has been removed from the Registry." );
				return true;
			} 
			
		}  
	   return false;
   }
   
  /**
   Print all registered students
   */
   public void printAllStudents()
   {
	//    for (int i = 0; i < students.size(); i++)
	//    {
	// 	   System.out.println("ID: " + students.get(i).getId() + " Name: " + students.get(i).getName() );   
	//    }
	   
	   for (Student i : students.values())
	   {
		   System.out.println("ID: " + i.getId() + " Name: " + i.getName() );
	   }
   }
   
   /**
	Given a studentId and a course code, add student to the active course
	@param studentId	
	@param courseCode
    */
   public void addCourse(String studentId, String courseCode)
   {
	   boolean active = false; 		
	   for (Student i: students.values())						// Iterates over the Student ArrayList
		   if(i.getId().equals(studentId))				// Checks if Student is in the ArrayList
			   for (CreditCourse c : i.courses)			// Iterates over the Creditcourse
				   if (c.getCode().equals(courseCode))	// Checks if Student has already taken the course
				   {
					   active = true;					// sets active to true if student already took course
					   System.out.println(i.getName() + " " + i.getId() + " is already enrolled in: " + courseCode); 
				   }
		
		if (!active)	   								// if active is false
			for (ActiveCourse a : courses.values())
				if(a.getCode().equals(courseCode))		// Checks for the courseCode in the ActiveCourse ArrayList
				{
					ActiveCourse ac = a;			
					if (!ac.CheckStudents(studentId))	// checks if the student is not enrolled in Active Course
					{
						for (Student i: students.values())
							if (i.getId().equals(studentId))
							{
								ac.addStudentToActiveCourse(i);
								i.addCourse(ac.getName(), ac.getCode(), ac.getDescr(), ac.getFormat(), ac.getSemester(), 0);	// adds the new course to the CreditCourse of the student
								System.out.println(i.getName() + " " + i.getId() + " has been successfully added to " + courseCode + ".");
							
							}
					}
			
				
				}
	   // Find student object in registry (i.e. students arraylist)
	   // Check if student has already taken this course in the past Hint: look at their credit course list
	   // If not, then find the active course in courses array list using course code
	   // If active course found then check to see if student already enrolled in this course
	   // If not already enrolled
	   //   add student to the active course
	   //   add course to student list of credit courses with initial grade of 0
	   
	   
   }
   
   /**
	Given a studentId and a course code, drop student from the active course
	@param studentId
	@param courseCode
    */
   public void dropCourse(String studentId, String courseCode)
   {

	 for (ActiveCourse a: courses.values())
	 	if (a.getCode().equals(courseCode))		// Checks for the courseCode in the ActiveCourse ArrayList
	 	{
			 ActiveCourse ac = a;
			 if (ac.CheckStudents(studentId))	// Checks if student is enrolled in the ActiveCourse
			{
				for (Student i : students.values())
					if (i.getId().equals(studentId))
					{
						
						ac.removeStudentToActiveCourse(i);		// calls the removeStudentToActiveCourse method in ActiveCourse Class to remove student
						i.removeActiveCourse(courseCode);		// calls the removeActiveCourse method in Student Class to remove Course
						System.out.println(i.getName() + " " + i.getId() + " has been successfully removed from " + courseCode + ".");

					}
			}
	 	}
	   // Find the active course
	   // Find the student in the list of students for this course
	   // If student found:
	   //   remove the student from the active course
	   //   remove the credit course from the student's list of credit courses
	   
   }
   
   /**
	Print all active courses
    */
   public void printActiveCourses()
   {
	   for(ActiveCourse a : courses.values())
	   {
		   ActiveCourse ac = a;
		   System.out.println(ac.getDescription());
	   }
   }
   
   /**
	Print the list of students in an active course
	*/ 
   public void printClassList(String courseCode)
   {
	for (ActiveCourse a : courses.values())
		if (a.getCode().equals(courseCode))
		{
			ActiveCourse ac = a;
			System.out.println("Class List of " + courseCode + ":");
			ac.printClassList();
		}
   }

   
   /**
	Given a course code, find course and sort class list by student name
	@param courseCode
    */
   public void sortCourseByName(String courseCode)
   {
	   for (ActiveCourse a: courses.values())
		   if (a.getCode().equals(courseCode))
		   {
			   ActiveCourse ac = a;
			   ac.sortByName();
			   
		   }
   }
   
   /**
	Given a course code, find course and sort class list by student name
	@param courseCode
    */
   public void sortCourseById(String courseCode)
   {	
	   for (ActiveCourse a: courses.values())
		   if (a.getCode().equals(courseCode))
		   {
			   ActiveCourse ac = a;
			   ac.sortById();
		   }
   }
   
   /**
	* Given a course code, find course and print student names and grades
	* @param courseCode
    */
   public void printGrades(String courseCode)
   {
	   for (ActiveCourse a : courses.values())
		   if (a.getCode().equals(courseCode))
		   {
			   ActiveCourse ac = a;
			   System.out.println("Current Grades of Students for " + courseCode + ":");
			   ac.printGrades(courseCode);
		   }
		   
	   // make a for loop for courses array list, compare it to courseCode
	   // then use the student reference variable to call printgrades() in student class
   }
   
   /**
	Given a course code, find course and print student names and grades
	@param studentId
    */
   public void printStudentCourses(String studentId)
   {
	   for (Student i : students.values())
		   if(i.getId().equals(studentId))
		   {
			   Student s = i;		// s = the specified student ID
			   s.printActiveCourses(); //uses that student ID to call printActiveCourseS()
		   }
   }
   
/**
  Given a course code, student id and numeric grade
  set the final grade of the student
  @param studentId
 */
   public void printStudentTranscript(String studentId)
   {
	   for (Student i: students.values())
		   if (i.getId().equals(studentId))
		   {
			   Student s = i;	// s = the specified student ID
			   System.out.println();
			   s.printTranscript();
		   }
   }
   

   /**
    Given a course code, student id and numeric grade
    set the final grade of the student
	@param courseCode
	@param studentId
	@param grade
    */
   public void setFinalGrade(String courseCode, String studentId, double grade)
   {
	for (ActiveCourse a : courses.values())
	if(a.getCode().equals(courseCode))
		for(Student i : students.values())
			if(i.getId().equals(studentId))
				for (CreditCourse c: i.courses)
					if (c.getCode().equals(courseCode))
					{
						c.grade = grade;
						c.setInactive();
						System.out.println("Grade has been updated for " + i.getName() + " " + i.getId() + " for the course: " + courseCode + ".");
					}

	   // find the active course
	   // If found, find the student in class list
	   // then search student credit course list in student object and find course
	   // set the grade in credit course and set credit course inactive
	   
   }
  
}
