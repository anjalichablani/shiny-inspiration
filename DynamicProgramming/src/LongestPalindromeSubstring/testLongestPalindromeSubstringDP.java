package LongestPalindromeSubstring;

import org.junit.Test;

public class testLongestPalindromeSubstringDP {

	@Test
	public void test_1() {	  
	  LongestPalindromeSubstringDP lps = new LongestPalindromeSubstringDP();
      System.out.println(lps.computeLongestPalindromeDynamic("abba"));
	}
	
	@Test
	public void test_2() {
		LongestPalindromeSubstringDP lps = new LongestPalindromeSubstringDP();
	  System.out.println(lps.computeLongestPalindromeDynamic("abbababba"));
	}
	
	@Test
	public void test_3() {
		LongestPalindromeSubstringDP lps = new LongestPalindromeSubstringDP();
		System.out.println(lps.computeLongestPalindromeDynamic("babcbaabcbaccba"));
	}
	
	@Test
	public void test_4() {
		LongestPalindromeSubstringDP lps = new LongestPalindromeSubstringDP();
		System.out.println(lps.computeLongestPalindromeDynamic("cdbabcbabdab"));
	}
}
