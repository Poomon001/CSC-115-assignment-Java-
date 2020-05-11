/**Poomrapee Chuthamsatid V00942601**/
/**24 Feb 2020**/
public class RecursiveIntegerLinkedList implements IntegerList {
    
    private IntegerNode head;
    private IntegerNode tail;
    private int	count;
    
    
    public RecursiveIntegerLinkedList(){
    	head = null;
    	tail = null;
    	count = 0;
    }
    /*
    *
    * Purpose: add i to the front of this list
    *  more space is allocated if necessary
    *  to add ito the list
    *
    * Parameters: int - i
    *
    * Returns: nothing
    *
    */
   public void addFront (int i) {
	   IntegerNode newE = new IntegerNode(i);
	   if(head == null && tail == null) {
		   //in the case of the first element
		   head = newE;
		   tail = newE;
	   }else {
		   newE.setNext(head);
		   head.setPrev(newE);
		   head = newE;
	   }//else
	   count++;
   }//addFront
   
/*
    *
    * Purpose: add i to the back of this list
    *  more space is allocated if necessary
    *  to add it to the list
    *
    * Parameters: int - i
    *
    * Returns: nothing
    *
    */
   public void addBack (int i) {
	   IntegerNode newE = new IntegerNode(i);
	   if(head == null && tail == null) {
		   //the first element
		   head = newE;
		   tail = newE;
	   }else {
		   //not the first element
		   newE.setPrev(tail);
		   tail.setNext(newE);
		   
		   //make the tail be the last element(newE that just added to the end)
		   tail = newE;
	   }//else
	   count++;
   }//addBack
   
   /*
    *
    * Purpose: returns the number of elements in this list
    *
    * Parameters: none
    *
    * Returns: int - the number of elements
    *
    */
   public int size () {
	   return this.count;
   }//size
   
   /*
    *
    * Purpose: returns the element at position
    *
    * Parameters: int - position
    *
    * Pre-Conditions:
    *     for a IntegerList x:
    *    position >= 0 AND
    *    position < x.size()
    *
    * Returns: int - the int at position
    *
    */
   public int getAtPosition (int position) {
	   
	   return getAtPosition(head, position);//**to here
   }//getAtPosition
   
   public int getAtPosition (IntegerNode n, int position) {
	   //half step go forward till the end
	   if(n == null) {
		   //defualt when there is an empty node
		   return 0;
	   } else if(count == 1) {
		   return n.getElement();
	   } else {
		   if(position == 0) {
			   return n.getElement();//*return a number from here
		   }else if(n.getNext() != null){
		       return getAtPosition(n.next, position-1);//**to the function called here
		   }//else
	   }//else
	   
	//default, doesn't necessary can be any number   
	return getAtPosition(n.next, position-1);
	   
   } 
   
   /*
    *
    * Purpose: return the position where i is in the list,
    *  if i is not found returns -1
    *
    * Parameters: int - i
    *
    * Returns: int - position of i, -1 if i does not exist
    *
    */
   public int getPositionOfVal (int i) {
	   
	   return getPositionOfVal (head, i, 0);//**to here
   }//getPositionOfVal
   
   public int getPositionOfVal (IntegerNode head, int i, int position) {
	   if(head == null && tail == null) {
		   return -1;
	   }else if(count == 1 && head != null && tail != null){
		   if(head.getElement() == i) {
			   return 0;
		   }//if
	   } else if(head != null && tail != null){
			   if(head.getElement() == i) {
				   return position;//*return a number from here
			   } else {
				  return getPositionOfVal(head.getNext(), i, position+1);//**to the function called here
			   }//else
	   }//else
	   
	   //default
	   return -1;
   }//getPositionOfVal
   /*
    *
    * Purpose: computes the sum of only elements in this list
    *      which hold values that are divisible by given divisor
    *
    * Parameters: none
    *
    * Returns: int - the sum
    *
    */
   public int sumDivisible (int divisor) {
	   return sumDivisible(head, divisor);//method 1 add some to parmeter
   }//sumDivisible
   
