package LongestCommonSubstring;
/*
 * http://www.geeksforgeeks.org/longest-common-substring/
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.

Examples :

Input : X = "GeeksforGeeks", y = "GeeksQuiz"
Output : 5
The longest common substring is "Geeks" and is of
length 5.

Input : X = "abcdxyz", y = "xyzabcd"
Output : 4
The longest common substring is "abcd" and is of
length 4.

Input : X = "zxabcdezy", y = "yzabcdezx"
Output : 6
The longest common substring is "abcdez" and is of
length 6.

 */

public class LongestCommonSubstring {

	String s1;
	String s2;
	int[][] temp;
	
	public LongestCommonSubstring(String s1, String s2){
		
		this.s1 = s1;
		this.s2 = s2;
		this.temp = new int[s1.length() + 1][s2.length()+1];
	}
	
	public String computeLongestCommonSubstring() {
		
		int maxLengthOfLCSubstring = 0;
		int[] maxIndex = new int[2];
		
		for (int i = 1; i <= s1.length(); i++) {
			for(int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					temp[i][j] = 1 + temp[i-1][j-1];
				} else {
					temp[i][j] = 0;
				}
				
				if (temp[i][j] > maxLengthOfLCSubstring) {
					maxLengthOfLCSubstring = temp[i][j];
					maxIndex[0] = i;
					maxIndex[1] = j;
				}
			}
		}
		System.out.println("Longest common substring length : " + maxLengthOfLCSubstring);
		
		return printLongestCommonSubstring(maxLengthOfLCSubstring, maxIndex);
	}
	
	private String printLongestCommonSubstring(int maxLengthOfLCSubstring, int[] maxIndex) {
		int i = maxIndex[0];
		int j = maxIndex[1];
		
		char[] output = new char[maxLengthOfLCSubstring];
		 int k = maxLengthOfLCSubstring - 1;
		
		while (temp[i][j] > 0) {
		   if (s1.charAt(i-1) == s2.charAt(j-1)) {
			   output[k]= s1.charAt(i-1);
			   k--;		 
		   }
		   i--;
		   j--;
		}
		return String.valueOf(output);
	}	
 }
