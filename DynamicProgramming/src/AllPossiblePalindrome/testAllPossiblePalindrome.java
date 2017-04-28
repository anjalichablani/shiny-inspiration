package AllPossiblePalindrome;

import java.util.List;

import org.junit.Test;

public class testAllPossiblePalindrome {
	
	@Test
	public void test1() {
		AllPossiblePalidrome app = new AllPossiblePalidrome();
		List<List<String>> result = app.getAllPossiblePalindrome("abcbm");
		
		for (List<String> lst :result){
			System.out.print(lst.toString());
			System.out.print("\n");
		}
	}
}