   public int sumDivisible (IntegerNode head, int divisor) {//3, -10, -6, 25, 35, 45
	   int sum;
	   if(head == null) {
		   return 0;
	   }else if(count == 1 && head != null && tail != null) {
		   if(head.getElement()%divisor == 0) {
			   return head.getElement();
		   }//if
	   }else if(head != null && tail != null){
		   if(head.getElement()%divisor == 0) {
			   sum = sumDivisible(head.next, divisor) + head.getElement();//method 2 declare sum here
			   return sum;
		   }//if
	   }//else
	   
	   //when it is not divisible, recall function
	   return sumDivisible(head.next, divisor);
   }//sumDivisible
   
   /*
    *
    * Purpose: computes the sum of only elements in this list
    *    at even positions within the list where, the the first
    *    element of the list is considered to be at position 0.
    *
    * Parameters: none
    *
    * Returns: int - the sum
    *
    */
   public int sumEvenPositionElements() {
	   return sumEvenPositionElements(head, 0, count);
   }
   public int sumEvenPositionElements(IntegerNode head, int position, int count) {//3, -10, -6, 25, 35, 45
	   if(head == null || position > count) {
		   return 0;
	   }else if(count == 1 && head != null && tail != null){
		   return 0;
	   }else if(head != null) {
		   if(position%2 == 0) {
			   int firstElement = head.getElement();
			   int sum = sumEvenPositionElements(head.getNext(), position+1, count);
			   return sum + firstElement;
		   }//if
	   }//else
	   return sumEvenPositionElements(head.getNext(), position+1, count);
   }//sumEvenPositionElements
   

   /*
    *
    * Purpose: remove all elements with i from the list
    *   The number of occurances of i can be >= 0
    *
    * Parameters: int - i
    *
    * Returns: nothing
    *
    */
   public void removeValue(int i) {
	    removeValue(head, i, 0);
   }
  
   public void removeValue(IntegerNode curr, int i, int position) {//2,3,4,5,6,4  #4
	
	   if(head == tail && curr != null && tail != null) {//head  = null
		   if(curr.getElement() == i) {
			   head = null;
			   tail = null;
			   count--;
		   }//if
		   return;
	   }//if
	   
	   if(curr != null && tail != null) {
		   if(curr == head && curr.getElement() == i) {
					//the first element
					curr.next.prev = null;
					head = curr.next;
					count--;
			}else if(curr.next == null && curr.getElement() == i) {	
					//last element
					curr.prev.next = null;
					tail = curr.prev;
					count--;
		   }else if(curr.getElement() == i) {    
				//to remove middle element
			    curr.next.prev = curr.prev;
			    curr.prev.next = curr.next;
				count--;
			 }//else
		     removeValue(curr.next, i, position+1);
	   }//else
	   
   }//removeValue
   

   
   
   /*
    *
    * Purpose: return a String representing the forward
    *  traversal of this list with a space between each element
    *
    * Parameters: none
    *
    * Returns: String - the forward list representation
    *
    */
   public String toString() {
	   return toString(head, 0);
   }//toString
   
   public String toString(IntegerNode head, int position) {//2,3,4,5  #4
	   String result;
	   if(position == count) {
		   return "";
	   }//if
	   if(head != null && tail != null) {
		   if(position != count-1) {
		   	  	result = head.getElement() + " ";
		   	  }else {
		   		result = head.getElement() + "";
		   	  }//else
		   return result + toString(head.next, position+1);
	   }//if
	   return "";
   }
   /*
    *
    * Purpose: return a String representing the reverse
    *  traversal of this list with a space between each element
    *
    * Parameters: none
    *
    * Returns: String - the reverse list representation
    *
    */
   public String reverse() {
	   return reverse(tail, 0);
   }//reverse
   public String reverse(IntegerNode tail, int position) {//2,3,4
	   String result;
	   if(position == count) {
		   return "";
	   }
	   if(tail != null) {
		   if(position == count-1) {
			   result =  tail.getElement() + "" + reverse(tail.getPrev(), position+1);
		   }else {
		 	   result =  tail.getElement() + " " + reverse(tail.getPrev(), position+1);
		   }//else	   
		   return result;
	   }//if
	   return "";
   }//reverse
}
