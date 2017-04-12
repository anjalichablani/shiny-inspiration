package MaxSubArraySum;
/**
 * http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 *
 */
public class MaxSubArraySum {

	public void computeMaxSubArraySum(int[] input) {
		int max_current = 0;
		int max_global = 0;
		
		int start = -1;
		int end = -1;
		int s  = -1;
		for (int i = 0 ; i < input.length; i++){
			max_current = max_current + input[i];
			
			if (max_current < 0) {
				max_current = 0;
				s = i+1;
			}
			
			if (max_current > max_global) {
				max_global = max_current;
				start = s;
				end = i;
			}
			
		}
		
		System.out.println("Maximum contiguous sum is " + max_global );
		System.out.println("Starting index " + start);
		System.out.println("Ending index " + end);
	}
	
	public void computeMaxSubArraySum1(int[] input) {
	
	}
	
}
