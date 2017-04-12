package BitonicSubsequence;

import org.junit.Test;

public class testTryBitonicSubsequence {

	@Test
	public void testBitonicSubsequenceProb_1() {
		int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
		tryBitonicSubsequence bs = new tryBitonicSubsequence();
		 bs.printLongestBitonicSubsequence(arr);
		
		
	}
}
