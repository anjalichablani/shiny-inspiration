package MaximumSumIncreasingSubsequence;

import org.junit.Test;

public class testMaximumSumIncreasingSubSequence {

	@Test
	public void testMaximumSumIncreasingSubSequence_1() {
		int arr[] = {1, 101, 10, 2, 3, 100,4};
		MaxSumIncreasingSubsequence mss = new MaxSumIncreasingSubsequence(arr);
       
        mss.maximumSumIncreasingSubSequence();
        
	}
}
