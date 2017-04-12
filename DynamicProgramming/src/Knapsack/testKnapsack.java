package Knapsack;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class testKnapsack {
	
	@Test
	public void knapsackTest() throws Exception {
		
		Map<Integer, Item> items = new HashMap<Integer, Item>();
	
		items.put(1, new Item(4, 3));
		items.put(2, new Item(3, 2));
		items.put(3, new Item(2, 4));
		items.put(4, new Item(3, 4));
				
		int countOfItems = 4;
		int capacity = 6;
		Knapsack dp = new Knapsack();
		int maxValue = dp.knapsack(items, countOfItems, capacity);
		
		System.out.println(maxValue);
	}
	
}
