/***************************************************************************************************
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target. You may assume that each input would have exactly one solution, and you may not use the 
 * same element twice.
 * 
 * Detailed problem summary can be found at:
 * https://leetcode.com/problems/two-sum/
 *
 * Sample Input:
 *   Array : 2 7 11 15
 *   Target: 9
 *   
 * Sample Output:
 *   0 1
 *
 ***************************************************************************************************/

package dsa.array.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	/*
	 * This works well only on sorted array
	 * 
	 * Time Complexity: O(n)
	 */
	public static int[] twoSumV1(int[] nums, int target) {
		int[] result = new int[2];

		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			if (nums[low] + nums[high] == target) {
				result[0] = low;
				result[1] = high;
				return result;
			}
			else if (nums[low] + nums[high] > target) {
				high--;
			}
			else {
				low++;
			}
		}

		return result;				
	}

	/*
	 * This works great on unsorted array as well
	 * 
	 * Time Complexity: O(n)
	 */
	public static int[] twoSumV2(int[] nums, int target) {
		int[] result = new int[2];

		Map<Integer,Integer> comp = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (comp.containsKey(nums[i])) {
				result[0] = comp.get(nums[i]);
				result[1] = i;
				return result;
			}
			comp.put(target-nums[i], i);
		}

		return result;				
	}

}
