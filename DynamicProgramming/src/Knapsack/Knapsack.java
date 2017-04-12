package Knapsack;

import java.util.Map;

/* 
* 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
* how to pick items to pick items from this set to maximize sum of value of items such that
* sum of weights is less than or equal to maximum allowed weight.
*/
public class Knapsack {


	public int knapsack(Map<Integer,Item> items, int countOfItems, int capacity) throws Exception {
		
		if (capacity <= 0 || items == null || items.size() == 0){
		   throw new Exception("Invalid inputs");
		}
	
		int[][] cache = new int[countOfItems+1][capacity + 1];

		for (int i = 1; i <= countOfItems; i++) {
			int itemWeight = items.get(i).getWeight();
			int itemValue = items.get(i).getValue();
			
			for (int j = 1; j <= capacity; j++) {
				int totalWeight = j;
				
				//considering all previous item's the total value at that totalWeight.
				int first = cache[i - 1][totalWeight];

				//try to get maximumValue of either by picking the currentItem or not picking currentItem
				int second = 0;
				if (totalWeight >= itemWeight) { //if the item weight is less than or equal to the available total weight
					int residualWeight = totalWeight - itemWeight; //if residual weight > 0 then there is room to add more
					if (residualWeight == 0) { //if no residual weight 
						second = itemValue; //current item's value
					} else {
						//considering all previous item's the total value at that residual Weight.
						int previousMaximalValueAtResidualWeight = cache[i - 1][residualWeight];			
					    second = previousMaximalValueAtResidualWeight + itemValue;
					}
				}

				int newValue = Math.max(first, second); //maximize value
				cache[i][j] = newValue;
			}
		}

		for (int i = 0; i <= countOfItems; i++) {
			for (int j = 0; j <= capacity; j++) {
				System.out.print(cache[i][j] + " ");
			}
			System.out.println();
		}

		int totalValue = cache[countOfItems][capacity];

		System.out.println("Actual Items used");
		int i = countOfItems;
		int j = capacity;
		while (i > 0 && j > 0) {
			int first = cache[i - 1][j];
			int residualCapacity = j - items.get(i-1).getWeight();
			int second = 0;
				if (residualCapacity >= 0 ){
					second  = cache[i - 1][residualCapacity] + items.get(i-1).getValue();
			    }

			if (first > second)
				i--;
			else {
				System.out.println(String.format("Item %d. Value: %d. Weight: %d", i-1, items.get(i-1).getValue(),items.get(i-1).getWeight()));
				j = j - items.get(i-1).getWeight();
				i--;
			}
		}
		return totalValue;
	}

	
	
}
