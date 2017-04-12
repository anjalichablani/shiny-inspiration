package NumberOfPathsInMxNMatrix;

import org.junit.Test;

public class testNumberOfPathsInMxNMatrix {

	@Test
	public void test() {

		int[][] input = new int[][]{{1,2,3, 4},
			                    {5,6,7, 8},
			                    {9,10,11,12},
			                    {13,14,15,16}};
		
		
		NumberOfPathsInMxNMatrix n = new NumberOfPathsInMxNMatrix();
		int result = n.numberOfPaths(input, 4, 4);
		System.out.println("No of paths to reach from top to bottom in MxN matrix is - " + result);
	}
	
}
