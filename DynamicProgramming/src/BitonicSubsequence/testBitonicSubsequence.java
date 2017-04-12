package BitonicSubsequence;

import org.junit.Test;

public class testBitonicSubsequence {

	@Test
	public void testBitonicSubsequenceProb_1() {
		int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
		BitonicSubsequence bs = new BitonicSubsequence(arr);
		 bs.getBitonicSubsequence();
		
		
	}
	
	@Test
	public void testBitonicSubsequenceProb_2() {
		int arr[] = {12, 11, 40, 5, 3, 1};
		BitonicSubsequence bs = new BitonicSubsequence(arr);
		bs.getBitonicSubsequence();
		
		
	}
	
	@Test
	public void testBitonicSubsequenceProb_3() {
		int arr[] = {80, 60, 30, 40, 20, 10};
		BitonicSubsequence bs = new BitonicSubsequence(arr);
	    bs.getBitonicSubsequence();	
	}
	
	@Test
	public void testBitonicSubsequenceProb_4() {
		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		BitonicSubsequence bs = new BitonicSubsequence(arr);
	     bs.getBitonicSubsequence();
		
		
	}
	
	@Test
	public void testBitonicSubsequenceProb_5() {
		int arr[] = {2, -1, 4, 3, 5, -1, 3, 2};
		BitonicSubsequence bs = new BitonicSubsequence(arr);
	     bs.getBitonicSubsequence();
		
		
	}
}
