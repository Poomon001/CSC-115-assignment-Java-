/**Poomrapee Chuthamsatid V00942601**/
/**10 Feb 2020**/
public class IntegerLinkedList implements IntegerList {


    private IntegerNode	head;
    private IntegerNode tail;
    private int		    count;



    //do I supposed to create "IntegerNode()" constructor in the IntegerNode class?????
    public  IntegerLinkedList() {
    	head = tail;
    	tail = head;
    	this.count = 0;
    }//constructor
    
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
	   //create new node
	   IntegerNode newNode = new IntegerNode(i);
	   
	   //if there is no element, assign head and tail to be new node
	   if(head == null) {
		   head = newNode;
		   tail = newNode;
	   }else {
		   //remember that it will be in an order newNode -> head -> tail!!!!! 
		   
		   //point newNode.next to head
		   newNode.next = head;
		   
		   //point head.prev to newNode
		   head.prev = newNode;
		   
		   //switch position of head to be the first one
		   head = newNode;
	   }//if
	   
	   //count one element
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
   //which one is correct?????
   public void addBack (int i) {
	   
	   //create new node
	   IntegerNode newNode = new IntegerNode(i);
	   
	   //if there is no element, let head and tail be new node
	   if(head == null) {
		   head = newNode;
		   tail = newNode;
		   head.prev = null;
		   tail.prev = null;
	   }else{
		   
		   //point tail.next to new node
		   tail.next = newNode;
		   
		   //point newNode.prev to the tail
		   newNode.prev = tail;
		   
		   //switch from head -> tail -> newNode to head -> newNode -> tail
		   tail = newNode;//$$$$$$$$$$$$$$$whaat will happen
	   }//else
	   
	   	   //count one moe element
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
	   
	   //return number of node
	   return count;
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
	   
	   //create dummy node of head
	   IntegerNode current = head;
	   int x = 0;
	   
	   //while next element is not null, and x is not the index, loop this  
	   while(x != position && current.next != null) {
		   
		   //shift to next node
		   current = current.next;
		   
		   //counting position
		   x++;
	   }//while   
	
	//return value at x position
	return current.getElement();
   }//getAtPosition
   
   
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
	   
	   //create new node
	   IntegerNode current = head;
	   int x = 0;
	   
	   //found no same element in the list
	   boolean notEmpty = false;
	   
	   //current value is not the one looking for and next element is not null
	   while(current.getElement() != i && current.next != null) {
		   
		   //shift line position
		   current = current.next;
		   
		   //count position
		   x++;
	   }//while 
	   
	   //if it contain the value and not empty 
	   if(current.getElement() == i && !(current.next == null && current.prev == null)) {
		   notEmpty = true;
	   }//if
	   
	   //return value is vaule is found the same, otherwise return -1
	   if(notEmpty) {
		   return x;
	   }else {
		   return -1;
	   }//if
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
	   
	   //create dummy of head
	   IntegerNode current = head;
	   int sum = 0;
	   
	   //if current is not null
	   if(current != null) {
		   
		   //loop throgh all elements in the list
		   for(int x = 0;x < count; x++) {
			   
			   //if can devide by the divisor
			   if(current.getElement()%divisor == 0) {
				   
				   //add sum
				   sum += current.getElement();
			   }//if  
			   
			   //shift to next element
			   current = current.next; 
		   }//for
	   }//if
	   
	   //return sum
	   return sum; 	   
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
	   
	   //create dummy of head
	   IntegerNode current = head;
	   int sum = 0;
	   
	   //if current is not null
	   if(current != null) {
		   for(int x = 0;x < count; x++) {
			   
			   //position is even
			   if(x%2 == 0) {
				   
				   //add the value of the even value
				   sum += current.getElement();
			   }
			   
			   //shift to next element
			   current = current.next;
		   }//for
	   }//if
	   
	   //return sum
	   return sum;
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
   //why the function doesnt work
   //past by value
   //how can i apply tail when removing data
   public void removeValue(int i) {
	   
	   //create dummy of head
	   IntegerNode current = head;
	   
	   //track position
	   int position = 0;
	   
	   //if the condition is met
	   boolean condition = false;
	
	   //codition if current is not null and position less than count
	   while(current != null && position <= count) {
		   
		   //if current element matches the given removal target
		   if(current.getElement() == i && count > 0) {
			   
			   //set condition to true
			   condition = true;
		   }//if
		   
		   	   //if condition is true
			   if(condition == true) {
				   
				   //remove one element from the list
				   count--;
			   }//if 
			   
			   //there is more than one
			   if(current.next != null && current.prev != null && condition == true) {
				   //middle removel of the node
				    current.prev.next = current.next;
				    current.next.prev = current.prev;
				    current = current.next;
				    
				    //set condition to false
				    condition = false;
			   }else
			   
			   if(position == count && condition == true){
				   //in the case of the removal of the last element
				   current.prev.next = null;
				   tail = current.prev;//did not point to like others but actually assign!
				   
				 //set condition to false
				   condition = false;
			   }else
			   
			   if(current.prev == null && current.next != null && condition == true) {
				   //in the case of the removal of the first element
				   current.next.prev = null;
				   head = current.next;
				   current = head;
				   
				 //set condition to false
				   condition = false;
				} else if(condition == false){
					
				//shift to next node
		       current = current.next;
		   }//if
		   
		   position++;
	   }//while
 
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
	   IntegerNode current = head;
	   String s = "";
	   if(current != null) {
		   for(int x = 0; x < count; x++) {
			   s += current.getElement(); 
			   current = current.next;
			   //add space
			   if(current != null ) {
				   s += " ";
			   }//if
		   }//for
	   }else {
		   return s;
	   }
	   return s;
   }//toString
    
    
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
        String s = "";
        IntegerNode tmp = tail;
        
        for (int x = 0; x < count; x++) {
            s += tmp.getElement();
            if(tmp.prev != null)
                s += " ";
            tmp = tmp.prev;
        }

        return s;

    }//reverse
    
 

}
