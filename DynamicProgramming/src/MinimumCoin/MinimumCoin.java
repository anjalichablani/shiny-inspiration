package MinimumCoin;

/*
Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} 
valued coins, what is the minimum number of coins to make the change?

Examples:

Input: coins[] = {25, 10, 5}, V = 30
Output: Minimum 2 coins required
We can use one coin of 25 cents and one of 5 cents 

Input: coins[] = {9, 6, 5, 1}, V = 11
Output: Minimum 2 coins required
We can use one coin of 6 cents and 1 coin of 5 cents

we cannot always use higher denomination coin to obtain our total 
Taking above example to get 11, if we use 9 to begin with ..we will need 3 coins 9, 1, 1
*/
public class MinimumCoin {

	 public void computeMinimumCoin(int[] coins, int total){
	        int temp[] = new int[total + 1];
	        int result[] = new int[total + 1];
	        
	        for(int i=0; i <= total; i++) {
	            temp[i] = Integer.MAX_VALUE-1;
	            result[i] = -1;
	        }
	        
	        temp[0] = 0;
	        
	        for (int j= 0; j < coins.length;j++) {
	        	for (int i = 1; i <= total; i++) {
	        		if (i < coins[j]) {
	        			continue;
	        		}
	        		int residualValue = i - coins[j];
	        		int newValue = temp[residualValue]+1; //this coin + whatever many coins are required to get residual value.
	        		if (newValue < temp[i]) {
	        			temp[i] = newValue;
	        			result[i] = j;
	        		}
	        	}
	        }
	        
	       printCombination(total, coins, result);       
	 }
	 
	 private void printCombination(int total, int[] coins, int[]result) {	 
		 int sum = total;
		 System.out.println("Coins used to form total: " +  total);
		 
		 while (sum > 0) {
			 int coinIndex = result[sum];
			 int coinDenomination = coins[coinIndex];
			 System.out.println(coinDenomination);
			 sum = sum - coinDenomination;
		 } 
	 }
}
