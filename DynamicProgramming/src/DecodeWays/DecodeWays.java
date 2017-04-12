package DecodeWays;
/**
 *  Used a temp array of size n + 1 to save subproblem solutions. 
 *  temp[0] means an empty string will have one way to decode, temp[1] means the way to decode a string of size 1. 
 *  I then check one digit and two digit combination and save the results along the way. 
 *  In the end, temp[n] will be the end result.
 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * 26-> Z
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * https://leetcode.com/problems/decode-ways/
 */

public class DecodeWays {

	public int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int len = s.length();
		
		int[] temp = new int[len + 1];
		temp[0] = 1;
		temp[1] = s.charAt(0) != '0' ? 1 : 0;

		for (int i = 2; i <= len; i++) {
			int first = Integer.valueOf(s.substring(i - 1, i));
			int second = Integer.valueOf(s.substring(i - 2, i));
			if (first >= 1 && first <= 9) {
				temp[i] += temp[i - 1];
			}
			if (second >= 10 && second <= 26) {
				temp[i] += temp[i - 2];
			}
		}
		return temp[len];
	}
}