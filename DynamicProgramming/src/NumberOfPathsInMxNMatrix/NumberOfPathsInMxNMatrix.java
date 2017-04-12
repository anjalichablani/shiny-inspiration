package NumberOfPathsInMxNMatrix;

//Time complexity of the above dynamic programming solution is O(mn).
//The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints
//that from each cell you can either move only to right or down

public class NumberOfPathsInMxNMatrix {

	// Returns count of possible paths to reach cell at row number m and column
	// number n from the topmost leftmost cell (cell at 1, 1)
	public int numberOfPaths(int[][] input, int rows, int cols) {
		
		// Create a 2D table to store results of subproblems
		int[][] temp = new int[rows][cols];
		
		 // Count of paths to reach any cell in first column is 1
		for (int i = 0; i < rows; i++) {
			temp[i][0] =1;
		}
	
		// Count of paths to reach any cell in first column is 1   
		for (int j = 0; j < cols; j++) {
			temp[0][j] =1;
		}
		
		
		// By un-commenting the last part the code calculate the total
        // possible paths if the diagonal Movements are allowed
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < cols; j++) {
				temp[i][j] = temp[i][j-1] + temp[i-1][j]; //temp[i-1][j-1]
			}
		}
		
		return temp[rows-1][cols-1];
	}
	
	
	
}
