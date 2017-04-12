package LongestCommonSubsequence;

public class LongestCommonSubsequence1 {

	int temp[][];

	public int lcsDynamic(String s1, String s2) {
		temp = new int[s1.length() + 1][s2.length() + 1];
		int max = 0;
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					temp[i][j] = temp[i - 1][j - 1] + 1;
				} else {
					temp[i][j] = Math.max(temp[i][j - 1], temp[i - 1][j]);
				}
				if (temp[i][j] > max) {
					max = temp[i][j];
				}
			}
		}
		printCache(temp);
		printActualLCS(s1, s2);
		
		return max;

	}

	private void printCache(int[][] cache) {
		System.out.println("Cache : ");
		for (int row = 0; row < cache.length; row++) {
			for (int col = 0; col < cache[0].length; col++)
				System.out.print(cache[row][col] + "");
			System.out.println();
		}
	}
	
	

	//backtrack to find which longest common subsequence
	private void printActualLCS(String s1, String s2) {
		int maxLengthOfLongestCommonSubsequence = temp[s1.length()][s2.length()];

		// We found the length of the longest common subsequence, now need to
		// find the actual
		// characters in that sequence

		int i = s1.length();
		int j = s2.length();
		int k = maxLengthOfLongestCommonSubsequence - 1;
		
		char[] lcs = new char[maxLengthOfLongestCommonSubsequence];

		while (i > 0 && j > 0 && k >= 0) {
			if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
				lcs[k] = s1.charAt(i - 1);
				k = k - 1;
				i= i - 1;
				j = j - 1;
			} else if (temp[i - 1][j] == temp[i][j])
				i = i - 1;
			else
				j = j - 1;
		}

		String outputString = new String(lcs);
		System.out.println("Length of longest common subsequence : "
				+ maxLengthOfLongestCommonSubsequence);
		System.out.println("Longest common subsequence :  " + outputString);

	}
}
