
/*
 * Exam class representing a scheduled exam
 */
public class Exam {
	private Date date;
	private String location;
	private Time startTime;
	private int duration;
    // TODO add Exam attributes/fields..

    /* Exam
     * Purpose: Initialize this instance of Exam with parameter values
     *  location is set to "TBA", duration is set to default 180 minutes
     *
     * Parameters: Date date, Time startTime
     *
     */
    // TODO...
	public Exam(Date date, Time startTime) {
		this.location = "TBA";
		this.duration = 180;
    	this.date = date;
    	this.startTime = startTime;
	}//Exam

    /* Exam
     * Purpose: Initialize this instance of Exam with parameter values
     *
     * Parameters: Date date, String location, Time startTime, int duration
     *
     */
    // TODO...
	public Exam(Date date, String location, Time startTime, int duration) {
    	this.date = date;
    	this.startTime = startTime;
    	this.location = location;
    	this.duration = duration;
}//Exam


    /* getDate
     * Purpose: Returns the date associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: Date - date associated with this Exam
     */
    // TODO...
    public Date getDate() {
    	return this.date;
    }


    /* setDate
     * Purpose: sets the date associated with this Exam to parameter value
     *
     * Parameters: Date date
     *
     * Returns: nothing
     */
    // TODO...
    public void setDate(Date date) {
    	this.date = date;
    }


    /* getLocation
     * Purpose: Returns the location associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: String - location associated with this Exam
     */
    // TODO...
    public String getLocation() {
    	return this.location;
    }


    /* setLocation
     * Purpose: sets the location associated with this Exam to parameter value
     *
     * Parameters: String location
     *
     * Returns: nothing
     */
    // TODO...
    public void setLocation(String location) {
    	this.location = location;
    }


    /* getStartTime
     * Purpose: Returns the startTime associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: Time - startTime associated with this Exam
     */
    // TODO...
    public Time getStartTime() {
    	return this.startTime;
    }


    /* setStartTime
     * Purpose: sets the startTime associated with this Exam to parameter value
     *
     * Parameters: Time startTime
     *
     * Returns: nothing
     */
    // TODO...
    public void setStartTime(Time startTime) {
    	this.startTime = startTime;
    }
    

    
    /* getDuration
     * Purpose: Returns the duration associated with this Exam
     *
     * Parameters: nothing
     *
     * Returns: int - duration associated with this Exam
     */
    // TODO...
    public int getDuration() {
    	return this.duration;
    }


    /* setDuration
     * Purpose: sets the duration associated with this Exam to parameter value
     *
     * Parameters: int duration
     *
     * Precondition: duration >= 60
     *
     * Returns: nothing
     */
    // TODO...
    public void setDuration(int duration) {
    	this.duration = duration;
    }



