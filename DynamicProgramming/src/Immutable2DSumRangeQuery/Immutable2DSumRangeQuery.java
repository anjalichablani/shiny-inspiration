package Immutable2DSumRangeQuery;

/**
 * 
 * Given a 2D array find the sum in given range defining a rectangle.
 *
 * Time complexity construction O(n*m)
 * Time complexity of query O(1)
 * Space complexity is O(n*m)
 * 
 * Reference
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * https://www.youtube.com/watch?v=PwDqpOMwg6U&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=40
 */
public class Immutable2DSumRangeQuery {
	
	int[][] temp;
	int row = 0;
	int col = 0;
	
	public Immutable2DSumRangeQuery(int[][] matrix) {
	
		if (matrix == null || matrix.length == 0)
			throw new IllegalArgumentException("Matrix is null or empty");
		
		row = matrix.length;
		col = matrix[0].length;
		
		temp = new int[row+1][col+1];
		getImmutable2DSumRangeQuery(matrix);
	}
	
	private void getImmutable2DSumRangeQuery(int[][] matrix) {	
		
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <=col; j++) {
				temp[i][j] = matrix[i-1][j-1] +
						temp[i][j-1] + 
						temp[i-1][j] -
						temp[i-1][j-1];
			}
		}
		
		print2DSumRangeQuery();
		
	}
	
	private void print2DSumRangeQuery() {
		for (int i =0; i <= row; i++ ) {
			for(int j =0; j <=col; j++) {
			  System.out.print(String.format("%2d ",temp[i][j]));	
			}
			System.out.print("\n");
		}
	}
	
	public int sumQuery(int row1, int col1, int row2, int col2) {
		
		row1++;
		col1++;
		row2++;
		col2++;
		
		int totalSum = temp[row2][col2];
		
		int rectangleSum = totalSum - temp[row2][col1-1] - temp[row1-1][col2] + temp[row1-1][col1-1];
		
		return rectangleSum;
	}
}
