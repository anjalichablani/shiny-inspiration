package StockBuySellKTransactions;

import java.util.Deque;
import java.util.LinkedList;

public class StockBuySellKTransactions {

	
	public int maxProfitBuySellStockWithKTransactions(int[] prices, int k) {
		
		int[][] temp = new int[k+1][prices.length];
		
		// Lets try to perform one transaction at a time and build upon it.
		for (int i = 1; i <= k; i++) {
			// Lets try to find the optimal profit that we can earn on day j
		    // with the ith transaction. We will start with day 1 since we can only buy on day 0.
			for (int j = 1; j < prices.length; j++) {
				int bestProfit = 0;
				
				//when completing a transaction on jth day, this means I sell on jth day
				//it also means I buy on one of the previous m days.
				//If we choose to make a transaction on jth day then the total profit will be profit made out of current
				// transaction + whatever profit we made in the previous transactions(i-1) that
				// completed before the start of the current one.
				// Lets find out what is the best day to buy from m (0.. j-1) to achieve max profit.
				for (int m = 0; m < j; m++) {
					int currentProfit = prices[j]-prices[m];
					int prevProfitAsOfMthDay = temp[i-1][m];
					int totalProfit = currentProfit + prevProfitAsOfMthDay;
					if (totalProfit > bestProfit){
						bestProfit = totalProfit;
					}
				}
				// If we don't make any transaction today then our profit
				// will be same as what it would be yesterday with ith transaction
				int profitWithNoTransaction = temp[i][j-1];
				
				//compare profit of doing a transaction vs not doing a transaction and select max of 2.
				int maxProfit = Math.max(profitWithNoTransaction, bestProfit);
				
				temp[i][j] = maxProfit;
			}
		}
		printCache(temp);
		printActualSolution(temp, prices);
		return temp[k][prices.length-1];
		
	}
	
	
	private void printCache(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void printActualSolution(int temp[][], int prices[]) {
		int i = temp.length - 1;
		int j = temp[0].length - 1;

		Deque<Integer> stack = new LinkedList<>();
		
		while (true) {
			if (i == 0 || j == 0) {
				break;
			}
			if (temp[i][j] == temp[i][j - 1]) {
				j = j - 1;
			} else {
				stack.addFirst(j);
				int maxDiff = temp[i][j] - prices[j];
				for (int k = j - 1; k >= 0; k--) {
					if (temp[i - 1][k] - prices[k] == maxDiff) {
						i = i - 1;
						j = k;
						stack.addFirst(j);
						break;
					}
				}
			}
		}

		while (!stack.isEmpty()) {
			System.out.println("Buy at price " + prices[stack.pollFirst()]);
			System.out.println("Sell at price " + prices[stack.pollFirst()]);
		}

	}
}
