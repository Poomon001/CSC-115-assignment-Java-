/**Poomrapee Chuthamsatid V00942601**/
/**17 March 2020**/
/*
 * HeapPriorityQueue.java
 *
 * An implementation of a minimum PriorityQueue using a heap.
 * based on the implementation in "Data Structures and Algorithms
 * in Java", by Goodrich and Tamassia
 *
 * This implementation will throw a Runtime, HeapEmptyException
 *	if the heap is empty and removeLow is called.
 *
 * This implementation will throw a Runtime, HeapFullException
 *	if the heap is full and insert is called.
 *
 */

public class HeapPriorityQueue implements PriorityQueue {
    
    protected final static int DEFAULT_SIZE = 10000;

    protected Comparable[] storage;
    protected int currentSize;

    /* constructor
     *
     * PURPOSE:
     *  initializes storage to new Comparable[] of DEFAULT_SIZE
     *      and initializes currentSize to 0
     *
     * PARAMETERS:
     *  none
     */
    public HeapPriorityQueue () {
    	this.storage = new Comparable [DEFAULT_SIZE];
    	this.currentSize = 0;
    }//constructor1
    
    /* constructor
     *
     * PURPOSE:
     *  initializes storage to new Comparable[] of given size
     *      and initializes currentSize to 0
     *
     * PARAMETERS:
     *  int size
     */
    public HeapPriorityQueue (int size) {
    	this.storage = new Comparable [size];
    	this.currentSize = 0;
    }//constructor2

    
    /*
   	 * PURPOSE:
   	 *	Remove highest priority element from the PriorityQueue, 
   	 *	where the smallest value will be of highest priority.
   	 *
   	 * PRECONDITIONS:
   	 *	None.
   	 *
   	 * RETURNS:
   	 *	Comparable - the highest priority object in the Queue
   	 *
   	 * Examples:
   	 * 	If q contains elements that would be accessed in the 
   	 * 	following order:  {5,13,21},  q.removeLow() returns 5,
   	 * 	and then q will contain elements that will be accessed
   	 * 	in the following order: {13,21}.
   	 *
   	 */
    public Comparable removeLow (){
    	//if the top doesnt remove, this is true
    	boolean check = true;
    	
    	if(isEmpty()) {
    		throw new HeapEmptyException();
    	}	
    	
    	//count	is to store a current position
    	int count = 0;
    	
    	//store target
    	Comparable target = storage[0];
			
		//replace head with the last element
    	storage[0] = storage[currentSize-1];
    	
    	//remove head
    	storage[currentSize-1] = null;
    	
    	try {
    		//while a parent value is greater 
	    	while((storage[left(count)] != null)) {
	    		
	    		//right child is null
	    		if(storage[right(count)] == null) {
	    			
	    			//if current parent storage is more than its left child, move the parent to down left and move left child to be parent
	    			if(storage[(count)].compareTo(storage[left(count)]) >= 0) {
		    			Comparable parent = storage[(count)];
		    			storage[(count)] = storage[left(count)];
		    			storage[left(count)] = parent;
		    			count = left(count);
	    			}else {
	    				break;
	    			}//else
	    			
	    			//if current parent storage is more than its left child, move the parent to down left and move left child to be parent
	    		}else if((storage[left(count)].compareTo(storage[right(count)]) <= 0)) {
	    			
	    			//if current parent storage is more than its left child
	    			if(storage[(count)].compareTo(storage[left(count)]) >= 0) {	
	    				Comparable parent = storage[(count)];
		    			storage[(count)] = storage[left(count)];
		    			storage[left(count)] = parent;
		    			count = left(count);
	    			}else{
	    				break;
	    			}//if
	    			
		    	//else right value is less than left value
	    		}else if (storage[right(count)].compareTo(storage[left(count)]) < 0 ){
	    			
	    			//if current parent storage is more than its right child, move the parent to down right and move left child to be parent
	    			if(storage[(count)].compareTo(storage[right(count)]) >= 0) {
		    			Comparable parent = storage[(count)];
		    			storage[(count)] = storage[right(count)];
		    			storage[right(count)] = parent;
		    			count = right(count);
	    			}else{
	    				break;
	    			}//if
	    			
	    		}//else
	   
    		}//while
    	}catch(Exception e){
    		
    	}//catch
    	//}//else
    	
    	//remove size by 1
    	currentSize -= 1;
    	
    	return target;
    	
		
    }//removeLow
    
