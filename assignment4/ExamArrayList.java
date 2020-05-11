/**Poomrapee Chuthamsatid V00942601**/
/**3/2/2020**/
public class ExamArrayList implements ExamListInterface {
    
    private static final int INITIAL_CAPACITY = 2;
    
    private Exam[]	    storage;  // holds Exams, each with a unique course
    private int		    numExams;
    
    /*
     *
     * Purpose:
     *    Initialize a new instance of PlayerList
     *
     */
    public ExamArrayList() {
        // You must allocate an array to be able
        // to hold INITIAL_CAPACITY Exam objects
        // You must set numExams to be 0
    	this.storage = new Exam [0];
    	this.numExams = 0;
    }//ExamArrayList 
    /* get
    *
    * Purpose: returns the element at position
    *
    * Parameters: int - position
    *
    * Pre-Conditions:
    *     for a ExamList x:
    *    position >= 0 AND
    *    position < x.size()
    *
    * Returns: Exam - the Exam at position
    *
    */
   public Exam get (int position) {
	   return storage[position];
   }//get
   

   
   /* size
    *
    * Purpose: returns the number of elements in the list
    *
    * Parameters: none
    *
    * Returns: int - the number of elements
    *
    */
   public int size() {
	   return storage.length;
   }//size
   
   /* add
    *
    * Purpose: add Exam e to the Examlist
    *  more space is allocated for the Examlist if necessary
    *  to add e to the list
    *
    * Parameters: Exam e
    *
    * Returns: nothing
    *
    */
   public void add (Exam e) {
	   Exam [] newExam = new Exam[storage.length+1];
	   int x = 0;
	   for(x = 0; x < storage.length; x++) {
		   newExam[x] = storage[x];
	   }//for
	   newExam[x] = e;
	   storage = newExam;
   }//add
   
   /* find
    *
    * Purpose: return the position where Exam with given course is in the Examlist,
    *  if Exam with course is not found, returns -1
    *
    * Parameters: String course
    *
    * Pre-Conditions: course is not null
    *
    * Returns: int - position of Exam with course, -1 if it does not exist
    *
    */
   //course = number
   public int find (String course) {
	   for(int x = 0; x < storage.length; x++) {
	       if(course.toString().equals(storage[x].getCourse().toString())) {
	    	   return x;
	       }//if
	   }//for
	   return -1;
   }//find 
   
   /* removeAtPos
    *
    * Purpose: removes the element at position
    *
    * Parameters: int - position
    *
    * Pre-Conditions:
    *    for a ExamList x:
    *        position >= 0 AND
    *        position < x.size()
    *
    * Returns: nothing
    *
    */
   public void removeAtPos (int position) {
	   Exam [] newExam = new Exam [storage.length-1];
	   int x = 0;
	   for(int i = 0; i < storage.length;i++) {
		   if(i != position) {
			   newExam[x] = storage[i];
			   x++;
		   }//if
	   }//for
	   storage = newExam;
   }//removeAtPos
   
   /* removeAllOnDate
    *
    * Purpose: removes all Exams that are on given date
    *    from this ExamList
    *
    * Parameters: Date date
    *
    * Pre-Conditions: date is not null
    *
    * Returns: nothing
    *
    */
   public void removeAllOnDate (Date date) {
	   int finalIndex = 0;
	   int x = 0;
	   //find how many exam in that date
	      for(int i = 0; i < storage.length; i++) {
		      if(storage[i].getDate().toString().equals(date.toString())) {
		    	  finalIndex++;//number of date
		      }//if
	     }//for
	       Exam [] newArray = new Exam [storage.length - finalIndex];
		   for(int i = 0; i < storage.length;i++) {
			   if(!(storage[i].getDate().toString().equals(date.toString()))) {
				   newArray[x] = storage[i];
				   x++;
			   }//if
		   }//for
		   storage = newArray;  
		   
   }//removeAllOnDate
  
    
    /* toString
     *
     * Purpose: return a String representing the forward traversal
     *  with a space after each element
     *
     * Parameters: none
     *
     * Returns: String - the forward list representation
     *
     */
    public String toString() {
        String s = "";
        
        for(int i=0; i<numExams; i++) {
            s += storage[i];
            if(i != (numExams-1))
                s += " ";
        }
        
        return s;
    }

}
