package ScrambledString;


/**
 * https://leetcode.com/problems/scramble-string/#/description
 * 
 *
 */
public class ScrambledString {

	public boolean isScramble(String s1, String s2) {
		if (s1 == null && s2 == null)
			return false;

		if (s1.length() != s2.length())
			return false;

		if (s1.length() == 0 && s2.length() == 0)
			return true;

		return isScrambleInner(s1, s2);
	}

	private boolean isScrambleInner(String str1, String str2) {

		if (str1.length() != str2.length())
			return false;

		if (str1.equals(str2))
			return true;

		int len = str1.length();

		//Check characters.
		int[] temp = new int[26];
		for (int i = 0; i < str1.length(); i++) {
			temp[str1.charAt(i) - 'a']++;
			temp[str2.charAt(i) - 'a']--;
		}

		for (int i = 0; i < 26; i++) {
			if (temp[i] != 0)
				return false;
		}

		// More letters
		for (int i = 1; i < len; i++) {
			String str1_1 = str1.substring(0, i);
			String str1_2 = str1.substring(i, len);
			String str2_1 = str2.substring(0, i);
			String str2_2 = str2.substring(i, len);
			if (isScramble(str1_1, str2_1) && isScramble(str1_2, str2_2)){
				return true;
			}
			
			str2_1 = str2.substring(0, len - i);
			str2_2 = str2.substring(len - i, len);
			if (isScramble(str1_1, str2_2) && isScramble(str1_2, str2_1)){
				return true;
			}
		}

		return false;
	}

}
