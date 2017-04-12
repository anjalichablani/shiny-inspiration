package Knapsack;

import org.junit.Test;

public class testKnapsack01 {

	@Test
	public void test() {
		int[] weight = {4,3,2,3};
		int[] value ={3,2, 4, 4};
		
		int capacity = 6;
		int items = 4;
		
		Knapsack01 ks = new Knapsack01();
		int maxValue = ks.computeMaxValue(value, weight, items, capacity);
		System.out.println("Max value that can be obtained " + maxValue);
	}
	
	@Test
	public void test_1() {
		int[] weight = {1,3,4,5};
		int[] value ={1,4, 5, 7};
		
		int capacity = 7;
		int items = 4;
		
		Knapsack01 ks = new Knapsack01();
		int maxValue = ks.computeMaxValue(value, weight, items, capacity);
		System.out.println("Max value that can be obtained " + maxValue);
	}
}
