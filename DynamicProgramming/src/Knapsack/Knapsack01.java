package Knapsack;

import java.util.Stack;

/* 
* 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
* how to pick items to pick items from this set to maximize sum of value of items such that
* sum of weights is less than or equal to maximum allowed weight.
*/
public class Knapsack01 {

	
	public int computeMaxValue(int[] val, int[] weight, int items,int capacity) {
		
		int[][] temp = new int[items+1][capacity+1];
		
		//0 items no matter how much capacity we have value is 0
		for (int i = 0; i <= items; i++) {
			temp[i][0] = 0;
		}
		
		//where available capacity is zero no matter how many items we have we cannot add any item when there is no capacity
		for (int j = 0; j<= capacity; j++) {
			temp[0][j] = 0;
		}
		
		for (int i=1; i<= items; i++) {
			for (int j = 1; j <= capacity; j++) {
				if (j < weight[i-1]) {
					temp[i][j] = temp[i-1][j];
				} else {
					int currentItemValue = val[i-1];
					int currentItemWeight = weight[i-1];
					int residualCapacity = j - currentItemWeight;
					int totalValue = currentItemValue + temp[i-1][residualCapacity];
					temp[i][j] = Math.max(temp[i-1][j], totalValue);
				}
			}
		}
		
		printDPTable (temp);
		printActualItems(temp, weight, val, items, capacity);
		return temp[items][capacity];
	}
	
	public void printDPTable(int[][] temp) {
		for (int i = 0 ; i < temp.length; i++){
			for (int j  = 0 ; j < temp[i].length; j++) {
				System.out.print(String.format(" %2d ", temp[i][j]));
			}
			System.out.print("\n");
		}
	}
	
	public void printActualItems(int[][]temp, int[] weight, int[] val, int items, int capacity) {
		
		int i = items;
		int j = capacity;
		int remainingCapacity = capacity;
		int remainingValue = temp[items][capacity];
		Stack<Integer> s = new Stack<>();
		while (i > 0 && j > 0) {
			if (temp[i][j] != temp[i-1][j]) { //is the value coming from top, if not include the item
				s.add(i); //add item to stack
				remainingCapacity = j - weight[i-1]; //residual capacity;
				remainingValue = temp[i][j] - val[i-1]; //residual value
				i--; //move up ..one less item
				j = remainingCapacity; //one less item at residual capacity 
			} else { //if value is coming from top this item was not included so move up to the previous item
				i--;
			}
		}
		
		while(!s.isEmpty()) {
			int item = s.pop();
			System.out.println("Included Item " + item  + " with weight " + weight[item-1] + " and value " + val[item-1]);
		}
	}
}
