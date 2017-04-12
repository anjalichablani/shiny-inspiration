package MinimumCoin;

import java.util.Map;

/*
Given a total and coins of certain denomination with infinite supply, what is the minimum number
of coins it takes to form this total.

Time complexity - O(coins.size * total)
Space complexity - O(coins.size * total)
*/

public class MinimumCoinRecursive {

	/**
     * Top down dynamic programming. Using map to store intermediate results.
     * Returns Integer.MAX_VALUE if total cannot be formed with given coins.
     */
	public int coinChangingMinimumCoinRecursive(int[] coins, int total, Map<Integer, Integer> totalToMinCoinsMap) {
		
		//if total is 0 then there is nothing to do. return 0.
		if (total == 0) {
			return 0;
		}
		
		 //if map contains the result means we calculated it before. Lets return that value.
		if (totalToMinCoinsMap.containsKey(total)){
			return totalToMinCoinsMap.get(total);
		}
			
		//iterate through all coins and see which one gives best result.
		int min = Integer.MAX_VALUE;
		for(int i =0 ; i < coins.length; i++) {
			//if value of coin is greater than total we are looking for just continue.
			if (coins[i] > total) {
				continue;
			}
			
			//recurse with total - coins[i] as new total
			total = total- coins[i];
			int value = coinChangingMinimumCoinRecursive(coins, total, totalToMinCoinsMap);
			
			//if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
			if (value < min) {
				min = value;
			}
		}
		  //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
	      min = (min == Integer.MAX_VALUE)? min : min+1;
	    
	      //memoize the minimum for current total.
		  totalToMinCoinsMap.put(total, min);
		  
		  return min;
	}
}
