package MaximumSumIncreasingSubsequence;

import java.util.Stack;

public class MaxSumIncreasingSubsequence {

	int[] arr;
	int[] temp;
	int[] result;

	public MaxSumIncreasingSubsequence(int[] arr) {
		this.arr = arr;
		this.temp = new int[arr.length];
		this.result = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			result[i] = i;
		}
	}

	public void maximumSumIncreasingSubSequence() {
		int max = 0;
		int maxIndex = -1;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					int sum = temp[j] + arr[i];
					if (temp[i] < sum) {
						temp[i] = sum;
						result[i] = j;
						if (max < temp[i]) {
							max = temp[i];
							maxIndex = i;
						}
					}
				}
			}
		}

		printCache();
		System.out.println("Max sum: " + max);
		printMaxSumSubSequence(maxIndex, max);
	}

	private void printCache() {
		System.out.println("temp array that maintains max sum at very element: ");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		
		System.out.println();
		System.out.println("MSIS array maintains index to get max sum sub sequence: ");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(result[i] + " ");
		}
		
		System.out.println();
	}
	
	private void printMaxSumSubSequence(int index, int max) {
	
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("Maximum sum sub sequence is: " );
		int parent = result[index];
		int total = max;
		
		while (total > 0) {
			int x = arr[index];
			stack.push(x);
			total = total - x;
			index = parent;
			parent = result[index];
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
			if (!stack.isEmpty()) {
				System.out.print(",");
			}
		}
	}

}
