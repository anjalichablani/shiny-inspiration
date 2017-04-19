package MaximumLengthChainPair;

/**
 * 
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. 
 * A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed in this fashion. 
 * Find the longest chain which can be formed from a given set of pairs. Source:

For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, {27, 40}, {50, 90} }, 
then the longest chain that can be formed is of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}

This problem is a variation of standard Longest Increasing Subsequence problem. Following is a simple two step process.
1) Sort given pairs in increasing order of first (or smaller) element.
2) Now run a modified LIS process where we compare the second element of already finalized LIS with the first element of new LIS being constructed.

http://www.geeksforgeeks.org/dynamic-programming-set-20-maximum-length-chain-of-pairs/
*/
import java.util.Arrays;
import java.util.Stack;

public class MaximumLengthChainPair {

	public MaximumLengthChainPair() {}
	
	public int getMaximumLengthChainPair(Pair[] pairs) {
		if (pairs == null| pairs.length == 0) {
			return 0;
		}
		
		Arrays.sort(pairs);
		
		int[] temp = new int[pairs.length];
		int[] result = new int[pairs.length];
		
		for (int i = 0; i < pairs.length; i++) {
			temp[i] =1;
			result[i] = i;
		}
		
		int max = 0;
		int maxIndex = -1;
		for (int i = 1; i < pairs.length; i++) {
			for (int j =0; j < i; j++){
				if (pairs[i].first > pairs[j].second) {
					if (temp[i] < temp[j]+1){
						temp[i] = temp[j]+1;
						if (max < temp[i]){
							max = temp[i];
							maxIndex = i;
							result[i] = j;
						}
					}
				}
			}
		}
		
		printMaximumLengthChainPair(max, maxIndex, result, pairs);
		
		return max;
	}
	
	private void printMaximumLengthChainPair(int max, int maxIndex, int[] result, Pair[] pairs) {
		
		Stack<Pair> stack  = new Stack<>();
		int index = maxIndex;
		int parentIndex = result[index];
		
		while (index != parentIndex) {
			Pair p = pairs[index];
			stack.add(p);
			index = parentIndex;
			parentIndex = result[index];
		}
		
		stack.add(pairs[index]);
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.print("\n");
	}
	
	public static class Pair implements Comparable<Pair> {

		int first;
		int second;
		
		public Pair() {
			
		}
		
        public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
        
		@Override
		public int compareTo(Pair o) {
			if (this.first <= o.first) {
				return -1;
			} else {
				return 1;
			}
		}
		
		public String toString() {
			return String.format("[%s,%s]", first, second);
		}
	}
}
