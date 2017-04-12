package SubsquareSurrounedByXs;

/**
 * 
 * Find maximum subsquare in a matrix made up of Xs and Os such that all four sides of subsquare are Xs. It does not matter what is inside
 * the subsquare. All 4 sides should be made up entirely of Xs
 * 
 * e.g 
 * 0 0 0 0 0 X         0,0  0,0  0,0  0,0  0,0  1,1
 * 0 X 0 X X X         0,0  1,1  0,0  1,1  1,2  2,3 
 * 0 X 0 X 0 X         0,0  2,1  0,0  2,1  0,0  3,1
 * 0 X X X X X         0,0  3,1  1,2  3,3  1,4  4,5
 * 0 0 0 0 0 0         0,0  0,0  0,0  0,0  0,0  0,0   
 * 
 * Output of above program should be 3
 * 
 * Solution
 * Have another matrix which is capable of holding 2 values hor and ver. 
 * Ver stores how far vertically you can see Xs. Hor stores how far horizontally you can see Xs.
 * Once this matrix is build look for biggest subsquare by getting min of hor and ver at each point and checking
 * if subsquare can be formed from value min to 1.
 * 
 * Test cases:
 * Matrix entirely made up of Xs
 * Matrix entirely made up of Os
 * Matrix with Xs and Os but maximum subsquare is length 1
 * 
 * https://www.youtube.com/watch?v=vi_1eHCsR9A&index=42&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 * http://www.geeksforgeeks.org/given-matrix-o-x-find-largest-subsquare-surrounded-x/
 * 
 * https://www.youtube.com/watch?v=vi_1eHCsR9A&index=42&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 * 
 */
public class SubsquareSurrounedByXs {

	public int findSubSquare(char[][] input) {
		
		int rows = input.length;
		int cols = input[0].length;
		Cell[][] temp = new Cell[rows][cols];
		
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < cols; j++) {
				temp[i][j] = new Cell(0,0);
			}
		}
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j< cols; j++) {
				if (input[i][j] == 'x' || input[i][j] == 'X'){
					if (i==0 && j==0) {
						Cell c = temp[i][j];
						c.ver = 1;
						c.hor = 1;
					} else if (i == 0) {
						Cell c = temp[i][j];						
						Cell leftCell = temp[i][j-1]; 
						c.ver = 1;
						c.hor = leftCell.hor + 1;
					} else if (j == 0) {
						Cell c = temp[i][j];
						Cell topCell = temp[i-1][j];
						c.ver = topCell.ver + 1;
						c.hor = 1;
					} else {
						Cell c = temp[i][j];
						Cell topCell = temp[i-1][j];
						Cell leftCell = temp[i][j-1];
						c.ver = topCell.ver + 1;
						c.hor = leftCell.hor + 1;					
					}
					
				}
			}
		}
		printCell(temp);
		int max = getMaxSquare(temp);
		return max;
	}
	
	//start iterating from bottom right corner and find min of hori or ver at every cell.
    //If this is greater than 1 then see if you can find a number between this min and 1
    //such that on left's ver and top's hori is greater greater than or equal to k.
	private int getMaxSquare(Cell[][] temp) {
		 int max = 1;
		 int rows = temp.length;
		 int cols = temp[0].length;
				 
	        for(int i= rows-1; i >=0 ; i--){
	            for(int j= cols-1 ; j >=0; j--){
	                if(temp[i][j].ver == 0 || temp[i][j].ver == 1 || temp[i][j].hor ==1 ){
	                    continue;
	                }
	                
	                int min = Math.min(temp[i][j].ver, temp[i][j].hor);
	                int k = 0;
	                for(k=min; k > 1; k--){
	                	int left = j-k+1;
	                	int top = i-k+1;
	                    if(temp[i][left].ver >= k && temp[top][j].hor >= k){
	                        break;
	                    }
	                }
	                if(max < k){
	                    max = k;
	                }
	            }
	        }
	        
	        return max;
	   }
	
	private void printCell(Cell[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j< temp[0].length; j++) {
				Cell c = temp[i][j];
				System.out.print(c);
			}
			System.out.print("\n");
		}
	}
	
	public class Cell{
		int ver = 0;
		int hor = 0;
		
		public Cell(int ver, int hor){
			this.ver = ver;
			this.hor = hor;
		}
		
		public String toString() {
			return String.format("{%d, %d}", ver, hor);
		}
	}
	
}
