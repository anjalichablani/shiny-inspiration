package MaximumSumRectangleIn2DMatrix;

import org.junit.Test;

public class testMaximumSumRectangleIn2DMatrix {

	@Test
	public void test(){
		
		int[][] matrix = new int[][] {{2, 1, -3, -4, 5},
				                      {0, 6, 3, 4, 1},
		                              {2, -2, -1, 4, -5},
		                              {-3, 3, 1, 0, 3}};
		
		MaximumSumRectangleIn2DMatrix maxSumRect  = new MaximumSumRectangleIn2DMatrix();
		MaximumSumRectangleIn2DMatrix.Result result = 
				maxSumRect.computeMaximumSumRectangleIn2DMatrix(matrix);
		
		System.out.println("Result:" + result);
	}
}
