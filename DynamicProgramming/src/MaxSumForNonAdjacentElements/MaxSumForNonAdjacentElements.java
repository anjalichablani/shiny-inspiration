package MaxSumForNonAdjacentElements;
/**
 * 
 * Find maximum sum for non adjacent elements.
 * Maximum sum such that no two elements are adjacent
 * Given an array of positive numbers, find the maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array. 
 * So 3 2 7 10 should return 13 (sum of 3 and 10) or 3 2 5 10 7 should return 15 (sum of 3, 5 and 7).
 * Answer the question in most efficient way.
 * 
 * http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 *  
 * https://leetcode.com/problems/house-robber/
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * Loop for all elements in arr[] and maintain two sums incl and excl 
 * where incl = Max sum including the previous element and excl = Max sum excluding the previous element.
 * so we add current element at i to excl because excl does not include previous element.
 * 
 * Time Complexity: O(n)
 */
public class MaxSumForNonAdjacentElements {
	
	public int maxSum(int[] input) {
		if(input == null|| input.length == 0) {
			return 0;
		}
		if(input.length == 1) {
			return input[0];
		}
		
		int incl = input[0];
		int excl = 0;
		
		for(int i = 1; i < input.length; i++) {
			int temp = incl;
			incl = Math.max(excl+input[i], incl);
			excl = temp;
		}
		
		return incl;
	}
	
	/**
	 * Variation is finding maximum sum non adjacent elements assuming its a circular array.
	 * Find maximum sum from left to right ignoring first element.
     * Find maximum sum from right to left ignoring last element.
     * Maximum of two will be the answer. It guarantees that both first and last element
     * will be not selected together.
	 */
	public int maxSumCircularArray(int[] input) {
		
		if(input == null|| input.length == 0) {
			return 0;
		}
		
		if(input.length == 1) {
			return input[0];
		}
		
		int incl_1 = input[1];
		int excl_1 = 0;
		
		for (int i = 2; i < input.length; i++) {
			int temp = incl_1;
			incl_1 = Math.max(excl_1 + input[i], incl_1);
			excl_1 = temp;
			
		}
		
		int incl_2 = input[input.length-2];
		int excl_2 = 0;
		for(int j = input.length-3; j >=0; j--) {
		   int temp = incl_2;
		   incl_2  = Math.max(excl_2 + input[j], incl_2);
		   excl_2 = temp;
		}
		
		int sum = Math.max(incl_1, incl_2);
		
		return sum;
	}
}
