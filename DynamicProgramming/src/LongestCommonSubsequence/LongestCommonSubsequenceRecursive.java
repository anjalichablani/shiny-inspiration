package LongestCommonSubsequence;

import java.util.Stack;
//recursive solution
public class LongestCommonSubsequenceRecursive {
	/**
	 * LCS Problem Statement: Given two sequences, find the length of longest
	 * subsequence present in both of them. A subsequence is a sequence that
	 * appears in the same relative order, but not necessarily contiguous. For
	 * example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of
	 * “abcdefg”. So a string of length n has 2^n different possible
	 * subsequences.
	 * 
	 * It is a classic computer science problem, the basis of diff (a file
	 * comparison program that outputs the differences between two files), and
	 * has applications in bioinformatics.
	 * 
	 * Examples: LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of
	 * length 3. LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of
	 * length 4.
	 */
	
	public LongestCommonSubsequenceRecursive() {}
	
	public void printLongestCommonSubSequence(String s1, String s2) {
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return;

		int[][] cache = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < cache.length; i++)
			for (int j = 1; j < cache[0].length; j++)
				cache[i][j] = -1;

		//printCache(cache);
		findLongestCommonSubsequenceInner(s1, s1.length(), s2, s2.length(), cache);
		printCache(cache);
		Stack<Character> stack = new Stack<Character>();
		int i = s1.length();
		int j = s2.length();

		while (i > 0 && j > 0) {
			int val = cache[i - 1][j - 1];
			if (cache[i][j] == 1 + val) {
				char ch = s1.charAt(i - 1);
				stack.push(ch);
				i--;
				j--;
			} else if (cache[i][j] == cache[i - 1][j]) {
				i--;
			} else {
				j--;
			}
		}

		System.out.println("Input: String 1 :  " + s1 + " String 2 : " + s2);
		System.out.println("Longest common sub sequence: ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}

	private int findLongestCommonSubsequenceInner(String s1, int s1Index,
			String s2, int s2Index, int[][] cache) {
		if (s1Index == 0 || s2Index == 0) {
			int val = cache[s1Index][s2Index];
			return val;
		}

		if (cache[s1Index][s2Index] == -1) {
			char c1 = s1.charAt(s1Index - 1);
			char c2 = s2.charAt(s2Index - 1);
			if (c1 == c2){
				int val = 1 + findLongestCommonSubsequenceInner(s1, s1Index - 1, s2, s2Index - 1, cache);
				cache[s1Index][s2Index]  = val; 
			} else {
				int ls = findLongestCommonSubsequenceInner(s1, s1Index - 1, s2, s2Index, cache);
				int rs = findLongestCommonSubsequenceInner(s1, s1Index, s2, s2Index - 1, cache);
				cache[s1Index][s2Index] = Math.max(ls, rs);
			}
		}

		return cache[s1Index][s2Index];
	}

	private void printCache(int[][] cache) {
		System.out.println("Cache : ");
		for (int row = 0; row < cache.length; row++) {
			for (int col = 0; col < cache[0].length; col++)
				System.out.print(cache[row][col] + "");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		LongestCommonSubsequenceRecursive lcs = new LongestCommonSubsequenceRecursive();

		//String s1 = "ABCDGH";
		//String s2 = "AEDFHR";
		//lcs.printLongestCommonSubSequence(s1, s2);

		//String s1 = "AGGTAB";
		//String s2 = "GXTXAYB";
		String s1 = "ABCDGHLQR";
		String s2 = "AEDPHR";
		lcs.printLongestCommonSubSequence(s1, s2);
	}
}
