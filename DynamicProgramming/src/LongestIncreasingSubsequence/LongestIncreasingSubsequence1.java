package LongestIncreasingSubsequence;

// Find a subsequence in given array in which the subsequence's elements are 
// in sorted order, lowest to highest, and in which the subsequence is as long as possible

//Time complexity is O(n^2).
//Space complexity is O(n)

import java.util.Stack;

public class LongestIncreasingSubsequence1 {
	
	public int computeLongestIncreasingSubsequence(int[] input) {
		
		if (input == null|| input.length == 0) {
		    return 0;	
		}
		
		if (input.length == 1){
			return 1;
		}
		
		int[] temp = new int[input.length];
		int[] result = new int[input.length];
		
		int max = 1;
		int maxIndex = 0;

		for (int i = 0; i < input.length; i++) {
			temp[i] = 1;
			result[i] = i;
		}

		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i]) {
				         //subsequence of j + 1 or Math.max(temp[i], temp[j]+1)
					if (temp[i] < temp[j] + 1) {
						temp[i] = temp[j] + 1;
						result[i] = j;
						if (max < temp[i]) {
							max = temp[i];
							maxIndex = i;							
						}
					}
				}
			}
		}
		getLongestSubsequence(maxIndex, max, input, result);
		
		return max;
	}
	
	private void getLongestSubsequence(int maxIndex, int max, int[] input, int[] result) {	
		int index = maxIndex;
		int parentIndex = result[index];
		Stack<Integer> stack = new Stack<Integer>();
		while(index!= parentIndex) {
			stack.add(input[index]);
			index = parentIndex;
			parentIndex = result[index];
		}
		stack.push(input[index]);
			
		//print stack
		System.out.print("Longest increasing subsequence :");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.print("\n");
	}
}
