package OptimalBinarySearchTree;

import org.junit.Test;

public class testOptimalBinarSearchTree {

	@Test
	public void testOptimalBST() {
		int[] arr = {10, 12, 16, 21};
		int[] freq = {4, 2, 6, 3};
		
		OptimalBinarySearchTree obst = new OptimalBinarySearchTree();
		int result = obst.computeCostForOptimalBinarySerachTree(freq, arr);
		System.out.println("Cost of Optimal BST is: "+ result);
	}
}
