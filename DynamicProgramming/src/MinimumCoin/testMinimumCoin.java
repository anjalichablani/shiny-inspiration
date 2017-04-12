package MinimumCoin;

import org.junit.Test;

public class testMinimumCoin {

	@Test
	public void testMinimumCoins_1(){
	  int total = 13;
      int coins[] = {7, 3, 2, 6};
      
      MinimumCoin minCoin = new MinimumCoin();
      
      minCoin.computeMinimumCoin(coins, total);
      
	}
	
	@Test
	public void testMinimumCoins_2(){
	  int total = 11;
      int coins[] = {9, 6, 5, 1};
      
      MinimumCoin minCoin = new MinimumCoin();
      minCoin.computeMinimumCoin(coins, total);
      
	}
}
