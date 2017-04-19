package RemoveToMake2TimesMinGreaterThanMax;

/**
 * 
 * Remove minimum elements from either side such that 2*min becomes more than max.
 * Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. 
 * Elements should be removed either end of the array.
 * 
 * Number of removals should be minimum.
 * Example:
 * arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
 * Output: 4
 * We need to remove 4 elements (4, 5, 100, 200)
 * so that 2*min becomes more than max.

 * http://www.geeksforgeeks.org/remove-minimum-elements-either-side-2min-max/
 * 
 */

public class RemoveToMake2IntoMinGreaterThanMax {

	public int computeMinimumRemovalsFromEnd(int[] arr) {
		
		int[][] temp = new int[arr.length][arr.length];
				
		//when there is only 1 element, zero removals are needed
		for (int i = 0 ; i < arr.length; i++) {
			temp[i][i] = 0;
		}
		
		//start with len = 2
		for (int len= 2; len <= arr.length; len++) {
		  for (int i = 0; i <= arr.length- len; i++) {
			int j = i + len -1;
			int min = getMin(arr, i, j);
			int max = getMax(arr, i, j);
			if (2*min > max){
				temp[i][j] = 0;
			} else {
				temp[i][j] = Math.min(temp[i+1][j], temp[i][j-1]) + 1;
			}			
		  }
		}
		
		return temp[0][arr.length-1];
	}
	
	private int getMax(int[]arr, int x, int y){
		int max = Integer.MIN_VALUE;
		for (int i = x ; i<=y; i++) {
			if (arr[i]> max){
				max = arr[i];
			}
		}
		
		return max;
	}
	
	private int getMin(int[] arr, int x, int y) {
		int min = Integer.MAX_VALUE;
		for (int i = x; i <= y; i++) {
			if (arr[i] < min){
				min = arr[i];
			}
		}
		
		return min;
	}
}
