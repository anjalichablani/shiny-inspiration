package MatrixMultiplication;

import org.junit.Test;

public class testMatrixMultiplication {

	@Test
	public void test() {
		MatrixMultiplication mmc = new MatrixMultiplication();
        int arr[] = {4,2,3,5,3};
        int cost = mmc.computeMatrixMultiplicationCost(arr);
        System.out.print(cost);
	}
	
	@Test
	public void test1() {
		MatrixMultiplication mmc = new MatrixMultiplication();
		MatrixMultiplication.Matrix a = new MatrixMultiplication.Matrix (4,2);
		MatrixMultiplication.Matrix b = new MatrixMultiplication.Matrix (2,3);
		MatrixMultiplication.Matrix c = new MatrixMultiplication.Matrix (3,5);
		MatrixMultiplication.Matrix d = new MatrixMultiplication.Matrix (5,3);
		MatrixMultiplication.Matrix[] matrices  = new MatrixMultiplication.Matrix[]{a,b,c,d};
        int cost = mmc.computeCost(matrices);
        System.out.print(cost);
	}
	
}
