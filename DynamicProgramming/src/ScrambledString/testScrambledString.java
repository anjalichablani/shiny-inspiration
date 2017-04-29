package ScrambledString;

import org.junit.Test;

public class testScrambledString {

	@Test
	public void test_1() {
		ScrambledString s = new ScrambledString();
		String s1 = "great";
		String s2 = "rgtae";
		System.out.println(s.isScramble(s1, s2));
	}
	
	@Test
	public void test_2() {
		ScrambledString s = new ScrambledString();
		String s1 = "great";
		String s2 = "taerg";
		System.out.println(s.isScramble(s1, s2));
	}
	
	@Test
	public void test_3() {
		ScrambledString s = new ScrambledString();
		String s1 = "great";
		String s2 = "raegt";
		System.out.println(s.isScramble(s1, s2));
	}
	
	@Test
	public void test_4() {
		ScrambledString s = new ScrambledString();
		String s1 = "great";
		String s2 = "ravgt";
		System.out.println(s.isScramble(s1, s2));
	}
}
