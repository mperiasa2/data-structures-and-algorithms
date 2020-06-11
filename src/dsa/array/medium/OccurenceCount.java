/***************************************************************************************************
 * Given a collection of input strings and a collection query strings, for each query string, 
 * determine how many times it occurs in the list of input strings. 
 * 
 * For example if input strings = ['aba','baba','aba','xzxb'] and queries = ['aba','xzxb','ab'], 
 * then we find 2 instances of 'aba', 1 instance of 'xzxb' and 0 instance of 'ab'. For each query, 
 * we add an element to our return array, results = [2,1,0].
 * 
 * Sample Input:
 *   Input Strings: ['aba','baba','aba','xzxb']
 *   Query Strings: ['aba','xzxb','ab']
 *   
 * Sample Output:
 *   [2,1,0]
 * 
 **************************************************************************************************/

package dsa.array.medium;

import java.util.HashMap;
import java.util.Map;

public class OccurenceCount {
	
	/**
	 * V1: Brute Force Solution
	 * Time Complexity: O(qn)
	 */
	public static int[] matchingStringsV1(String[] inputStrings, String[] queryStrings) {
		int[] results = new int[queryStrings.length];
		
		for (int q = 0; q < queryStrings.length; q++) { // assume 'q' is number of query strings
			for (int n = 0; n < inputStrings.length; n++) { // assume 'n' is numer of input strings
				if (inputStrings[n].contentEquals(queryStrings[q])) {
					results[q] += 1;
				}
			}
		}
		return results;
	}
	
	/**
	 * V2: Optimized Solution
	 * Time Complexity: O(q+n)
	 */
	public static int[] matchingStringsV2(String[] inputStrings, String[] queryStrings) {
		int[] results = new int[queryStrings.length];
		
		//create a map to maintain no. of occurences as value
		Map<String,Integer> occMap = new HashMap<>();
		for (String str: inputStrings) { // assume 'n' is numer of input strings; iterating 'n' times
			if (occMap.containsKey(str)) {
				occMap.put(str, occMap.get(str) + 1);
			}
			else {
				occMap.put(str, 1);
			}
		}
		
		// assume 'q' is number of query strings; iterating 'q' times
		for (int q = 0; q < queryStrings.length; q++) { 
			if (occMap.containsKey(queryStrings[q])) {
				results[q] = occMap.get(queryStrings[q]);
			}
		}
		
		return results;
	}
}
