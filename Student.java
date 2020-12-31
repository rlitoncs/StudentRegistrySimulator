 // Ralph Liton 500958086
 import java.util.ArrayList;

// Make class Student implement the Comparable interface
// Two student objects should be compared by their name
public class Student implements Comparable<Student>
{
  private String name;
  private String id;                            // should contain 5 digit characters
  public  ArrayList<CreditCourse> courses;      // keeps track of the courses the student is enrolled in
  
  public Student(String name, String id)
  {
	 this.name = name;
	 this.id   = id;
	 courses   = new ArrayList<CreditCourse>();
  }
  
  public String getId()
  {
	  return id;
  }
  
  public String getName()
  {
	  return name;
  }


/**
Iterates through the CreditCourse ArrayList and gets grade of Student
@return the Grade of Student
 */
public double getGrade(String courseCode)
{
  for (CreditCourse getGr : courses) 
    if (getGr.getCode().equals(courseCode))
      return getGr.getGrade();
  return 0;
}
  

/**
 adds a credit course to list of courses for this student
 @param courseName    the name of the Course
 @param courseCode    the Course Code
 @param descr         the Course Description
 @param format        the Course Format
 @param sem           the Course Semester
 @param grade         
 */
  public void addCourse(String courseName, String courseCode, String descr, String format,String sem, double grade)
  {
   
    CreditCourse course = new CreditCourse(courseName, courseCode, descr, format, sem, grade);
    course.setActive(); // sets the courses of the student as active
    this.courses.add(course); // adds course object into courses ArrayList

     //Instructions:
      // create a CreditCourse object
	    // set course active
      // add to courses array list

  }

  /**
  Prints a student transcript
  Prints all completed (i.e. non active) courses for this student (course code, course name, 
  semester, letter grade
  see class CreditCourse for useful methods
   */

  public void printTranscript()
  {
    
    for (CreditCourse c: courses)
    {
      if(!c.getActive())  // Checks if course is non active 
      {
        System.out.println(c.getCode() + " " + c.getName() + " " + c.getSemester() + " " + c.displayGrade());
      }
      else 
      {
        System.out.println(c.getCode() + " has not been completed for this student.");
      }
    }
  }

  /**
  Prints all active courses this student is enrolled in
  see variable active in class CreditCourse
   */

  public void printActiveCourses()
  {
    for (CreditCourse c : courses)  // this iterates over the CreditCourse arraylist. In the CreditCourse Arraylist, each element is an object, and each object holds a courseName, courseCode, desc, fmt, sem, and grade. However when you call getDescription, getDescription only returns code, name, description and format and not grade
     {
       System.out.println(c.getDescription()); //To print an object, a String method is needed, such as the getDescription() which is a String
       System.out.println();
     }
    }



/**
 Drop a course (given by courseCode)
 Find the credit course in courses arraylist above and remove it
 only remove it if it is an active course
 @param courseCode 
 */
 public void removeActiveCourse(String courseCode)
 {
   for (CreditCourse i : courses)
    if(i.getCode().equals(courseCode) && i.getActive())   // Checks if the given course is active and matches the course in the CreditCourse ArrayList
    {  
      this.courses.remove(i); 
      break;
    }
 }
  public String toString()
  {
	  return "Student ID: " + id + " Name: " + name;
  }
  

  /**
  override equals method inherited from superclass Object
  if student names are equal *and* student ids are equal (of "this" student
  and "other" student) then return true
  otherwise return false
  Hint: you will need to cast other parameter to a local Student reference variable
   */
  public boolean equals(Object other) // Object is big daddy class of all classes 
  {
    if (!(other instanceof Student))  // if the other object is not an instanceOf the class Student, return false;
      return false;

    Student otherS = (Student) other; // we're making the "other" object an object of the student class by casting (Student)
    if (this.name.equals(otherS.name) && this.id.equals(otherS.id))
    {
   
      return true;
    }
    else return false; 
  }
  
   public int compareTo(Student other)
  {
    int comPar = this.name.compareTo(other.name);
    return comPar;
  }
    
  // highlight block of code and " Crtl + / " to comment whole block

}
