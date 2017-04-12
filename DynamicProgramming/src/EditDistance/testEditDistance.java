package EditDistance;

import org.junit.Test;

public class testEditDistance {

	@Test
	public void test() {
		
		String s1 = "azcef";
		String s2 = "abcdef";
		
		EditDistance ed = new EditDistance();
		int result = ed.computeEditDistance(s1, s2);
		System.out.println(result);
	}
	
	@Test
	public void test_4() {
		
		String s1 = "abcdef";
		String s2 = "azced";
		
		EditDistance ed = new EditDistance();
		int result = ed.computeEditDistance(s1, s2);
		System.out.println(result);
	}
	
	@Test
	public void test_1() {
		
		String s1 = "sunday";
		String s2 = "saturday";
		
		EditDistance ed = new EditDistance();
		int result = ed.computeEditDistance(s1, s2); 
		System.out.println(result);
	}
	
	@Test
	public void test_rec() {
		
		String s1 = "abcdef";
		String s2 = "azcef";
		
		EditDistance ed = new EditDistance();
		int result = ed.recEditDistance(s1, s2, s1.length(), s2.length()); 
		System.out.println(result);
	}
	
	
}
