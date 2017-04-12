package CountWaysToReachNthStair;

import org.junit.Test;

public class testCountWaysToReachNthStair {

	@Test
	public void test() {
		CountWaysToReachNthStair ways = new CountWaysToReachNthStair();
		int result = ways.countWays(5);
		System.out.println(result);
	}
}
