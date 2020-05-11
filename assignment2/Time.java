/**Poomrapee Chuthamsatid V00942601**/
/**20/1/2020**/
/*
 * Time class
 *  represents time on a 24 hour clock in hours and minutes
 *  from 0:0 to 23:59
 */
public class Time {
	private int hour;
	private int minute;
    // TODO: add Time attributes/fields..

    /* Time
     * Purpose: Initialize this instance of Time with values for a time of 0:0
     *
     * Parameters: nothing
     */
    // TODO...
    public Time() {
    	this.hour = 0;
    	this.minute = 0;
    }//Time default


	/* Time
     * Purpose: Initialize this instance of Time with parameter values
     *
     * Parameters: int hour, int minute
     *
     * Precondition: hour and minute specify a valid time on a 24 hour clock
     */
    // TODO...
    public Time(int hour, int minute) {
    	this.hour = hour;
    	this.minute = minute;
    }//Time
    

    /* getHour
     * Purpose: Returns the hour associated with this Time
     *
     * Parameters: nothing
     *
     * Returns: (int) - hour associated with this Time
     */
    // TODO...
    public int getHour() {
    	return this.hour;
    }


    /* setHour
     * Purpose: sets the hour associated with this Time to parameter value
     *
     * Parameters: int hour
     *
     * Precondition: 0 <= hour <= 23
     *
     * Returns: nothing
     */
    // TODO...
    public void setHour(int hour) {
    	this.hour = hour;
    }


    /* getMinute
     * Purpose: Returns the minute associated with this Time
     *
     * Parameters: nothing
     *
     * Returns: (int) - minute associated with this Time
     */
    // TODO...
    public int getMinute() {
    	return this.minute;
    }


    /* setMinute
     * Purpose: sets the minute associated with this Time to parameter value
     *
     * Parameters: int minute
     *
     * Precondition: 0 <= minute <= 59
     *
     * Returns: nothing
     */
    // TODO...
    public void setMinute(int minute) {
    	this.minute = minute;
    }

    /* equals
     * Purpose: determines whether the hour and minute of
     *  this instance of Time is equal to other's hour and minute
     *
     * Parameters: Time other
     *
     * Precondition: other is not null and is a valid 24 hour clock time
     *
     * Returns: boolean - true if this Time equals other Time, false otherwise
     */
    // TODO...
    public boolean equals(Time other) {
    	
    	String time1 = "";
    	String s = other.toString();
    	int hour1 = 0;
    	/*
    	String[] arrOfStr = s.split(":");
    	int hour1 = Integer.parseInt(arrOfStr[0]);
    	String minute1 = arrOfStr[1].substring(0, arrOfStr[1].length()-2);
    	int minute2 = Integer.parseInt(minute1);
    	*/
    	
    	//set time to formatted string
    	if(this.hour >= 0 && this.hour < 12) {	
    		time1 = this.hour + ":" + this.minute + "am";
    	}else{
    		if(this.hour >= 12&&this.hour != 12) {
    			hour1 = this.hour - 12;
    		}//if
    		time1 = hour1 + ":" + this.minute + "pm";
    	}//else
    	
    	if(s.equals(time1)) {
    		return true;
    	}else {
    		return false;
    	}//else
    
    }//equals

    
    /* isBefore
     * Purpose: determines whether this instance of Time
     *   is strictly less that of other Time
     *
     * Parameters: Time other
     *
     * Precondition: other is not null and is a valid 24 hour clock Time
     *
     * Returns: boolean - true if this Time is before other Time, false otherwise
     */
    // TODO...
    public boolean isBefore(Time other) {
    	String s = other.toString();
    	String[] arrOfStr = s.split(":");
    	int hour1 = Integer.parseInt(arrOfStr[0]);
    	String minute1 = arrOfStr[1].substring(0, arrOfStr[1].length()-2);
    	int minute2 = Integer.parseInt(minute1);
    	if(this.hour < hour1) {
    		return true;
    	}//if
    	if(this.hour == hour1 && this.minute < minute2) {;
    		return true;
    	}else {
    		return false;
    	}//else
    }//isBefore


    
    /* addTime
     * Purpose: updates the values of this Time's hour and minute
     *  by adding the given minutes.
     *  The updated time is a valid 24 hour clock Time
     *
     * Parameters: int minutes
     *
     * Precondition: minutes >= 0
     *
     * Example:
     *  Time t = new Time(23, 30);
     *  t.addTime(70) will change t's hour to 0 and minute to 40
     *  This is because 23:30 == 11:30pm,
     *  we add 70 minutes (1 hr, 10 minutes) => 12:40am = 0:40 on 24 hour clock
     *  RECALL 00:00 is 12:00am which is midnight
     */
    // TODO...
    public void addTime(int minutes) {
    	this.minute += minutes;
    	while(this.minute >= 60) {
    		this.minute -= 60;
    		this.hour += 1;
    		if(this.hour >= 24) {
    			this.hour -= 24;
    		}//if
    	}//while
    }//addTime



    /* toString
     * Purpose: returns a String representing this Time formated as:
     *  hour:minute am/pm
     *
     * Parameters: nothing
     *
     * Returns: String - a representation of this Time
     *
     * Example:
     *  Time t = new Time(22, 2)
     *  t.toString() returns "10:2pm"
     *  NOTICE: ignore that the leading 0 is not printed in the minutes
     *  Time t = new Time(0, 22)
     *  t.toString() returns "0:22am"
     *  NOTICE: we are representing 0:00am as 0:0am, not 12:00am to simplify
     */
    // TODO...
    public String toString() {
    	int hour1 = 0;
    	if(this.hour >= 0 && this.hour < 12) {	
    		return this.hour + ":" + this.minute + "am";
    	}else if(this.hour >= 12){
    		if(this.hour != 12) {
    			hour1 = this.hour - 12;
    		}//if
    	}//else
    	return hour1 + ":" + this.minute + "pm";
    }
}
