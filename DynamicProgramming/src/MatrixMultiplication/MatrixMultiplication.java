package MatrixMultiplication;

/**
 * 
 * @author anjali.chablani
 *
 */
public class MatrixMultiplication {

	
	
	public int computeMatrixMultiplicationCost(int[] arr) {

		int temp[][] = new int[arr.length][arr.length];
        int q = 0;
        for(int l=2; l < arr.length; l++){
            for(int i=0; i < arr.length - l; i++){
                int j = i + l;
                temp[i][j] = 1000000;
                for(int k=i+1; k < j; k++){         
                    q = (temp[i][k] + temp[k][j] + arr[i]*arr[k]*arr[j]);
                    if(q < temp[i][j]){
                        temp[i][j] = q;
                    }
                }
            }
        }
        return temp[0][arr.length-1];
	}

	
	public int computeCost(Matrix[] arr) {
		int temp[][] = new int[arr.length][arr.length];
		int q = 0;
		for (int len =2; len <= arr.length; len++) {
			for (int i =0; i <= arr.length-len; i++) {
				int j = i +len-1;
				temp[i][j] = 1000000;
				for(int k = i; k < j; k++) {
					//Add cost of operation for group-1 temp[i][k] and group-2 temp[k+1][j]
					//now multiply the results of 2 groups (arr[i].first * arr[k].second * arr[j].second) and add its cost .
					q = temp[i][k] + temp[k+1][j] + (arr[i].first * arr[k].second * arr[j].second);
					if (q < temp[i][j]) {
						temp[i][j] = q;
					}
					
				}
			}
		}
		printMatrix(temp);
		return temp[0][arr.length-1]; 
	}
	
	public void printMatrix(int[][] temp){
	
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0 ; j < temp[i].length; j++) {
				System.out.print(String.format(" %2d ", temp[i][j]));
			}
			System.out.print("\n");
		}
	}
	
	public static class Matrix{	
		public int first;
		public int second;
		
		public Matrix(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
}
