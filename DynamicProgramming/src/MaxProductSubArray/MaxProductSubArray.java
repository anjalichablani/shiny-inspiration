package MaxProductSubArray;

public class MaxProductSubArray {

	int maxProduct(int[] input) {
	    // store the result that is the max we have found so far
	    int r = input[0];
        int imax = input[0];
        int imin = input[0];
  
	    // imax/imin stores the max/min product of
	    // subarray that ends with the current number A[i]
	    for (int i = 1; i < input.length; i++) {
	        // multiplied by a negative makes big number smaller, small number bigger
	        // so we redefine the extremums by swapping them
	        if (input[i] < 0){
	        	int temp = imax;
	        	imax = imin;
	        	imin = temp;
	        }

	        // max/min product for the current number is either the current number itself
	        // or the max/min by the previous number times the current one
	        imax = Math.max(input[i], imax * input[i]);
	        imin = Math.min(input[i], imin * input[i]);

	        // the newly computed max value is a candidate for our global result
	        r = Math.max(r, imax);
	    }
	    return r;
	}
	
	public int maxProduct1(int[] input) {
	    if (input.length == 0) {
	        return 0;
	    }
	    
	    int max_current = input[0];
	    int min_current = input[0];
	    int max_global = input[0];
	    int max, min;
	    
	    for (int i = 1; i < input.length; i++) {
	    	max = Math.max(Math.max(max_current * input[i], min_current * input[i]), input[i]);
	        min = Math.min(Math.min(max_current * input[i], min_current * input[i]), input[i]);
	        max_global = Math.max(max, max_global);
	        max_current = max;
	        min_current = min;
	    }
	    
	    return max_global;
	}

}
