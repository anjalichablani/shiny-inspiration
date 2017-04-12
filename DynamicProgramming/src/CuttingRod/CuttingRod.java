package CuttingRod;

import java.util.Map;


/*
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
For example, if length of the rod is 8 and the values of different pieces are given as following, 
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)

length   | 0  1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 0  1   5   8   9  10  17  17  20

*/
public class CuttingRod {
	
	public int maxValue(Map<Integer, Integer> inchToPriceMap, int len) {
		
		int[][] temp = new int[len+1][len+1];
		
		for (int i = 1; i <= len; i++) {
			int price = inchToPriceMap.get(i);
			for(int j=1; j <= len; j++) {
				if (j >= i) {
					int first = temp[i-1][j];
					int residualInch = j - i;
					int second = temp[i][residualInch] + price;
					temp[i][j] = Math.max(first, second);
				} else {
					temp[i][j] = temp[i-1][j];
				}
			}
		}
		printCache(temp);
		return temp[len][len];
	}
	
	private void printCache(int[][] cache) {
		System.out.println("Cache : ");
		for (int row = 0; row < cache.length; row++) {
			for (int col = 0; col < cache[0].length; col++)
				System.out.print(cache[row][col] + "  ");
			System.out.println();
		}
	}
    
}
