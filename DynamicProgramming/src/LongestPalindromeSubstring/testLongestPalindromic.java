package LongestPalindromeSubstring;

import org.junit.Test;

public class testLongestPalindromic {

	@Test
	public void test_1() {
	  LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
      System.out.println(lps.computeLongestPalindromeSubstring("abba".toCharArray()));
	}
	
	@Test
	public void test_2() {
	  LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
	  System.out.println(lps.computeLongestPalindromeSubstring("abbababba".toCharArray()));
	}
	
	@Test
	public void test_3() {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
		System.out.println(lps.computeLongestPalindromeSubstring("babcbaabcbaccba".toCharArray()));
	}
	
	@Test
	public void test_4() {
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
		System.out.println(lps.computeLongestPalindromeSubstring("cdbabcbabdab".toCharArray()));
	}
}
