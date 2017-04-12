package OptimalBinarySearchTree;

/*
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, 
 * where freq[i] is the number of searches to keys[i]. 
 * Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible
 * 
 * http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 */

public class OptimalBinarySearchTree {

	public int computeCostForOptimalBinarySerachTree(int[] freq, int[]arr) {
		
		int[][] temp  = new int[arr.length][arr.length];
		
		for (int i = 0; i < arr.length;i++){
			temp[i][i] = freq[i];
		}
		
		for (int len = 2; len <= arr.length; len++) {			
			for (int i = 0; i <= arr.length-len; i++) {
				int j = i+ (len -1);
				
				temp[i][j] = Integer.MAX_VALUE;
				int sum = getSum(freq, i, j);
				
				int min = Integer.MAX_VALUE;
				int val = 0;
				for (int k= i; k <= j; k++) {
					if (k == i) {
						val = sum+temp[k+1][j];
					} else if(k == j) {
						val = sum+ temp[i][k-1]; 
					} else {
						val = sum+ temp[i][k-1] + temp[k+1][j];
					}
					
					if (val < min) {
						min = val;
					}
				}
				temp[i][j] = min;
			}
		}
		
		printCache(temp);
		
		return temp[0][arr.length-1];
	}
	
	private int getSum(int[] freq, int i, int j) {
		
		int sum = 0;
		for(int k = i; k <=j; k++) {
			sum += freq[k];
		}
		
		return sum;
	}
	
	private void printCache(int[][] cache) {
		System.out.println("Cache : ");
		for (int row = 0; row < cache.length; row++) {
			for (int col = 0; col < cache[0].length; col++)
				System.out.print(cache[row][col] + "  ");
			System.out.println();
		}
	}
}
