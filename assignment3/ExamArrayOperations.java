/**Poomrapee Chuthamsatid V00942601**/
/**27/1/2020**/
import java.lang.Math;

/*
 * ExamArrayOperations
 */
public class ExamArrayOperations {
    
    /*
     * getAllExamLocations
     *
     * Purpose: creates a new array of the locations of all of the exams in the given array
     *
     * Parameters: Exam[] - array
     *
     * Returns: String[] - new array of Exam locations
     *
     */
    // TODO:
	public static String[] getAllExamLocations(Exam [] exam) {
		String [] s = new String[exam.length];
		for(int x = 0; x < exam.length; x++) {
			s[x] = exam[x].getLocation();	
		}//for
		
		return s;
	}//getAllExamLocations
    
    
    /*
     * getExamDuration
     *
     * Purpose: gets the duration of the Exam in the given array that is
     *  at the given location.
     * If there is more than one exam at the given location,
     *  it gets the location of the first encountered in the given array.
     *
     * Parameters: Exam[] - array, String - location
     *
     * Returns: int - the duration of the Exam or 0 if Exam location is not found
     *
     */
    // TODO:
    public static int getExamDuration(Exam[] exam, String s) {
    	for(int x = 0; x < exam.length;x++) {
	    	if(s.equals(exam[x].getLocation())) {
	    		return (exam[x].getDuration());
	    	}//if
    	}//for
    	return 0;
    }//getExamDuration
    
    /*
     * addExam
     *
     * Purpose: creates a new array 1 longer than input array and copies all Exam references
     *  from input array to new array and puts e at the end of new array
     *
     * Parameters: Exam[] - array, Exam - e
     *
     * Preconditions:  e is not null
     *
     * Returns:  Exam[] - the new array
     *
     */
    // TODO:
    public static Exam[] addExam(Exam[] exam1, Exam exam2) {
    	Exam [] exam3 = new Exam [exam1.length+1];
    	int x = 0;
    	for(x = 0; x < exam1.length; x++) {
    		exam3[x] = exam1[x];
    	}
    	exam3[x] = exam2;
    	return exam3;
    }//addExam
    
    
    
    /*
     * countExamsOnDate
     *
     * Purpose: counts the number of Exams in array with specified Date
     *
     * Parameters: Exam[] - array, Date - date
     *
     * Returns: int - the count
     *
     */
    // TODO:
    public static int countExamsOnDate(Exam [] exam, Date date) {
    	int count = 0;
    	for(int x = 0; x < exam.length; x++) {
			if((exam[x].getDate().equals(date))) { 
				count++; 
			}//if			 
    	}//for
    	
    	return count;
    }//countExamsOnDate
    
    
    /*
     * removeExamsWithDate
     *
     * Purpose: if input array has Exams with the given date,
     *      returns a new array with only those Exams without the given date.
     *  The size of the new array must match the number of Exams
     *      without the given date in the given array.
     *  If the given array does not have an Exam with the given date,
     *      it returns the input array unchanged.
     *
     * Parameters: Exam[] - array, Date date
     *
     * Returns: Exam[] - new array
     *
     */
    // TODO:
    public static Exam[] removeExamsWithDate(Exam [] exam, Date date) {
    	int countExam = 0;
    	int y = 0;
    	int z = 0;
    
    	//find how many exam in that date
    	for(int x = 0; x < exam.length; x++) {
    		if(exam[x].getDate().equals(date)) {
    			countExam++;
    		}//if
    	}//for
    	
    	//declare new array
    	Exam [] newExam = new Exam[exam.length - countExam];
    	
    	//remove exam
    	while(y < exam.length) {
    		if(!(exam[y].getDate().equals(date))) {
    			newExam[z] = exam[y];
    			z++;
    		}//if
    		y++;
    	}//while	
    	return newExam;
    }//removeExamsWithDate
    
    
    /*
     * getEarliestTimeExam
     *
     * Purpose: get the Exam from array that has the earliest startTime
     *  If there is more than one Exam that is the earliest,
     *  use the first occurance of the earliest in array
     *
     * Parameters: Exam[] - array
     *
     * Precondition: array is not empty
     *
     * Returns: Exam - oldest Exam
     *
         	*/
    // TODO:
    public static Exam getEarliestTimeExam(Exam[] exam) {
    	int hourMin = 100;//store earliest hour
    	int minuteMin = 100;//store earliest hour
    	int minPosition = 0;//store index of earliest time
    	int hour = 0;//store hour
    	int minute = 0;//store minute

    	
    	for(int x = 0; x < exam.length; x++) {
    		
    		//get hour
	    	hour = exam[x].getStartTime().getHour();

	    	//get minute
	    	minute = exam[x].getStartTime().getMinute();
	    	
	    	//determine the index that contain the earilest time
	    	//check hour
	    	if(hour < hourMin) {
	    		hourMin = hour;
	    		if(minute < minuteMin) {
	    			minPosition = x;
	    		}//if
	    	}//if
    	}//for
    	return exam[minPosition];
    }//getEarliestTimeExam    
}
