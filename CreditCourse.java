// Ralph Liton 500958086
public class CreditCourse extends Course
{
	private String semester;
	public double grade;
	public boolean active;

	// add a constructor method with appropriate parameters
	// should call the super class constructor
	public CreditCourse(String name, String code, String descr, String fmt,String semester, double grade)
	{
		// add code
		super(name, code, descr, fmt);
		this.semester = semester;
		this.grade = grade;

	}
	
	public String getSemester()
	{
		return semester;
	}
	
	public double getGrade()
	{
		return grade;
	}
	
	public boolean getActive()
	{
		
		return active;
	}
	
	public void setActive()
	{
		active = true;
		
	}
	
	public void setInactive()
	{
		active = false;
		
	}
	
	public String displayGrade()
	{
		return convertNumericGrade(this.grade);
	}
	
}