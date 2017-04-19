package PalindromePartition;

import org.junit.Test;

public class testPalindromePartition {

	@Test
	public void test(){
		String str = "abcbm";
		PalindromePartition pp = new PalindromePartition();
		int result = pp.computeMinCutForPalindrome(str);
		System.out.println(result);
	}
}
