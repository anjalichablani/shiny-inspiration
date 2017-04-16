package LongestIncreasingSubsequence;

import org.junit.Test;

public class testLongestIncreasingSubsequence1 {

	@Test
	public void testLongestSubsequence() {
		
		LongestIncreasingSubsequence1 lis = new LongestIncreasingSubsequence1();
		int arr[] = { 3, 4, -1, 0, 6, 2, 3 };
		int max = lis.computeLongestIncreasingSubsequence(arr);
		System.out.println("Length of Longest increasing subsequence :" + max);
		
	}
	
	@Test
	public void testLongestSubsequence_1() {
		
		LongestIncreasingSubsequence1 lis = new LongestIncreasingSubsequence1();
		int arr[] = { 1, 11, 2, 10, 4, 5, 2, 1 };
		int max = lis.computeLongestIncreasingSubsequence(arr);
		System.out.println("Length of Longest increasing subsequence :" + max);
		
	}
	
	@Test
	public void testLongestSubsequence_2() {
		
		LongestIncreasingSubsequence1 lis = new LongestIncreasingSubsequence1();
		int arr[] = { 2, 2};
		int max = lis.computeLongestIncreasingSubsequence(arr);
		System.out.println("Length of Longest increasing subsequence :" + max);
		
	}
	
	@Test
	public void testLongestSubsequence_3() {
		
		LongestIncreasingSubsequence1 lis = new LongestIncreasingSubsequence1();
		int arr[] = { 4};
		int max = lis.computeLongestIncreasingSubsequence(arr);
		System.out.println("Length of Longest increasing subsequence :" + max);
		
	}
	
	
	@Test
	public void testLongestSubsequence_4() {
		
		LongestIncreasingSubsequence1 lis = new LongestIncreasingSubsequence1();
		int arr[] = { };
		int max = lis.computeLongestIncreasingSubsequence(arr);
		System.out.println("Length of Longest increasing subsequence :" + max);
		
	}
}
