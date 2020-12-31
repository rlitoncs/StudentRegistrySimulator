
// Ralph Liton 500958086
public class Course 
{
	private String code;
	private String name;
	private String description;
	private String format;
	   
	public Course()
	{
	  this.code        = "";
	  this.name        = "";
	  this.description = "";
	  this.format      = "";
	}
	   
	public Course(String name, String code, String descr, String fmt)
	{
	  this.code        = code;
	  this.name        = name;
	  this.description = descr;
	  this.format      = fmt;
	}

	public String getCode()
	{
	   return code;
	}
	   
	public String getName()
	{
	  return name;
	}
	   
	public String getFormat()
	{
	  return format;
	}
	   
	public String getDescription()
	{
	  return code +" - " + name + "\n" + description + "\n" + format;
	}
	
	 public String getInfo()
	 {
	   return code +" - " + name;
	 }

	 public String getDescr() 
	{
		return description;
	}
	 
	/**
	 Converts the Numeric of the student into a Letter Grade
	 e.g. 91 --> "A+"
	 @param score the numeric Grade of student
	 @return the letter Grade of the given score
	 */
	 public static String convertNumericGrade(double score)		// passes in a numeric Grade
	 {
		if (score >= 90)
			return "A+";
		if (score >= 85)
			return "A";
		if (score >= 80)
			return "A-";
		if (score >= 77)
			return "B+";
		if (score >= 73)
			return "B";
		if (score >= 70)
			return "B-";
		if (score >= 67)
			return "C+";
		if (score >= 63)
			return "C";
		if (score >= 60)
			return "C-";
		if (score >= 57)
			return "D+";
		if (score >= 53)
			return "D";
		if (score >= 50)
			return "D-";
		else return "F";

	 }
	 
}
