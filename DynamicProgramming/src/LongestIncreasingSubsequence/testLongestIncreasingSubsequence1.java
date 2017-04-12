package LongestIncreasingSubsequence;

import org.junit.Test;

public class testLongestIncreasingSubsequence1 {

	@Test
	public void testLongestSubsequence() {
		
		LongestIncreasingSubsequence1 lis = new LongestIncreasingSubsequence1();
		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		lis.computeLongestIncreasingSubsequence(arr);
		
	}
	
	@Test
	public void testLongestSubsequence_1() {
		
		LongestIncreasingSubsequence1 lis = new LongestIncreasingSubsequence1();
		int arr[] = { 1, 11, 2, 10, 4, 5, 2, 1 };
		lis.computeLongestIncreasingSubsequence(arr);
		
	}
}
