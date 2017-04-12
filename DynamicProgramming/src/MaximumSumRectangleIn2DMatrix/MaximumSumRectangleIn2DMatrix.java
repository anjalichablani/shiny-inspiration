package MaximumSumRectangleIn2DMatrix;

public class MaximumSumRectangleIn2DMatrix {

	
	public MaximumSumRectangleIn2DMatrix(){}
	
	public Result computeMaximumSumRectangleIn2DMatrix(int[][] matrix) {
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[] temp = new int[rows];
		Result result = new Result();
		
		for (int left = 0 ; left < cols ;left++) {
			for (int i = 0; i < rows; i++) {
				temp[i] = 0;
			}
			
			for (int right = left; right < cols; right++) {
				for (int i = 0; i < rows; i++) {
					temp[i] = temp[i] + matrix[i][right];
				}
				
				KadaneResult kadaneResult = new KadaneResult();
				kadaneResult.computeMaxSumSubArray(temp);
				if (kadaneResult.maxSum > result.maxSum) {
					result.maxSum = kadaneResult.maxSum;
					result.maxLeft = left;
					result.maxRight = right;
					result.maxUp = kadaneResult.start;
					result.maxDown = kadaneResult.end;
				}
			}
		}
		
		return result;
		
	}
	
	
	
	
	
	public static class Result {
		public int maxSum;
		public int maxLeft;
		public int maxRight;
		public int maxUp;
		public int maxDown;

		public Result() {
		}

		@Override
		public String toString() {
			return "Result [maxSum=" + maxSum + ", maxLeft=" + maxLeft
					+ ", maxRight=" + maxRight + ", maxUp=" + maxUp
					+ ", maxDown=" + maxDown + "]";
		}
	}
	
	
	
	
}
