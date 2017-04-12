package LongestIncreasingSubsequence;

import java.util.Stack;

public class LongestIncreasingSubsequence1 {
	
	public void computeLongestIncreasingSubsequence(int[] arr) {
		int temp[] = new int[arr.length];
		int maxLength = 1;
		int maxIndex = 0;

		for (int k = 0; k < arr.length; k++) {
			temp[k] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					int x = temp[j] + 1; // subsequence of j + 1 or Math.max(temp[i], temp[j]+1)
					if (temp[i] < x) {
						temp[i] = x;
						if (maxLength < temp[i]) {
							maxLength = temp[i];
							maxIndex = i;
						}
					}
				}
			}
		}
		getLongestSubsequence(maxIndex, temp, arr);
	}
	
	private void getLongestSubsequence(int maxIndex, int[] temp, int[] arr) {	
		int count = temp[maxIndex];
		int i = maxIndex;
		Stack<Integer> stack = new Stack<Integer>();
		while(count > 0 && i >=0){
			if (count == temp[i]) {
				stack.add(arr[i]);
				count--;
			}
			i--;
		}
		
		System.out.println("Length of Longest increasing subsequence :" + temp[maxIndex]);
		//print stack
		System.out.println("Longest increasing subsequence :");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
}