    /*
	 * PURPOSE:
	 *	Adds element into the PriorityQueue at the position
	 *	according to the element's priority 	.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *	None.
	 *
	 * Examples:
	 * 	If q contains elements that would be accessed in the 
	 * 	following order:  {5,13,21} after q.insert(20) returns,
	 * 	then q will contain elements that will be accessed
	 * 	in the following order: {5,13,20,21}.
	 *
	 */
    //heap starts at 0
    public void insert ( Comparable element ) throws HeapFullException{
    	int count = 1;
    	
    	//check if it is full
    	if(currentSize >= storage.length) { 
    		throw new HeapFullException();
    	}//if
    	
    	if(currentSize == 0) {
    	//put element to storage
    		storage[currentSize] = element;
    	}else {
    		//put element to storage
    		storage[currentSize] = element;
    		
    		Comparable parentValue;
    		Comparable value = storage[currentSize];
    		int count2 = currentSize;
	    	//sort heap
	    	//compare if the current value if it less than its parent, if yes, swap
    		//current value is in the index of its parent && comapre to index of its parent again*** (swap both value and index)
	    	while((storage[count2].compareTo(storage[parent(count2)]) < 0)) {
	    		//System.out.println("Parent is: " + storage[parent(count2)] + " Current is: " + storage[count2]);
	    		
	    		//store parent value
   	    		parentValue = storage[parent(count2)];
   	    		
   	    		//move current value up, replacing its parent
	    		storage[parent(count2)] = storage[count2];
	    		
	    		//move parent value down to its child position
	    		storage[count2] = parentValue;
	    		
	    		//System.out.println("Parent is: " + storage[parent(count2)] + " Current is: " + storage[count2]);
	    		
	    		//assign parent position to the current index position (so the current added value position is updated to be its parent position)
	    		count2 = parent(count2);//***
	    	}//while
    	}//else
    	
    	//increase size by 1
    		currentSize += 1;
    }//insert

	private int parent(int size) {
		// TODO Auto-generated method stub
		return (size - 1)/2;
	}

	private int right(int size) {
		// TODO Auto-generated method stub
    	return (2*size)+2;
	}

	private int left(int size) {
		// TODO Auto-generated method stub
		return (2*size)+1;
	}//left

	//if it is left child
	private boolean isLeft(int pos) {
		// TODO Auto-generated method stub
		 if (pos >= (currentSize - 1)/2 && pos <= currentSize) { 
	            return true; 
	        } 
	        return false; 
	}

	/*
     * PURPOSE:
     *    constructs a String representation of the elements in storage
     *      ordered by their position in storage NOT by priority 
     *
     * PARAMETERS:
     *    None.
     *
     * RETURNS:
     *    String - the String representation
     *
     */
    public String toString() {
        String s = "";
        String sep = "";
        for(int i=0;i< currentSize;i++) {
            s+= sep + storage[i];
            sep = " ";
        }
        return s;
    }

    
    /*
	 * PURPOSE:
	 *	Determines if the PriorityQueue is empty or not.
	 *
	 * PRECONDITIONS:
	 *	none
	 *
	 * RETURNS:
	 *	true if PriorityQueue is empty, false otherwise.
	 *
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return storage[0] == null;
	}

	
	/*
	 * PURPOSE:
	 *	Determines number of elements in the PriorityQueue.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * RETURNS:
	 *	the size of the PriorityQueue.
	 *
	 */	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return currentSize;
	}

}