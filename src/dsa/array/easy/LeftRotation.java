/***************************************************************************************************
 * Given an array of 'n' integers and a number 'd', perform 'd' left rotations on the array.
 * 
 * Detailed problem summary can be found at:
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 * 
 * Sample Input:
 *   Array: 1 2 3 4 5
 *   Shift Unit: 4
 * 
 * Sample Output:
 *   5 1 2 3 4
 *    
 **************************************************************************************************/

package dsa.array.easy;

public class LeftRotation {
	
	/**
	 * Brute Force Solution
	 * It doesn't copy elements to new array
	 * 
	 * Time Complexity: O(d*n)
	 */
	public static int[] rotateLeftV1(int[] a, int d) {
		int size = a.length;
		
		//meaningless if shift unit is greater than or equal to array size
		if (d >= size) {
			return a;
		}

		for (int i = 0; i < d; i++) {
			int tmp = a[0];
			for (int j = 0; j < size - 1 ; j++) {
				a[j] = a[j + 1];
			}
			a[size - 1] = tmp;
		}
		
		return a;
	}

	
	/**
	 * Optimized Solution
	 * It copies elements to a new array
	 * 
	 * Time Complexity: O(n)
	 */
	public static int[] rotateLeftV2(int[] a, int d) {
		int size = a.length;
		
		//meaningless if shift unit is greater than or equal to array size
		if (d >= size) {
			return a;
		}
		
		int[] rotatedArray = new int[size];

		int i = 0;
		
		//copy elements exist after the shift unit to a new array
		int rotateIndex = d;
		while (rotateIndex < size) {
			rotatedArray[i] = a[d];
			i++;
			rotateIndex++;
		}
		
		//copy elements exist after the shift unit to a new array
		rotateIndex = 0;
		while(rotateIndex < d) {
			rotatedArray[i] = a[rotateIndex];
			i++;
			rotateIndex++;
		}
		
		return rotatedArray;
	}
	
}
