/***************************************************************************************************
 * Reverse a linear array.
 * 
 * Sample Input : 1 2 3 4 5
 * Sample Output: 5 4 3 2 1
 *    
 **************************************************************************************************/

package dsa.array.easy;

public class ReverseArray {
	
	/**
	 * Time Complexity: O(n)
	 */
	public static int[] reverseArray(int[] a) {
		int len = a.length;
		for (int i = 0; i < len/2; i++) {
			//swap elements
			int tmp = a[i];
			a[i] = a[len - (i+1)];
			a[len - (i+1)] = tmp;
		}
		return a;
	}

}
