package CountNumberOfBST;

/**
 * http://www.geeksforgeeks.org/g-fact-18/
 * 
 * Count number of binary search tree created for array of size n
 *        #of bst    keys
 * t[0] =  1        (empty)
 * t[1] =  1        (10)
 * t[2] =  2        (10,11)
 * t[3] =  5        (10, 11, 12)
 * t[4] =  14       (10, 11, 12, 13)
 * t[5] =  42       (10, 11, 12, 13, 14)
 * 
 * when 3 keys (10, 11, 12) 5 possible BST
 * 
 * 10   10     11      12     12
 *  \    \     / \     /      /
 *  11    12  10  12  10     11
 *   \     \           \     /
 *   12    11           11  10
 */
public class CountNumberOfBST {

	//j is # of keys on left of root
	// i-j-1 #of keys on the right of the root
	//refer notes
	
	public int computeCountOfPossibleBST(int n) {
		
		int [] temp = new int[n+1];
		temp[0] =1;
		temp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
			  sum +=  temp[j] * temp[i-j-1];  //temp[j] denotes # of bst from keys ..left of the root, j # of keys on left			                      
			}                                 //temp[i-j-1] denotes # of bst from keys ..right of the root, j-i-1 # of keys on right
			temp[i] = sum;
		}
		
		return temp[n];
		
	}
}
