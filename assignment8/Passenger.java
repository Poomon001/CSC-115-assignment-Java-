/**Poomrapee Chuthamsatid V00942601**/
/**17 March 2020**/
/*
 * represents an airline passenger
 *
 * we have implemented some methods and constructors.
 * we have left the documentation for you to follow
 * to implement the compareTo and equals methods
 */

public class Passenger implements Comparable<Passenger>{
    
    private int boardingZone;
    private String name;
    private String passport;
    private Time checkinTime;
    
    public Passenger(int boardingZone, String name, String passport, Time checkinTime) {
        this.boardingZone = boardingZone;
        this.name = name;
        this.passport = passport;
        this.checkinTime = checkinTime;
    }
    
    public int getBoardingZone () {
        return boardingZone;
    }
    
    public void setBoardingZone (int boardingZone) {
        this.boardingZone = boardingZone;
    }
    
    public String getName () {
        return name;
    }
    
    public void setName (String name) {
        this.name = name;
    }
    
    public String getPassport () {
        return passport;
    }
    
    public void setPassport (String passport) {
        this.passport = passport;
    }
    
    public Time getTime () {
         return checkinTime;
     }
     
     public void setTime (Time checkinTime) {
         this.checkinTime = checkinTime;
     }
     
    
    public String toString() {
        return passport + ": " + name;
    }
    
    
    /* Method Name: compareTo
     * Purpose: returns the result of comparing this boardingZone and
     *    other boardingZone if they are not equal
     *  if boardingZones are equal, it returns the result of comparing
     *   this checkinTime to other checkinTime
     *
     * Parameters: Passenger other
     *
     * Precondition: other is not null
     *
     * Returns:
     *  a value <0 if this Passenger is before other passenger
     *  a value ==0 if this Passenger is the same as other passenger
     *  a value >0 if this Passenger is after other passenger
     *
     * HINT: the Time class implements compareable too!
     *
     */
    public int compareTo(Passenger other) {
    	
    	//check this boardding zone and other boarding zone are equal 
    	if(this.boardingZone != other.boardingZone) {
    		
    		// this boarding zone is less than other boarding zone
    		if(this.boardingZone < other.boardingZone) {
    			return -1;
    			
    	    //this boarding zone is more than the other boarding zone
    		}else {
    			return 1;
    		}//else
    		
    	//boarding zone is equal	
    	}else {
    		
    		// this checkinTime is less than other checkinTime
    		if(this.checkinTime.compareTo(other.checkinTime) < 0) {
    			return -1;
    			
    	    //this checkinTime is more than the other checkinTime
    		}else if(this.checkinTime.compareTo(other.checkinTime) > 0){
    			return 1;
    			
    		//this checkinTime is equal to the other checkinTime	
    		}else {
    			return 0;
    		}//else
    	}//else
    }//passenger
    
    
    /* Method Name: equals
     * Purpose: determines whether the passport of this Passenger
     *      is the same as other Passenger
     *
     * Parameters: Passenger other
     *
     * Precondition: other is not null
     *
     * Returns: true if this Passenger is the same as other, false otherwise
     */
    public boolean equals(Passenger other){
    	
    	//check if this passport is same as other passport
    	if(this.getPassport().compareTo(other.getPassport()) == 0) {
    		return true;
    	}else {
    		return false;
    	}//if
    }//equals
    
    

}
