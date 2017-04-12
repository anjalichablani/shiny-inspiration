package MaximumSumIncreasingSubsequence;

import java.util.Stack;

public class MaxSIS {
	
	//virals implementation
	public static void printMaxSumIncreasingSubSequence(int[] input) {
		if (input == null || input.length == 0)
			return;
		
		int[] cache = new int[input.length];
		cache[0] = input[0];
		int maxSum = input[0];
		 
		for (int i = 1; i < input.length; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i])
					sum = Math.max(sum, cache[j]);
			}
			cache[i] = sum + input[i];
			if (cache[i] > maxSum)
				maxSum = cache[i];
		}
		
		printCache(cache);
		System.out.println("Max increasing subsequence is as below with max sum = " + maxSum);
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = input.length - 1; i >= 0; i--) {
			if (cache[i] == maxSum) {
				stack.push(input[i]);
				maxSum -= input[i];
				
				if (maxSum == 0)
					break;
			}
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop() + " ");
		
		System.out.println();
	}
	
   private static void printCache( int[] msis) {
		
		System.out.println();
		for (int i = 0; i < msis.length; i++) {
			System.out.print(msis[i] + " ");
		}
		System.out.println();
	}
   
   /* Driver program to test above function */
   public static void main(String args[])
   {
       int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
      
       MaxSIS.printMaxSumIncreasingSubSequence( arr );
   }
}
