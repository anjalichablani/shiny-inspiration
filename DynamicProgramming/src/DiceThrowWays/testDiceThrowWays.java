package DiceThrowWays;

import org.junit.Test;

public class testDiceThrowWays {

	@Test
	public void test() {
		DiceThrowWays dice = new DiceThrowWays();
		int n = 3; //no. of dice
		int f = 4; //faces
		int X = 5;
		int result = dice.numberOfWays(n, f, X);
		System.out.println(result);
	}
}
