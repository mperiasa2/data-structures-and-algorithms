/***************************************************************************************************
 * Given a 2D matrix, find the maximum sum of a hourglass. An hourglass is made
 * of 7 cells in below form.
 *   1 2 1
 *     0
 *   2 3 4
 *
 * Sample Input: 
 *   1 1 1 0 0 0
 *   0 1 0 0 0 0
 *   1 1 1 0 0 0
 *   0 0 2 4 4 0
 *   0 0 0 2 0 0
 *   0 0 1 2 4 0
 *          
 * Sample Output:
 *   19
 *   
 * In the above sample, the hourglass with maximum sum is:
 *   2 4 4
 *     2
 *   1 2 4
 *     
 **************************************************************************************************/

package dsa.array.easy;

public class HourGlassMaxSum {
	
	/**
	 * Time Complexity: O(n^2)
	 */
	public static int hourGlassMaxSum(int[][] matrix) {
		int len = matrix.length;
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i < len -2;  i++) {
			for (int j = 0; j < len - 2; j++) {
				int sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2] + 
						matrix[i+1][j+1] +
						matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
				if (maxSum < sum) {
					maxSum = sum;
				}
			}		
		}
		return maxSum;
	}

}
