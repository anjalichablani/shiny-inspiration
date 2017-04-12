package MaxSizeSquareSubMatrixWithAll1s;

import org.junit.Test;

public class testMaxSizeSquareSubMatrixWithAll1s {

	@Test
	public void test() {
		int [][] matrix = new int[][] {{0, 1, 1, 0, 1},
				                       {1, 1, 1 ,0, 0},
				                       {1, 1, 1, 1, 0},
				                       {1, 1, 1, 0, 1}};
		
		MaxSizeSquareSubMatrixWithAll1s squareMatrix = new MaxSizeSquareSubMatrixWithAll1s();
		int result = squareMatrix.computeMaxSquareSubMatrixWithAll1s(matrix);
		System.out.println("Maximum size square sub-matrix is " + result);
	}
	
	@Test
	public void test_1() {	
		int [][] matrix = new int[][] {{0, 1, 1, 0, 1}, 
                                       {1, 1, 0, 1, 0}, 
                                       {0, 1, 1, 1, 0},
                                       {1, 1, 1, 1, 0},
                                       {1, 1, 1, 1, 1},
                                       {0, 0, 0, 0, 0}};
		
		MaxSizeSquareSubMatrixWithAll1s squareMatrix = new MaxSizeSquareSubMatrixWithAll1s();
		int result = squareMatrix.computeMaxSquareSubMatrixWithAll1s(matrix);
		System.out.println("Maximum size square sub-matrix is " + result);
	}
}
