package MaximumProductCutting;

/**
 * 
 *http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/
 *
 * Given a rope of length n meters, cut the rope in different parts of integer lengths in a way that maximizes product of 
 * lengths of all parts. You must make at least one cut. Assume that the length of rope is more than 2 meters.
 */
public class MaximumProductCutting {

	
	public int maxProduct(int num){
        int temp[] = new int[num+1];
        temp[0] = 1;
        
        for(int i=1; i <= num; i++){
        	temp[i] = i;
        }
        for(int i=2; i <= num; i++){
            for(int j=1; j < i; j++){
            	temp[i] = Math.max(temp[i],temp[j]*temp[i-j]);
            }
        }
        return temp[num];
    }
}
