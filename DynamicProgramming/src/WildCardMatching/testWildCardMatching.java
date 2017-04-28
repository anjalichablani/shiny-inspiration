package WildCardMatching;

import org.junit.Test;

public class testWildCardMatching {

	@Test
	public void test_fixPattern_1(){
		WildCardMatching wcm = new WildCardMatching();
		String pattern = wcm.fixPattern("a**b***c**");
		System.out.println(pattern);
	}
	
	@Test
	public void test_fixPattern_2(){
		WildCardMatching wcm = new WildCardMatching();
		String pattern = wcm.fixPattern("a**b***c");
		System.out.println(pattern);
	}
	
	@Test
	public void test_patternMatching(){
		WildCardMatching wcm = new WildCardMatching();
		String str = "xbylmz";
		String pattern = "x?y*z";
		boolean isMatch = wcm.isMatch(str, pattern);
		System.out.println(String.format("string %s with pattern %s match %s" , str, pattern, isMatch));
	}
}
