package TwoStringInterleavingToFormThird;

import org.junit.Test;

public class testTwoStringInterleave {

	@Test
	public void test1() {
		String s1 = "aab";
		String s2 = "axy";
		String s3 = "aaxaby";
		
		TwoStringInterleavingToFormThird t = new TwoStringInterleavingToFormThird();
		boolean result = t.isInterleaved(s1, s2, s3);
		System.out.println("Are string interleaving : " + result);
		
	}
	
	@Test
	public void test2() {
		String s1 = "XXYM";
        String s2 = "XXZT";
        String s3 = "XXXZXYTM";
		
		TwoStringInterleavingToFormThird t = new TwoStringInterleavingToFormThird();
		boolean result = t.isInterleaved(s1, s2, s3);
		System.out.println("Are string interleaving : " + result);
		
	}
	
	@Test
	public void test3() {
		String s1 = "XXY";
		String s2 = "XXZ";
		String s3 = "XXZXXXY";
		
		TwoStringInterleavingToFormThird t = new TwoStringInterleavingToFormThird();
		boolean result = t.isInterleaved(s1, s2, s3);
		System.out.println("Are string interleaving : " + result);
		
	}
	
	@Test
	public void testrecursive1() {
		String s1 = "aab";
		String s2 = "axy";
		String s3 = "aaxaby";
		
		TwoStringInterleavingToFormThird t = new TwoStringInterleavingToFormThird();
		boolean result = t.isInterleavedRecursive(s1, s2, s3, 0, 0, 0);
		System.out.println("Are string interleaving : " + result);
		
	}
	
	@Test
	public void testrecursive2() {
		String s1 = "XXY";
		String s2 = "XXZ";
		String s3 = "XXZXXXY";
		
		TwoStringInterleavingToFormThird t = new TwoStringInterleavingToFormThird();
		boolean result = t.isInterleavedRecursive(s1, s2, s3, 0, 0, 0);
		System.out.println("Are string interleaving : " + result);
		
	}
	
	@Test
	public void testrecursive3() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		
		TwoStringInterleavingToFormThird t = new TwoStringInterleavingToFormThird();
		boolean result = t.isInterleavedRecursive(s1, s2, s3, 0, 0, 0);
		System.out.println("Are string interleaving : " + result);
		
	}
	
	@Test
	public void testrecursive4() {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		
		TwoStringInterleavingToFormThird t = new TwoStringInterleavingToFormThird();
		boolean result = t.isInterleavedRecursive(s1, s2, s3, 0, 0, 0);
		System.out.println("Are string interleaving : " + result);
		
	}
}
