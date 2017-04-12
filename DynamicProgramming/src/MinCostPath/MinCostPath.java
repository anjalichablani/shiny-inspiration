package MinCostPath;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
Given a cost matrix cost[][] and a position (m, n) in cost[][], 
write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). 
Each cell of the matrix represents a cost to traverse through that cell. 
Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). 
You can only traverse down, right and diagonally lower cells from a given cell, 
i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. 

You may assume that all costs are positive integers.

http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
**/

public class MinCostPath {

	public int computeMinCostPathInGrid(int[][] cost, int rows, int cols) {
		
		int[][] temp = new int[rows][cols];
		
		int sum = 0;
		for(int i = 0; i < rows; i++) {
		   temp[i][0] = sum + cost[i][0];	
		   sum = temp[i][0];
		}
		
		sum = 0;
		for(int j =0; j < cols; j++) {
			temp[0][j] = sum + cost[0][j];
			sum = temp[0][j];
		}
		
		for (int i=1;i<rows; i++) {
			for(int j=1;j<cols;j++) {
			  temp[i][j] = cost[i][j] + getMin(temp, i, j);
			}
		}
		getPath(temp);	
		
		return temp[rows-1][cols-1];
	}
	
	// get the grid traversed for min cost path
	private void getPath(int[][] temp) {
		int m = temp.length - 1;
		int n = temp[0].length - 1;

		List<Set<String>> gridList = new ArrayList<>();
		while (m > 0 && n > 0) {
			gridList.add(addGridPoint(m, n));
			if (temp[m][n - 1] < temp[m - 1][n]
					&& temp[m][n - 1] < temp[m - 1][n - 1]) {
				n--;
			} else if (temp[m - 1][n] <= temp[m][n - 1]
					&& temp[m - 1][n] <= temp[m - 1][n - 1]) {
				m--;
			} else {
				m--;
				n--;
			}
		}

		while (m > -1 && n > -1) {
			gridList.add(addGridPoint(m, n));
			if (m == 0) {
				n--;
			} else {
				m--;
			}
		}
		
		printPath(gridList);
	}

	
	private void printPath(List<Set<String>> gridList) {
		// print grid path used to reach min cost path
		for (int i = gridList.size() - 1; i >= 0; i--) {
			System.out.print(gridList.get(i));
			if (i > 0) {
				System.out.print("->");
			}
		}
	}

	private Set<String> addGridPoint(int m, int n) {
		Set<String> gridPoint = new HashSet<String>();
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(m);
		sb.append(",");
		sb.append(n);
		sb.append("}");
		gridPoint.add(sb.toString());

		return gridPoint;
	}

	private int getMin(int[][] temp, int i, int j) {		
		int min = 0;
		
		//min of left cell or cell at the top 
		min = Math.min(temp[i][j-1],  temp[i-1][j]); 
		
		//min of already calculated min or cell diagonal 	
		min = Math.min(temp[i-1][j-1], min);
				
		return min;
	}
	
}
