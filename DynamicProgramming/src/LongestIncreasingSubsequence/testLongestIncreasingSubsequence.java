package LongestIncreasingSubsequence;

import org.junit.Test;

public class testLongestIncreasingSubsequence {

	@Test
	public void test() {
		
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		lis.longestSubsequenceWithActualSolution(arr);
		
	}
	
	@Test
	public void test_1() {
		
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		 int[] arr = {23,10,22,5,33,8,9,21,50,41,60,80,99, 22,23,24,25,26,27};
		lis.longestSubsequenceWithActualSolution(arr);
		
	}
}
