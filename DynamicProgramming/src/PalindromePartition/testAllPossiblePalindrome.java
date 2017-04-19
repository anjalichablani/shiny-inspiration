package PalindromePartition;

import java.util.List;

import org.junit.Test;

public class testAllPossiblePalindrome {

	@Test
	public void test() {
		AllPossiblePalindrome app = new AllPossiblePalindrome();
		List<List<String>> result = app.partition("abcbm");
		
		for (List<String> lst :result){
			System.out.print(lst.toString());
			System.out.print("\n");
		}
	}
	
	@Test
	public void test1() {
		AllPossiblePalidromePractice app = new AllPossiblePalidromePractice();
		List<List<String>> result = app.getAllPossiblePalindrome("abcbm");
		
		for (List<String> lst :result){
			System.out.print(lst.toString());
			System.out.print("\n");
		}
	}
}
