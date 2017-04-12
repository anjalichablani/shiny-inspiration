package BurstBalloons;

import org.junit.Test;

public class testPractiseBurstBalloons {

	@Test
	public void test() {
		int[] input = {3,1, 5, 8};
		practiseBurstBalloon pbb = new practiseBurstBalloon();
		int result = pbb.getMaxValueBurstingBalloons(input);
		
		System.out.println("Max value that can be obtained bursting balloons " + result);
	}
}
