package LongestCommonSubstring;

import static org.junit.Assert.*;

import org.junit.Test;

public class testLongestCommonSubstring {

	@Test
	public void testLCSubstring() {
		
		String s1 = "abcdaf";
		String s2 = "zbcdf";
		
		LongestCommonSubstring lcs = new LongestCommonSubstring(s1, s2);
		String commonSubString = lcs.computeLongestCommonSubstring();
		
		assertEquals(commonSubString, "bcd");
		
		
		System.out.println("Longest common substring is : " + commonSubString);
	
	}
	
	@Test
	public void testLCSubstring_1() {
		
		String s1 = "abcdxyz";
		String s2 = "xyzabcd";
		
		LongestCommonSubstring lcs = new LongestCommonSubstring(s1, s2);
		String commonSubString = lcs.computeLongestCommonSubstring();
		
		assertEquals(commonSubString, "abcd");
		
		
		System.out.println("Longest common substring is : " + commonSubString);
	
	}
	
	@Test
	public void testLCSubstring_2() {
		
		String s1 = "geeksforgeeks";
		String s2 = "geeksquiz";
		
		LongestCommonSubstring lcs = new LongestCommonSubstring(s1, s2);
		String commonSubString = lcs.computeLongestCommonSubstring();
		
		assertEquals(commonSubString, "geeks");
		
		
		System.out.println("Longest common substring is : " + commonSubString);
	
	}
}
