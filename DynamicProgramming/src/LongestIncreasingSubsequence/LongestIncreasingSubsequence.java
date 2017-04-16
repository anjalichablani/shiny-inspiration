package LongestIncreasingSubsequence;

import java.util.Stack;

// Find a subsequence in given array in which the subsequence's elements are 
// in sorted order, lowest to highest, and in which the subsequence is as long as possible

//Time complexity is O(n^2).
//Space complexity is O(n)
//https://leetcode.com/problems/longest-increasing-subsequence/#/description

public class LongestIncreasingSubsequence {

	public int longestSubsequenceWithActualSolution(int arr[]) {
		int maxIndex = 0;
		int maxLength = 1;
		int temp[] = new int[arr.length];
		int actualSolution[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = 1;
			actualSolution[i] = i;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (temp[i] < temp[j] + 1) {
						temp[i] = temp[j] + 1;
						// set the actualSolution to point to guy before me
						actualSolution[i] = j;
						if (temp[i] > maxLength) {
							maxLength = temp[i];
							maxIndex = i;
						}
					}
				}
			}
		}

		// lets print the actual solution
		int curr = maxIndex;
		int parent = actualSolution[curr];
		Stack<Integer> stack = new Stack<Integer>();
		while (parent != curr) {
			stack.add(curr);
			curr = parent;
			parent = actualSolution[curr];
		}
		stack.add(curr);

		while(!stack.isEmpty()) {
			System.out.println(arr[stack.pop()]);
		}
		System.out.println();
		System.out.println("length of longest increasing sub sequence:" + maxLength);
		
		return maxLength;
	}
}
