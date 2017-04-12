package MinCostPath;

import org.junit.Test;

public class testMinCostPath {

	@Test
	public void testMinCostPath_1() {
		
		int[][] cost = { {1,2,3}, 
				         {4,8,2}, 
				         {1,5,3},
				         {6,2,9}};
		
		int rows = cost.length;
		int cols = cost[0].length;
		
		MinCostPath minCost = new MinCostPath();
		int result = minCost.computeMinCostPathInGrid(cost, rows, cols);
		
		System.out.println("\nMin cost to traverse the grid is:" + result);
		
	}
	
}