    /* isOverlap
     * Purpose: determines whether the date and time of this Exam
     *  overlaps with the other Exam date and time
     *
     * Parameters: Exam - other
     *
     * Precondition: other is not null
     *
     * Returns: boolean - true if this Exam overlaps with other, false otherwise
     *
     * HINT: instructor made use of addTime method in the Time class
     *  Be careful how you use it as it is an instance method that updates the instance data
     */
    // TODO...
    public boolean isOverlap(Exam other) {
    	//Store Exam other
    	String s1 = other.toString();
    	
    	//split s1 and store array String[]
    	String[] arrOfStr1 = s1.split(" ");
    	
    	//store month
    	String checkMonth = arrOfStr1[0];
    	
    	//store date
    	String checkDay = arrOfStr1[1].substring(0, arrOfStr1[1].length()-1);
    	  	
    	//store year
    	String checkYear = arrOfStr1[2].substring(0, arrOfStr1[2].length()-1);
    	
    	//combine month, day and year
    	String checkDate = checkMonth + " " + checkDay + ", " + checkYear;
    	
    	//split time 
    	String[] arrOfStr2 = arrOfStr1[5].split("-");
    	
    	//declare new variable to store am/pm
    	String pmOrAm1 = "";
    	String pmOrAm2 = "";
    	
    	//split hour and minute of starting time 
    	String[] arraOfStr3 = arrOfStr2[0].split(":");
    	
    	//split hour and minute of ending time 
    	String[] arraOfStr4 = arrOfStr2[1].split(":");
    	
    	//store other staring hour
    	int hour1 = Integer.parseInt(arraOfStr3[0]);//hour1
    	
    	//store other ending hour
    	int hour2 = Integer.parseInt(arraOfStr4[0]);//hour2
    	
    	//store other starting minute
    	int min1 = Integer.parseInt(arraOfStr3[1].substring(0, arraOfStr3[1].length()-2));
    	
    	//store other ending minute
    	int min2 = Integer.parseInt(arraOfStr4[1].substring(0, arraOfStr4[1].length()-2));

    	//get other starting am or pm 
    	pmOrAm1 = arrOfStr2[0].substring(arrOfStr2[0].length()-2);//am/pm of start
    	
    	//get other ending am or pm 
    	pmOrAm2 = arrOfStr2[1].substring(arrOfStr2[1].length()-2);//am/pm of end
    	
    	//declare new variable to store time 
    	int hour4 = 0;//this end hour
    	int minute3 = 0;//this end min
    	
    	//store this starting time in new string
    	String start = (this.startTime).toString();
    	
    	//split hour and minute of this starting time  
    	String[] arrOfStr = start.split(":");
    	
    	//store this starting hour and convert to int
    	int hour3 = Integer.parseInt(arrOfStr[0]);//this start hour
    	
    	//store this starting minute
    	String minute1 = arrOfStr[1].substring(0, arrOfStr[1].length()-2);
    	
    	//convert starting minute to int
    	int minute2 = Integer.parseInt(minute1);//start min
    	
    	//declare new variable
    	String pmOrAm3 = "";
    	
    	//store this starting am/pm
    	pmOrAm3 = arrOfStr[1].substring(arrOfStr[1].length()-2);
    	
    	//convert time to 24 hour clock
    	if(pmOrAm3.equals("pm") && hour3 != 12) {
    		hour3 += 12;
    	}//if
    	
    	//store this hour
    	hour4 = hour3;
    	
    	//store this minute
    	minute3 = minute2;

    	//convert to 24 hour clock
    	if(pmOrAm1.equals("pm") && hour1 != 12) {
    		hour1 += 12;
    	}
    	if(pmOrAm1.equals("am") && hour1 == 12) {
    		hour1 = 0;
    	}
    	if(pmOrAm2.equals("pm") && hour2 != 12) {
    		hour2 += 12;
    	}
    	if(pmOrAm2.equals("am") && hour2 == 12) {
    		hour2 = 0;
    	}//if
    	
    	//add duration to minute
    	minute3 += duration;
    	
    	//add duration to clock
    	while(minute3 >= 60) {
    		minute3 -= 60;
    		hour4 += 1;
    		if(hour4 >= 24) {
    			hour4 -= 24;
    		}//if
    	}//while
		
    	//check if time overlap
    	//check overlap date
    	if(checkDate.equals(this.date.toString())) {
    		//check overlap hour
    		if((hour3<hour1&&hour4>hour1)||(hour3>hour1&&hour3<hour2)||(hour3<hour1&&hour4>hour2)||
    				(hour1<hour3&&hour2>hour4)||(hour1==hour3&&hour2==hour4)||(hour1==hour3&&hour4<hour2)||
    				(hour1==hour3&&hour2<hour4)||(hour3<hour1&&hour4==hour2)||(hour1<hour3&&hour4==hour2)||
    				(hour3<hour1&&hour1==hour4)||(hour1<hour3&&hour3==hour2)) {
    			//check overlap minute
    			if((minute2<min1&&minute3>min1)||(minute2>min1&&minute2<min2)||(minute2<min1&&minute3>min2)||
    					(min1<minute2&&min2>minute3)||(min1==minute2&&min2==minute3&&(hour4!=hour1&&hour2!=hour3))||
    					(min1==minute2&&minute3<min2)||(min1==minute2&&min2<minute3)||(minute2<min1&&minute3==min2)||
    					(min1<minute2&&minute3==min2)) {
    				return true;//overlap
    			}//if
    		}//if
    	}//if
    	return false;//not overlap
    }//isOverlap


    /* toString
     * Purpose: returns a String representing this Exam formated as:
     *  date: location: startTime-endTime
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Exam
     *
     * Example:
     *  Exam e = new Exam(new Date("October",25,2019), "ECS 125", new Time(9,30), 120);
     *  e.toString() returns "October 25, 2019: ECS 125: 9:30am-11:30am"
     *
     * HINT: instructor made use of addTime method in the Time class
     *  Be careful how you use it as it is an instance method that updates the instance data
     */
    // TODO...
    public String toString() {
    	//get startTime and store in new string
    	String start = (this.startTime).toString(); 
    	
    	//store data
    	String s = start;
    	
    	//split this startTime
    	String[] arrOfStr = s.split(":");
    	
    	//convert hour to int
    	int hour1 = Integer.parseInt(arrOfStr[0]);
    	
    	//get this starting minute
    	String minute1 = arrOfStr[1].substring(0, arrOfStr[1].length()-2);
    	
    	//convert to this minute to int
    	int minute2 = Integer.parseInt(minute1);
    	
    	//declare new variable
    	String pmOrAm = "";
    	
    	//store pm or am
    	pmOrAm = arrOfStr[1].substring(arrOfStr[1].length()-2);
    	
    	//add duration to this minute
    	minute2 += duration;
    	
    	//calculate time 
    	while(minute2 >= 60) {
    		minute2 -= 60;
    		hour1 += 1;
    	}//while
    	
    	//assign am or pm
    	//if time is over 11, assign am
    	if(hour1 > 11) {
    		//if time is 12
			if(hour1 == 12) {
				if(pmOrAm.equals("am")) {
    				pmOrAm = "pm";
    				//if time is 12 pm, change to 1 am
    			}else { 
    				//if time is 12 am, change to 1 pm 
    				pmOrAm = "am";
    			}//if
			}//if
			
			//change time to 12 hour clock
			if(hour1 > 12) {
				//if time is or over 12 am, reduce by 12 and change to pm
    			if(pmOrAm.equals("am")) {
    				pmOrAm = "pm";
    				hour1 -= 12;
    			//if time is or over 12 pm, reduce by 12 and change to am
    			}else { 
    				pmOrAm = "am";
    				hour1 -= 12;
    			}//if
			}//if
		}//if
    	
    	//store ending time to a string
    	String endTime = hour1 + ":" +minute2 + pmOrAm;
    	return this.date + ": " + this.location + ": " + start + "-" + endTime;//return
    }//toString
}//Exam
