package CountNumberOfBST;

import org.junit.Test;

public class testCountNumberOfBST {

	@Test
	public void test() {
		
		int n = 5;
		CountNumberOfBST countPossibleBST = new CountNumberOfBST();
		int result = countPossibleBST.computeCountOfPossibleBST(n);
		
		System.out.println(String.format("Number of possible BST %s with %s keys", result, n));
	}
}
