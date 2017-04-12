package CoinChanging;

import org.junit.Test;

public class testCoinChanging {

	@Test
	public void testCoinChanging_1() {
		CoinChanging cc = new CoinChanging();
        int total = 15;
        int coins[] = {3,4,6,7,9};
        System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
        cc.printCoinChangingSolution(total, coins);
	}
	
	@Test
	public void testCoinChanging_2() {
		CoinChanging cc = new CoinChanging();
        int total = 5;
        int coins[] = {1,2,3};
        System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
	}
	
	@Test
	public void testCoinChanging_3() {
		CoinChanging cc = new CoinChanging();
        int total = 10;
        int coins[] = {2,5,3,6};
        System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
        cc.printCoinChangingSolution(total, coins);
	}
}
