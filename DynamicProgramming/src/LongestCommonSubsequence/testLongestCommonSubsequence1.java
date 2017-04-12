package LongestCommonSubsequence;

import org.junit.Test;

public class testLongestCommonSubsequence1 {

	@Test
	public void test() {
		LongestCommonSubsequence1 lcs = new LongestCommonSubsequence1();
		
		String str1 = "AEDPHR";
		String str2 = "APCDGHLQR";
		lcs.lcsDynamic(str1, str2);

		
	}
	
	@Test
	public void test_1() {
		LongestCommonSubsequence1 lcs = new LongestCommonSubsequence1();
		
		String str1 = "abcdaf";
		String str2 = "acbcf";
		lcs.lcsDynamic(str1, str2);
	}
}
