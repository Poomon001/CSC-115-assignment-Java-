/**Poomrapee Chuthamsatid V00942601**/
/**13/1/2020**/
import java.lang.Math;

/*
 * ArrayOperations
 * DO NOT use builtin java Arrays mehthods
 * A class with basic array methods to
 *  - print the values in an array
 *  - calculate the product of the values in an array
 *  - calculate the minimum of the values in an array
 *  - calculate the maximum of the values in an array
 *  - determine the equality to 2 arrays
 *  -
 *
 */
public class ArrayOperations {
    /*
     * printArray
     *
     * Purpose: prints all the values in the array to the console
     *  example format:  {1,2,3,4}
     *
     * Parameters: an array of integers
     *
     * Returns: void
     *
     */
    public static void printArray ( int[] array ) {
        System.out.print("{");
        for(int i=0; i<array.length; i++) {
            
            System.out.print(array[i]);
            if(i<array.length-1)
                System.out.print(",");
        }
        
        System.out.println("}");
    }
    
    /*
     * arrayProduct
     *
     * Purpose: computes the product of all values in the input array
     *  NOTE: product of 3 numbers n1, n2 and n3 = n1*n2*n3
     *  NOTE: product of no numbers = 1
     *
     * Parameters: an array of integers
     *
     * Returns: product of all values in the array
     *
     */
    public static int arrayProduct ( int[] array ) {
        int product = 1;
        
        // TODO...
        for(int x = 0; x < array.length;x++) {
        	product = product*array[x];  
        }
        return product;
    }
    
    /*
     * arrayMax
     *
     * Purpose: finds the maximum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: maximum value in the array
     *
     */
    // TODO...
    public static int arrayMax(int [] array) {
    	int max = 0;
    	for(int x = 0; x < array.length; x++) {
    		//set max be the lowest value in array
    		if(array[x] < max) {
    			max = array[x];
    		}//if
    	}//for		
    		
    	for(int x = 0; x < array.length; x++) {	
    		//find the max value
    		if(max < array[x]) {
    			max = array[x];
    		}//if
    	}//for
    	return max;
    }//arrayMax
    
    /*
     * arrayMin
     *
     * Purpose: finds the minimum value in the input array
     *
     * Parameters: an array of integers
     *
     * Preconditions:
     *	array contains at least one element
     *
     * Returns: minimum value in the array
     *
     */
    // TODO...
    public static int arrayMin(int [] array) {
    	int min = 0;
    	for(int x = 0; x < array.length; x++) {
    		//set min to be the highest value in the array
    		if(min < array[x]) {
    			min = array[x];
    		}//if
    	}//for
    	
		for(int x = 0; x < array.length; x++) {
			//find the min from the array's elements
			if(min > array[x]) {
				min = array[x];
			}//if
    	}//for
    	
    	return min;
    }//arrayMin
    
    /*
     * arraysEqual
     *
     * Purpose: determines whether the two arrays are equal
     *      where equal means array1 and array2 are the same length
     *      and the contain the same values in the same order
     *
     * Parameters: two arrays of integers
     *
     * Returns: true if the are equal, false otherwise
     *
     */
    // TODO...
    public static boolean arraysEqual(int [] array1, int [] array2) {
    	boolean check = false;
    	if(array1.length == array2.length) {
	    	for(int x  = 0; x < array1.length; x++) {
	    		if(array1[x] == array2[x]) {
	    			check = true;
	    		}else {
	    			check = false;
	    			return check;
	    		}//else
	    	}//for
	    }else {
	    	check = false;
	    	return check;
	    }//else
    	return check;
    }//arraysEqual
    
    /*
     * arrayRange
     *
     * Purpose: determines the range of values in inputArray
     *  as the lowest value and the highest value in the inputArray
     *
     * Parameters: int[] - array of integers
     *
     * Preconditions:
     *    inputArray contains at least one element
     *
     * Returns: int[] - a 2 element array with the lowest and highest values
     *  found in inputArray at index 0 and 1 respectively of the result array
     *
     */
    // TODO...
    public static int[] arrayRange(int [] array) {
    	int min = arrayMin(array);
    	int max = arrayMax(array);
    	int[] intArray = new int[2];
    	intArray[0] = min;
    	intArray[1] = max;
    	
    	return intArray;
    	
    }//arrayRange
    
    /*
     * areAllAbove
     *
     * Purpose: determines whether all values in array are above threshold
     *
     * Parameters: int[] - array of integers
     *             int - threshold that numbers must be above
     *
     * Returns: boolean - true is all are above, false otherwise
     *
     */
    // TODO...
    public static boolean areAllAbove(int [] array, int threshold) {
    	boolean result = true;
    	for(int x = 0; x < array.length; x++) {
    		if(threshold >= array[x]) {
    			result = false;
    		}//if
    	}//for
    	return result;
    }//areAllAbove
    
    /*
     * contains
     *
     * Purpose: determines whether the values in lookingFor are strictly
     *  contained in searchArray in the same order
     *
     * Parameters: int[] - array of integers being looked for
     *             int[] - array of integers being looked in
     *
     * Returns: boolean - true is all are above, false otherwise
     *
     */
    // TODO...
    public static boolean contains(int [] array1, int [] array2) {
    	String str1 = "";
    	String str2 = "";
    	boolean result = false;
    	//get string of array1
    	for(int x  = 0; x < array1.length;x++) {
    		str1 = str1 + array1[x];
    	}//for
    	//get string of array2
    	for(int x  = 0; x < array2.length;x++) {
    		str2 = str2 + array2[x];
    	}//for
    	//check the result
    	if(str2.contains(str1)) {
    		result = true;
    	}else {
    		result = false;
    	}
    	
    	return result;
    }//contains
    
}
