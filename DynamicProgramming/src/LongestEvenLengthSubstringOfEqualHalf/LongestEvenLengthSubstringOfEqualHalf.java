package LongestEvenLengthSubstringOfEqualHalf;
/**
 * http://www.geeksforgeeks.org/longest-even-length-substring-sum-first-second-half/
 * 
 * Test cases
 * Even length string
 * odd length string
 * 0 length string
 *
 */
public class LongestEvenLengthSubstringOfEqualHalf {
	
	public int findMaxLength(int input[]){
        if( input == null || input.length == 0)
        	return 0;
        
        int temp[][] = new int[input.length][input.length];
        
        for(int i=0; i < temp.length; i++){
        	temp[i][i] = input[i];
        }
        
        int max = 0;
        int maxIndex = -1;
        for(int len = 2; len <= input.length; len++){
            for(int i=0; i <= input.length - len; i++){
                int j = i + len-1;
                //updating sum for each length
                temp[i][j] = temp[i][j-1] + input[j];
                
                if(len % 2 == 0){
                    int mid = (i + j)/2;
                    if(temp[i][mid] == temp[mid + 1][j]){
                        if(max < len){
                            max = len;
                            maxIndex = i;
                        }
                    }
                }
            }
        }
        
        printSubStr(input, maxIndex, max);
        return max;
    }
	
	private void printSubStr(int[] input, int maxIndex, int max) {
		System.out.println("Printing substr \n");
		int k = maxIndex+max;
		for (int i = maxIndex; i < k; i++) {
			System.out.print(input[i] + " ");
		}
		System.out.print("\n");
	}
}
