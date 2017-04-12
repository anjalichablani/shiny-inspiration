package StockBuySellKTransactions;

import org.junit.Test;

public class testStockBuySellKTransactions {

	@Test
	public void test() {
		int[] prices = {2, 5, 7, 1, 4, 3, 1, 3};
		int k = 3;
		StockBuySellKTransactions tran = new StockBuySellKTransactions();
		int maxProfit = tran.maxProfitBuySellStockWithKTransactions(prices, k);
		
		System.out.println("Max profit possible:" + maxProfit);
	}
}
