package WildCardMatching;

/**
 * https://leetcode.com/problems/wildcard-matching/
 *
Wild car matching with ? and *
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

https://www.youtube.com/watch?v=3ZDZ-N0EPV0&index=27&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 *
 */
public class WildCardMatching {

	public boolean isMatch(String str, String pattern) {
		
		if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
			return false;
		}
		
		pattern = fixPattern(pattern);
		
		boolean[][] temp = new boolean[str.length()+1][pattern.length()+1];
		
		temp[0][0] = true;
		
		//string matching empty pattern is false
		for (int i = 1 ; i < temp.length; i ++){
			temp[i][0] = false;
		}
		
		//pattern matching empty string is false
		for (int j = 1; j < pattern.length(); j++){
			temp[0][j] = false;
		}
		
		//edge case .. * can match empty string
		if (pattern.charAt(0) == '*') {
			temp[0][1] = true;
		}
		
		for (int i = 1; i < temp.length; i++) {
			for(int j = 1; j < temp[i].length; j++) {
				if ((str.charAt(i-1) == pattern.charAt(j-1)) || (pattern.charAt(j-1) == '?')) {
					temp[i][j]= temp[i-1][j-1];
				} else if (pattern.charAt(j-1) == '*') {
					temp[i][j] = temp[i-1][j] || temp[i][j-1];					
				}
			}
		}
		
		return temp[str.length()][pattern.length()];
	}
	
	
	public String fixPattern(String pattern) {
		
		char[] patternArray = pattern.toCharArray();
		
		//fix the pattern replace multiple * with one *
        //e.g a**b***c --> a*b*c
		int k = 0;
		int writeIndex = 0;
		boolean isFirst = true;
		while (k < patternArray.length) {
			if (patternArray[k] == '*') {
				if (isFirst) {
					patternArray[writeIndex] = patternArray[k];
					k++;
					writeIndex++;
					isFirst = false;
				} else {
					k++;
					continue;
				}
			} else {
				patternArray[writeIndex] = patternArray[k];
				k++;
				writeIndex++;
				isFirst = true;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < writeIndex; i++) {
			sb.append(patternArray[i]);
		}
		
		return sb.toString();
		
	}
}
