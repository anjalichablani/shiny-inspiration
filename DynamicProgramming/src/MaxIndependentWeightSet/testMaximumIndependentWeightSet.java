package MaxIndependentWeightSet;

import org.junit.Test;

public class testMaximumIndependentWeightSet {

	@Test
	public void test(){
 	   int[] weight = {4,8, 2,9,6};
 	   
 	  MaxIndependentWeightSet ws = new MaxIndependentWeightSet();
 	  int result = ws.getMaxIndependentWeightSet(weight);
 	  
 	  System.out.println(result);
	}
	
}
