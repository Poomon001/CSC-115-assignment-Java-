/**Poomrapee Chuthamsatid V00942601**/
/**5 April 2020**/
import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

    private long			getLoops;
    private long			putLoops;
    private int       tableSize;

    private List< List<Entry<K,V>> > 	table;
    private int			count;

    public HashMap() {
        tableSize = 1000003; // prime number
        table = new ArrayList<List<Entry<K,V>>>(tableSize);
        // initializes table as a list of empty lists
        for (int i = 0; i < tableSize; i++)
            table.add(new LinkedList<Entry<K,V>>());
        count = 0;

        resetGetLoops();
        resetPutLoops();
    }

    public long getGetLoopCount() {
        return getLoops;
    }

    public long getPutLoopCount() {
        return putLoops;
    }

    public void resetGetLoops() {
        getLoops = 0;
    }
    public void resetPutLoops() {
        putLoops = 0;
    }

    public boolean containsKey(K key) {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
 int listIndex = 0;
        
        List<Entry<K,V>> list = table.get(index);
        
        Iterator<Entry<K,V>> iter = list.iterator();
        while(iter.hasNext()) {
        	Entry<K,V> e = iter.next();
        	if(e.getKey().compareTo(key)==0) {
        		return true;
        	}//if
        }//while
        return false;
    }

    public V get (K key) throws KeyNotFoundException {
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode()) % tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
        
        int listIndex = 0;
        
        List<Entry<K,V>> list = table.get(index);
        
        Iterator<Entry<K,V>> iter = list.iterator();
        while(iter.hasNext()) {
        	Entry<K,V> e = iter.next();
        	if(e.getKey().compareTo(key)==0) {
        		return e.getValue();
        	}//if
        }//while
        
        throw new KeyNotFoundException();

    }

    public List<Entry<K,V> >	entryList() {
        List <Entry<K,V>> l = new LinkedList<Entry<K,V>>();
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through every index in the table
        //      use a second Iterator to go through each element in a chain at a specific index
        //      and add each element to l
        
        //store index of colunb
        int index1 = 0;
        boolean f = true;
        
        //loop through each column of table, exit if equal to table size
        while(index1 < tableSize-1) {
        	
        	//increment column by 1
        	index1++;
        	
        	//use Java's List and Iterator operations to go through every index in the table
        	List<Entry<K,V>> list = table.get(index1);
            Iterator<Entry<K,V>> iter = list.iterator();
            
           //exit it there is no next entry (key and value)
            while(iter.hasNext()) {
            	
            	//set nextEntry to a current iter
    	        Entry<K,V> nextEntry = iter.next();
    	        
    	        //if the target entry is not null
    	        if(nextEntry != null) {
    	        	
    		        //add the nextEntry to the return list (l)
    		        l.add(nextEntry);
    	        }//if
            }//while
        }//while
        return l;
    }

    public void put (K key, V value){
        // gets the index in the table this key should be in
        int index = Math.abs(key.hashCode())%tableSize;
        // TODO... complete this method
        // Tip: use Java's List and Iterator operations to go through a chain at a specific index
        //  if key is found, update value.  if key is not found add a new Entry with key,value
        
        //save an item of the index to "list"
        List<Entry<K,V>> list = table.get(index);
        boolean isFound = false;
        
        Iterator<Entry<K,V>> iter = list.iterator(); 
        
        //use Java's List and Iterator operations to go through a chain at a specific index
        while(iter.hasNext()) {
        	//if key is found, update value.
        	if(iter.next().key.compareTo(key) == 0) {
        		list.get(0).setValue(value);
        	}//if
        	isFound = true;
        }//while
        
        //if key is not found add a new Entry with key,value
        if(!isFound) {
        	Entry<K,V> newPair = new Entry<K,V>(key, value);
        	
        	//list.set(1, newPair);
        	list.add(newPair);
        	table.set(index, list);
        	
        	//add 1 to the count
        	count++;
        }//if
        
        //set this count to count2
    }//put

    public int size() {
        return count;
    }

    public void clear() {
        table.clear();
        count = 0;
    }

}
