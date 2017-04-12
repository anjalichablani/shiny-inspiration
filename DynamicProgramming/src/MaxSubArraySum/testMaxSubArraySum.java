package MaxSubArraySum;

import org.junit.Test;

public class testMaxSubArraySum {

	@Test
	public void test() {
		int[] input = {-2, -3, 4, -1, -2, 1, 5, -3};
		MaxSubArraySum maxSubArraySum = new MaxSubArraySum();
		maxSubArraySum.computeMaxSubArraySum(input);
	}
}
