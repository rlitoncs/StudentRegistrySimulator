// Ralph Liton 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Active University Course
 
public class ActiveCourse extends Course
{
	private ArrayList<Student> students; // keeps an arrayList of students enrolled in the course
   private String semester;
   int lectureStart;
   int lectureDuration;
   String lectureDay;
   
     // added constructor
    
   /**
   Add a constructor method with appropriate parameters
   should call super class constructor to initialize inherited variables
   make sure to *copy* students array list being passed in into new arraylist of students
   see class Registry to see how an ActiveCourse object is created and used
    @param name         the name of the Course
    @param code         the Course Code
    @param descr        the Course description
    @param fmt          the Course format
    @param semester     the Course Semester
    @param students     the Students in the specified Course (CPS209, CPS511, CPS643)
    */
   public ActiveCourse(String name, String code, String descr, String fmt, String semester, ArrayList<Student> students)
   {
      super(name, code, descr, fmt);
      this.semester = semester;
      this.students = new ArrayList<Student>(students);
   }

   public void setStartTime(int startTime)
   {
      this.lectureStart = startTime;
   }
   
   public void setlectureDuration(int duration)
   {
     this.lectureDuration = duration;
   }

   public void setlectureDay(String day)
   {
      this.lectureDay = day;
   }

   public String getlectureDay()
   {
      if (this.lectureDay != null)
         return this.lectureDay;
      
      else   
      {
         this.lectureDay = "";
         return this.lectureDay;
      }
   }


   public String getSemester()
   {
	   return semester;
   }
   
 /**
  * Checks if the given StudentID matches the StudentID in student ArrayList
  * @param studentId
  * @return 
  */
   public boolean CheckStudents(String studentId)   //added  CheckStudents
   {
      
      for (Student i: students)           // iterating over students ArrayList
         if (i.getId().equals(studentId)) // checks if studentId in the arraylist is equal to the given studentId
            return true;
      return false;
   }

   /**
   Adds the student to the Active Course
   @param student    passes in a Student object
    */
   public void addStudentToActiveCourse(Student student) 
   {
      students.add(student);
   }

   
   /**
   Removes the student to the Active Course
   @param student    passes in a Student object
    */
   public void removeStudentToActiveCourse(Student student)
   {
      students.remove(student);
   }

   /**
   Prints the students in this course  (name and student id)
    */
   public void printClassList()
   {
      for (Student i : students)
	      System.out.println(i);
   }
   
  /**
   Prints the grade of each student in this course (along with name and student id)
   */
   public void printGrades(String courseCode)
   {  
      for (Student i : students)
       System.out.println(i.getId() + " " + i.getName() + " " + i.getGrade(courseCode));
   }
   

   /**
   Returns the numeric grade in this course for this student
   If student not found in course, return 0 
   @param studentId
   @return the grade stored in the credit course object
   ***** Method was not used
   */ 
   // public double getGrade(String studentId)
   // {
   //    for (Student i: students)
   //       if (CheckStudents(studentId))
   //       {
   //         // i.getGrade();  //calls the getGrade() method in student class
   //       }
   //    return 0; 

	  // Search the student's list of credit courses to find the course code that matches this active course
	  // see class Student method getGrade() 
     // return the grade stored in the credit course object
   //}

   
   
   /**
   Returns a String containing the course information as well as the semester and the number of students 
   enrolled in the course
   must override method in the superclass Course and use super class method getDescription()
    */

   public String getDescription()
   {
	   return super.getDescription() + " " + this.semester + " " + "Enrollment: " + this.students.size() + "\n";
   }
    
   
   /**
   Sorts the students in the course by name
    */
   public void sortByName()
   {
      NameComparator nameCompare = new NameComparator();
      Collections.sort(students, nameCompare); 
   }
   
   /**
   Sort the students in the course by name using the Collections.sort() method with appropriate arguments
   Make use of a private Comparator class below
    */
   private class NameComparator implements Comparator<Student>
   {
      public int compare(Student a, Student b)
      {
         return a.getName().compareTo(b.getName());
      }
   }
   
   /**
   Sort the students in the course by student ID
    */
   public void sortById()
   {
      IdComparator idCompare = new IdComparator();
      Collections.sort(students, idCompare);
   }
   

   /**
   Fill in the class so that this class implement the Comparator interface
   This class is used to compare two Student objects based on student id
    */
   private class IdComparator implements Comparator <Student>
   {
      public int compare(Student idA, Student idB)
      {
         return idA.getId().compareTo(idB.getId());
      }
   	
   }
}
