package LongestCommonSubsequence;



public class LCS {
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
	
	public LCS() {}
	
	public void printLongestCommonSubSequence(String s1, String s2) {
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0)
			return;

		int[][] cache = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < cache.length; i++)
			for (int j = 1; j < cache[0].length; j++)
				cache[i][j] = -1;

		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		//printCache(cache);
		findLongestCommonSubsequenceInner(arr1, 1, arr2, 1, cache);
     
		
		int maxLength = cache[s1.length()][s2.length()];
		
		// We found the length of the longest common subsequence, now need to find the actual
		// characters in that sequence
		
		int i = s1.length();
		int j = s2.length();
		int k = maxLength - 1;
		char[] output = new char[maxLength];
		
		
		while (i > 0 && j > 0 && k >= 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				output[k] = s1.charAt(i - 1);
				k--;
				i--;
				j--;
			} else if (cache[i-1][j] == cache[i][j])
				i--;
			else
				j--;
		}
		
		String outputString = new String(output);
		System.out.println("Length of longest common subsequence : " + maxLength);
		System.out.println("Longest common subsequence :  " + outputString);
		
		
	}

	private int findLongestCommonSubsequenceInner(char[] arr1, int i,
			char[] arr2, int j, int[][] cache) {
		if (i == arr1.length|| j ==arr2.length) {
			int val = cache[i][j];
			return val;
		}

		if (cache[i][j] == -1) {
			char c1 = arr1[i-1];
			char c2 = arr2[j -1];
			if (c1 == c2){
				int val = 1 + findLongestCommonSubsequenceInner(arr1, i + 1, arr2, j + 1, cache);
				cache[i][j]  = val; 
			} else {
				int ls = findLongestCommonSubsequenceInner(arr1, i + 1, arr2, j, cache);
				int rs = findLongestCommonSubsequenceInner(arr1, i, arr2, j + 1, cache);
				cache[i][j] = Math.max(ls, rs);
			}
		}

		return cache[i][i];
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
