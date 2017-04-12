package MaximumSumRectangleIn2DMatrix;

public class KadaneResult {

	public int maxSum;
	public int start;
	public int end;
	
	public KadaneResult() {}
	
	public void computeMaxSumSubArray(int[] arr) {
		
		int max_current = 0;
		int max_global = 0;
		
		int s = -1;
		int startIndex = -1;
		int endIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			max_current = max_current + arr[i];
			if (max_current < 0) {
				max_current = 0;
				s = i + 1;
			} else if (max_current > max_global) {
				max_global = max_current;
				startIndex = s;
				endIndex = i;
			}
		}
		
		this.maxSum = max_global;
		this.start = startIndex;
		this.end = endIndex;		
		
	}
}
