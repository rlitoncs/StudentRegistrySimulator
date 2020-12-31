// Ralph Liton 500958086
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Set;
import java.util.TreeMap;
class ExceptionH extends RuntimeException
	{
		public ExceptionH(String message)
		{
			super(message);
		}
	}

public class Scheduler 
{

		
    // In main() after you create a Registry object, create a Scheduler object and pass in the courses ArrayList/TreeMap
	// If you do not want to try using a Map then uncomment
	// the line below and comment out the TreeMap line
	
	//ArrayList<Student> students;

	TreeMap<String,ActiveCourse> course; 	// contains the courses treemap from registry
	ArrayList<String> days = new ArrayList<String>();		//holds the days
	ArrayList<String> errorDays = new ArrayList<String>();  // holds the error days 
	public String Code = ""; 
	public String[][] sched = {{"","Mon","Tue","Wed","Thu","Fri"}, //array to print
	{"08:00","","","","",""},
	{"09:00","","","","",""},
	{"10:00","","","","",""},
	{"11:00","","","","",""},
	{"12:00","","","","",""},
	{"13:00","","","","",""},
	{"14:00","","","","",""},
	{"15:00","","","","",""},
	{"16:00","","","","",""}};

	public Scheduler(TreeMap<String,ActiveCourse> courses)
	{
	  this.course = courses;
	}
	
	
	public void setDayAndTime(String courseCode, String day, int startTime, int duration) 
	{
		Code = courseCode;

		days.add("Mon"); days.add("Tue"); days.add("Wed"); days.add("Thu"); days.add("Fri");
		errorDays.add("mon"); errorDays.add("tue"); errorDays.add("wed"); errorDays.add("thu"); errorDays.add("fri"); 
	

		if (!(course.containsKey(courseCode)))
		{
			throw new ExceptionH("Unknown course: " + courseCode);
		}
		if (!(days.contains(day)))
		{
			if(errorDays.contains(day))
			{
				System.out.println();
				System.out.println("Please Ensure that the first letter is Capitalized: " + day + " --> " + day.substring(0,1).toUpperCase() + day.substring(1, day.length()));
				throw new ExceptionH("Invalid Lecture Day: " + day);
			}
			else
			throw new ExceptionH("Invalid Lecture Day: " + day);
		}

		if (startTime < 800 || startTime > 1600 || startTime + (duration*100) - 100 > 1600)
		{
			throw new ExceptionH("Invalid Lecture Start Time");
		}
		if (duration <= 0 || duration > 3)
		{
			throw new ExceptionH("Invalid Lecture Duration");
		}
		
		

		else 
		{
			
			course.get(courseCode).setlectureDay(day);
			course.get(courseCode).setStartTime(startTime);
			course.get(courseCode).setlectureDuration(duration);

			Set<String> keys  = course.keySet();
			for (String x: keys) //CPS209 CPS511 CPS643
			{
				if (!(x.equals(courseCode)))							
					{
						
						if(course.get(x).getlectureDay().equals(day))	//checks if the other course lecture days equals the current course lecture day
						{
							for (int i = 1; i <= course.get(x).lectureDuration; i++)																			 // (1*100) is used to get the start of the Time
							if(course.get(x).lectureStart == startTime || course.get(x).lectureStart + (i * 100) - 100 == (1* 100) + startTime - 100 )			 // it's minus 100 because the startTime is inclusive 
								throw new ExceptionH("Lecture Time collision");																					// if the minus 100 wasn't there then it would be (for ex: 0800 + (2*100) would equal 1000 but the duration is 0800 to 0900)
																																			
						}

					}
			 }

			 int col = 0; // holds column of day
			 int row = 0; // holds row of time
			// int row = 0;
			 for (int i = 0; i < 1 ; i++)
				 for (int j = 0 ; j < 6; j++)
				 {
					 if (course.get(Code).lectureDay.equals(sched[i][j]))			//checks if the current course lecture day matches with the day in the grid
				 		{
							 col = j;
						}	
				 }
			
			String lectureStart = String.valueOf(course.get(Code).lectureStart);
			if (lectureStart.length() == 3)
				{
					char zero = '0';
					lectureStart = zero + lectureStart;
					lectureStart = lectureStart.substring(0,2) + ":" + lectureStart.substring(2, lectureStart.length()); 
				}
			else 
				{
					lectureStart = lectureStart.substring(0,2) + ":" + lectureStart.substring(2, lectureStart.length());
				}
				
	
			for (int i = 1; i < 10 ; i++)
			{
				for (int j = 0 ; j < 6; j++)
				{
					if (String.valueOf(lectureStart).equals(sched[i][j]))	// checks if the current course Startime matches with the time in the grid
					{
						row = i;
						if (sched[row][col] == "")
							sched[row][col] = Code;
							for (int x = 0 ; x < course.get(Code).lectureDuration ; x++)
								sched[row++][col] = Code;
	
					}			
	
					
				}	

			} 
			
		} 
			
}
	
	public void clearSchedule(String courseCode)
	{
	
		if (course.containsKey(courseCode))
		{
			Code = courseCode;
			course.get(courseCode).setlectureDay(""); 
			course.get(courseCode).setStartTime(0);
			course.get(courseCode).setlectureDuration(0);
		//
		}
		

		
	}
		
	public void printSchedule()
	{
		
		if (Code == "")
			{
				for (int i = 0; i < 1 ; i++)
					for (int j = 0 ; j < 6; j++)
						System.out.print(sched[i][j] + "\t" + " ");
				
				for (int i = 1; i < 10 ; i++)
				{
					System.out.println();
					for (int j = 0 ; j < 6; j++)		
						System.out.print(sched[i][j] + "\t");
				} 

			}
		else
		{
			for (int i = 0; i < 1 ; i++)
				for (int j = 0 ; j < 6; j++)
				System.out.print(sched[i][j] + "\t" + " ");
		
			for (int i = 1; i < 10 ; i++)
			{
				System.out.println();
				for (int j = 0 ; j < 6; j++)
				{		
					
					if(Code.equals(sched[i][j]))	
					{
						if (course.get(Code).lectureDay.equals(""))				// clears the sched when command CSCH is called
							sched[i][j] = course.get(Code).lectureDay;
					}

					System.out.print(sched[i][j] + "\t");
				}
			} 
		}
		
	
	}
	
}

