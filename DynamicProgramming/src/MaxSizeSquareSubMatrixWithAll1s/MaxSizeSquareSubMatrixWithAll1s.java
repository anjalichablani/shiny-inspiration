package MaxSizeSquareSubMatrixWithAll1s;
/**
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 *
 * 1) Construct a sum matrix S[R][C] for the given M[R][C].
     a)	Copy first row and first columns as it is from M[][] to S[][]
     b)	For other entries, use following expressions to construct S[][]
         If M[i][j] is 1 then
            S[i][j] = min(S[i][j-1], S[i-1][j], S[i-1][j-1]) + 1
         Else If M[i][j] is 0
            S[i][j] = 0
   2) Find the maximum entry in S[R][C]
   3) Using the value and coordinates of maximum entry in S[i], print sub-matrix of M[][]
   
 * 
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSizeSquareSubMatrixWithAll1s {

	public int computeMaxSquareSubMatrixWithAll1s(int[][] matrix) {
		
		int[][] temp = new int[matrix.length][matrix[0].length];
		int max = 0;
		
		//all rows 0th column
		for(int i = 0; i < matrix.length; i++){
			temp[i][0] = matrix[i][0];
			if (temp[i][0] == 1) {
				max = 1;
			}
		}
		
		//0th row all columns
		for (int j = 0; j< matrix[0].length; j++){
			temp[0][j] = matrix[0][j];
			if (temp[0][j] == 1) {
				max = 1;
			}
		}
		
		for (int i=1; i < matrix.length; i++){
			for(int j=1; j< matrix[i].length; j++){
				if (matrix[i][j] == 0){
					temp[i][j]=0;
				} else {
					int min = min(temp[i][j-1], temp[i-1][j], temp[i-1][j-1]); //min of cells at left, above, diagonal
					temp[i][j] = min + 1; //add 1 to min value
					if (temp[i][j] > max) {
						max = temp[i][j];
					}
				}
			}
		}
		
		return max;
		
	}
	
	private int min(int a, int b, int c) {
		
		int x = Math.min(a, b);
		int min = Math.min(x, c);
		
		return min;
	}
}
