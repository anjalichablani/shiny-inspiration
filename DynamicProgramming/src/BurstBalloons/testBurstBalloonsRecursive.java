package BurstBalloons;

import org.junit.Test;

public class testBurstBalloonsRecursive {

	@Test
	public void test() {
		int[] nums = {3, 1, 5, 8};
		BurstBalloonsRecursive bbr = new BurstBalloonsRecursive();
		int result = bbr.BurstBalloonsRec(nums);
		System.out.println("Max value that can be obtained - " + result);
	}
}
