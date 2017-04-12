package MaximumRectangularSubmatrixOf1s;

import org.junit.Test;

public class testMaximumRectangleSubmatrixOf1s {

	@Test
	public void test(){
		int[][] matrix = new int [][]{{1, 0, 0, 1, 1, 1},
			                          {1, 0, 1, 1, 0, 1},
			                          {0, 1, 1, 1, 1, 1},
			                          {0, 0, 1, 1, 1, 1}};
		
		MaxRectangularSubMatrixOf1s maxRect = new MaxRectangularSubMatrixOf1s();
		int maxArea = maxRect.computeMaxRectangle(matrix);
		System.out.println(maxArea);
	}
}
