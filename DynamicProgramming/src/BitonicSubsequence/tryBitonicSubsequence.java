package BitonicSubsequence;

import java.util.Stack;

//virals implementation
public class tryBitonicSubsequence {

	public void printLongestBitonicSubsequence(int[] input) {
		if (input == null || input.length == 0)
			return;
		
		// Create sums of longest increasing subsequence starting at first element and ending at last element
		int[] lis = new int[input.length];
		
		// Create sums of longest increasing subsequence in reverse order starting at last element and ending at first element
		int[] lds = new int[input.length];
		
		lis[0] = input[0];
		lds[input.length - 1] = input[input.length - 1];
		
		for (int i = 1; i < input.length; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				if (input[i] > input[j] && sum < lis[j])
					sum = lis[j];
			}
			lis[i] = sum + input[i];
		}
		
		for (int i = input.length - 2; i >= 0; i--) {
			int sum = 0;
			for (int j = input.length - 1; j > i; j--) {
				if (input[i] > input[j] && sum < lds[j])
					sum = lds[j];
			}
			lds[i] = sum + input[i];
		}
		
		int index = -1;
		int maxSum = 0;
		for (int i = 0; i < input.length; i++) {
			int sum = lis[i] + lds[i] - input[i];
			if (sum > maxSum) {
				maxSum = sum;
				index = i;
			}
		}
		
		System.out.println("LIS");
		printCache(lis);
		System.out.println("LDS");
		printCache(lds);
		
		System.out.println("Longest bitonic subsequence is as below with sum = " + maxSum);
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int sum = lis[index];
		for (int i = index; i >= 0; i--) {
			if (lis[i] == sum) {
				sum -= input[i];
				stack.push(input[i]);
				
				if (sum == 0)
					break;
			}
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		
		sum = lds[index] - input[index];
		for (int i = index + 1; i < input.length; i++) {
			if (lds[i] == sum) {
				sum -= input[i];
				System.out.print(input[i] + " ");
				
				if (sum == 0)
					break;
			}
		}
		
		System.out.println();
	}
	
	private void printCache(int[] cache) {
		System.out.println("Cache: ");
		for (int i = 0; i < cache.length; i++) {
			System.out.print(cache[i] + " ");
		}
		System.out.println();
	}
}
