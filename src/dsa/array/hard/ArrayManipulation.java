/***************************************************************************************************
 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value
 * to each of the array element between two given indices (inclusive). Once all operations have been 
 * performed, return the maximum value from the array.
 * 
 * Detailed problem summary can be found at:
 * https://www.hackerrank.com/challenges/crush/problem
 * 
 * Sample Input:
 *   Array Size (n): 5
 *   Operations (m): 3
 *     1 2 100
 *     2 5 100
 *     3 4 100
 * 
 * Sample Output:
 *   200
 *    
 **************************************************************************************************/

package dsa.array.hard;

public class ArrayManipulation {
	
	/**
	 * Brute Force Solution
	 *  
	 * Time Complexity: O(m*n)
	 */
    public static long arrayManipulationV1(int n, int[][] queries) {
    	long maxValue = 0;
    	long[] valArray = new long[n];
    	
    	int m = queries.length;
    	
    	for (int i = 0; i < m; i++) { //iterate through no. of operations
    		int a = queries[i][0];
    		int b = queries[i][1];
    		int k = queries[i][2];
    		
    		for (int j = a - 1; j < b; j++) { // interate through array elements that need manipulation
    			valArray[j] += k;
    			maxValue = Math.max(maxValue, valArray[j]);
    		}
    	}
	
    	return maxValue;
    }
    
	/**
	 * Optimized Solution
	 * 
	 * It uses prefix sum approach
	 * 
	 * STEPS:
	 * 1. Iterate no. of operations (m)
	 * 2. Take the values of lower (a) and upper (b) array indices which need manipulation
	 *    and also the value to add (k)
	 * 3. Add value of 'k' at index 'a' and subtract 'k' from index 'b + 1'
	 * 4. Repeat steps 1 and 2 until all operations are completed
	 * 5. Compute prefix sum of the array and also scan for the max element of the array
	 *  
	 *   
	 * Time Complexity: O(m+n)
	 */
    public static long arrayManipulationV2(int n, int[][] queries) {
    	long maxValue = 0;
    	long[] valArray = new long[n];
    	
    	int m = queries.length;
    	
    	for (int i = 0; i < m; i++) { //iterate through no. of operations
    		int a = queries[i][0] - 1; //as our index starts at 0
    		int b = queries[i][1];
    		int k = queries[i][2];
    		
    		valArray[a] = valArray[a] + k;
    		//handle upper bound
    		if (b < n) {
    			valArray[b] = valArray[b] - k;
    		}
    	}

    	//prefix sum array
    	for (int i = 1; i < n; i++) { //iterating through of element of the array
    		valArray[i] = valArray[i - 1] + valArray[i];
    		maxValue = Math.max(valArray[i], maxValue);
    	}
	
    	return maxValue;
    }

}
