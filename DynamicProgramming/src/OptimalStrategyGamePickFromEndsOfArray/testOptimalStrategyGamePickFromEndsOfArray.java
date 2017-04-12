package OptimalStrategyGamePickFromEndsOfArray;

import org.junit.Test;

public class testOptimalStrategyGamePickFromEndsOfArray {

	@Test
	public void test() {
		
		int[] input = new int [] {3, 9, 1, 2};
		OptimalStrategyGamePickFromEndsOfArray optimalStrategyPlay = new OptimalStrategyGamePickFromEndsOfArray();
		
		
		OptimalStrategyGamePickFromEndsOfArray.Pair[][] moves = 
				optimalStrategyPlay.computeOptimalStrategy(input);
		
		optimalStrategyPlay.printMoves(moves);
		optimalStrategyPlay.printSequence(input, moves);
		
	}
}
