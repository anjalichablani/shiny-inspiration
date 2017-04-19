package PalindromePartition;

/**
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.
Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "abcbm",
Return 2 since the palindrome partitioning ["a","bcb", "m"] could be produced using 2 cut.

https://leetcode.com/problems/palindrome-partitioning-ii/#/description
 *
 */
public class PalindromePartition {

	public int computeMinCutForPalindrome(String str) {

		int[][] temp = new int[str.length()][str.length()];

	    for (int i = 0; i < str.length(); i++) {
			for (int j = 0 ; j < str.length(); j++){
			  temp[i][j] = Integer.MAX_VALUE;
			}
		}
		
	    //no cut is possible for 1 length string.
		for (int i = 0; i < str.length(); i++) {
			temp[i][i] = 0;
		}

		for (int len = 2; len <= str.length(); len++) {
			for (int i = 0; i <= str.length() - len; i++) {
				int j = i + len - 1;

				if (isPalindrome(str, i, j)) {
					temp[i][j] = 0;
				} else {
				   int min = Integer.MAX_VALUE;
				   for (int k = i; k < j; k++) {
                      int result = 1 + temp[i][k] + temp[k+1][j];
                      if (result < min){
                    	  min = result;
                      }
				   }
				 
				   temp[i][j] = Math.min(min, temp[i][j]);
				  
				}
			}
		}

		return temp[0][str.length()-1];
	}

	private boolean isPalindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(j) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
