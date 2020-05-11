/**Poomrapee Chuthamsatid V00942601**/
/**3/2/2020**/
public class ExamSchedule {
    
    private String              sid;        // student unique sid
    private ExamListInterface	examlist;   // list of exams
    
    /* constructor
     *
     * Purpose: initialize this instance of ExamSchedule
     * 	with sid passed in and an empty ExamList
     * Parameters: String sid
     *
     */
    // ToDo:
    public ExamSchedule(String sid) {
    	examlist = new ExamArrayList();
    	this.sid = sid;
    }
    
    /*
     *
     * Purpose: initialize this instance of ExamSchedule
     *     with sid passed in and a new ExamList
     *     with e added to it
     * Parameters: String sid, Exam e
     *
     */
    // ToDo:
    public ExamSchedule(String sid, Exam e) {
    	examlist = new ExamArrayList();
    	this.sid = sid;
    	examlist.add(e);
    }
    
    
    /* getSid
     *
     * Purpose: return the sid associated with this instance
     *
     * Parameters: none
     *
     * Returns: String - the sid
     *
     */
    // ToDo:
    public String getSid() {
    	return this.sid;
    }
    
    
    /* setSid
     *
     * Purpose: change the sid associated with this instance to parameter value
     *
     * Parameters: String - sid
     *
     * Returns: nothing
     *
     */
    // ToDo:
    public void setSid(String sid) {
    	this.sid = sid;
    }
    
    /* getExamCount
     *
     * Purpose: return the number of Exams associated with this ExamSchedule
     *
     * Parameters: none
     *
     * Returns: int - the number of Exams
     *
     */
    // ToDo:
    public int getExamCount() {
    	return examlist.size();
    }
    
    /* addExams
     *
     * Purpose: add all exams to examlist
     *
     * Parameters: Exam[] exams
     *
     * Precondition: exams is not null
     *
     * Returns: void
     *
     */
    // ToDo:
    public void addExams(Exam[] exam) {
    	for(int x = 0; x < exam.length; x++) {
    		examlist.add(exam[x]);
    	}//for
    }
    
    
    /* removeExam
     *
     * Purpose: remove Exam with course from the list of Exams associated with this ExamSchedule
     *	if course is not in the list, do nothing.
     *
     * Parameters: String course
     *
     * Returns: nothing
     *
     */
    // ToDo:
    public void removeExam(String course) {
    	int x = examlist.find(course);
    	if(x != -1) {
	    	examlist.removeAtPos(x);
    	}//if
    }
    
    
    /* clearDay
     *
     * Purpose: removes all Exams from examlist that are on month, day, year
     *
     * Parameters: String month, int day, int year
     *
     * Precondition: month, day and year represent a valid Date
     *
     */
    // ToDo:
    public void clearDay(String month, int day, int year) {
    	Date d = new Date(month, day, year);
    	examlist.removeAllOnDate(d);
    }
    
    
    /* toString
     *
     * Purpose: return a String representation of this ExamSchedule
     *
     * Parameters: none
     *
     * Returns: String - the representation
     *
     */
    public String toString() {
        String s = sid;
        
        for (int i=0; i<examlist.size(); i++) {
            s += "\n";
            s += examlist.get(i);
        }
        return s;
    }
}
