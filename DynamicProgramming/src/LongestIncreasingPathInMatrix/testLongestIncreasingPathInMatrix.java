package LongestIncreasingPathInMatrix;

import org.junit.Test;

public class testLongestIncreasingPathInMatrix {

	@Test
	public void test() {
		int[][] matrix = {{9,9,4},
				          {6,6,8},
				          {2,1,1}};
		
		LongestIncreasingPath lip = new LongestIncreasingPath();
		int result = lip.computeLongestIncreasingPath(matrix);
		System.out.println(result);
	}
}
