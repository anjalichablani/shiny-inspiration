package CuttingRod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
For example, if length of the rod is 8 and the values of different pieces are given as following, 
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

Inch     | 0  1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 0  1   5   8   9  10  17  17  20

rod Length = 8

Example 2:

Inch | 1 2 3 4
-----------------------------------
price| 2 5 7 8

rod length = 5
Max Profit = 12

approach here is for example if we want to sell 7 inch (i = 7)
j will be 0 thru 6
7 if sold as a whole is the best price we know of to begi with
Now try combination of inches and get the combination price
we can sell following combination of inches to sell 7 inch rod
1 + 6 or 2 + 5 or 3 + 4, 4 +3, 5 + 2, 6 + 1 {its j + residual value}
where left operand is j and right is i - j
so formula here is t[j] + t[i-j]
Choose between max of all combination price or best available price whichever is higher
*/
public class CuttingRod1 {

	int temp[];
	Map<Integer, Integer> inchToPriceMap;
    int rodLen;
	public CuttingRod1(Map<Integer, Integer> inchToPriceMap, int rodLen) {
		temp = new int[rodLen+1];
		for (int i = 0; i <= rodLen; i++) {
			if (inchToPriceMap.containsKey(i))
				temp[i] = inchToPriceMap.get(i); //initialize array with the price we know of for the inches that can be sold as a whole.
			else 
				temp[i]=0;
		}
		
		this.inchToPriceMap = inchToPriceMap;
		this.rodLen = rodLen;
	}
	
	public int maxValue() {
		Map<Integer, List<Integer>> inchRodToInchesSaleCombination = new HashMap<>();
		for (int i = 1; i <= rodLen; i++) {
			List<Integer> inchList = new ArrayList<>();
			for (int j = 1; j < i; j++) {
				int bestAvailablePrice = temp[i];
				int combinationPrice = temp[j] + temp[i - j];

				if (combinationPrice > bestAvailablePrice) {
					inchList.clear();
					inchList.add(j);
					inchList.add(i - j);
				}

				temp[i] = Math.max(bestAvailablePrice, combinationPrice);
			}
			
			if (inchList.isEmpty()) {
				inchList.add(i);
			}
			
			inchRodToInchesSaleCombination.put(i, inchList);
		}
		
		printCache(inchRodToInchesSaleCombination);
		return temp[rodLen];
	}

	public void printCache(Map<Integer, List<Integer>> inchRodToInchesSaleCombination) {
		for (Entry<Integer, List<Integer>> entry : inchRodToInchesSaleCombination.entrySet()) {
			System.out.println(entry + "Max profit (" + temp[entry.getKey()] + ") vs As Is Price (" + inchToPriceMap.get(entry.getKey()) + ")");

		}
	}

}
