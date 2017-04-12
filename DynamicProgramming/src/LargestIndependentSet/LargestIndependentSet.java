package LargestIndependentSet;

/**
 * http://www.geeksforgeeks.org/largest-independent-set-problem/ 
 * 
 * Given a Binary Tree, find size of the Largest Independent Set(LIS) in it. 
 * A subset of all tree nodes is an independent set if there is no edge between any two nodes of the subset.
 * For example, consider the following binary tree. 
 * The largest independent set(LIS) is {10, 40, 60, 70, 80} and size of the LIS is 5.
 *    10
 *   /  \
 *  20  30
 * / \    \ 
 *40 50    60
 *   / \
 *  70  80
 */

public class LargestIndependentSet {	
	private BSTNode root;

	public int getLargestIndependentSet() {	
		int result  = computeLIS(root);
		return result;
	}
	
	public void insert(int[] data) {
		root = createNewNode(data[0]);
		root.left = createNewNode(data[1]);
		root.left.left = createNewNode(data[2]);
		root.left.right = createNewNode(data[3]);
		root.left.right.left = createNewNode(data[4]);
		root.left.right.right = createNewNode(data[5]);
		root.right = createNewNode(data[6]);
		root.right.right = createNewNode(data[7]);
	}

	private BSTNode createNewNode(int data) {
		BSTNode node = new BSTNode(data);
		return node;
	}

	private void preOrderTraversal(BSTNode root) {
		if (root == null){
			return;
		}
		System.out.println(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
	}
	
	public void traverseTree() {
		preOrderTraversal(root);
	}
	
	public int computeLIS(BSTNode root) {
	
		if(root == null)
			return 0;
		
		if (root.liss > 0) {
			return root.liss;
		}
		
		if (root.left == null && root.right == null) 
			return (root.liss = 1);
		
		// Calculate size excluding the current node
		int liss_excl_left =computeLIS(root.left);
	    int liss_excl_right =  computeLIS(root.right);
	    int liss_excl = liss_excl_left + liss_excl_right;
	 
	    // Calculate size including the current node
	    int liss_incl = 1;
	    if (root.left != null) {
	    	int liss_incl_left_left = computeLIS(root.left.left);
	    	int liss_incl_left_right = computeLIS(root.left.right);
	        liss_incl +=  liss_incl_left_left + liss_incl_left_right;
	    }
	    
	    if (root.right != null) {
	    	int liss_incl_right_left = computeLIS(root.right.left);
	    	int liss_incl_right_right = computeLIS(root.right.right);
	        liss_incl += liss_incl_right_left + liss_incl_right_right;
	    }
	 
	    // Maximum of two sizes is liss, store it for future uses.
	    root.liss = Math.max(liss_incl, liss_excl);
	 
		return root.liss;
	}
	
	public static class BSTNode {
		public int data;
		public BSTNode left;
		public BSTNode right;
		public int liss; 

		public BSTNode(int data) {
			this.data = data;
			this.left = this.right = null;
			this.liss = 0;
		}
	}
}
