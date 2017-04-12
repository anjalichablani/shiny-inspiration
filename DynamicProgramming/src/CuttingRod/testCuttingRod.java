package CuttingRod;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class testCuttingRod {

	@Test
	public void testCuttingRodProb() {
		CuttingRod cr = new CuttingRod();
        Map<Integer, Integer> inchToPriceMap = new HashMap<Integer, Integer>();
        inchToPriceMap.put(1, 1);
        inchToPriceMap.put(2, 5);
        inchToPriceMap.put(3, 8);
        inchToPriceMap.put(4, 9);
        inchToPriceMap.put(5, 10);
        inchToPriceMap.put(6, 17);
        inchToPriceMap.put(7, 17);
        inchToPriceMap.put(8, 20);
        
        System.out.println("Maximum Obtainable Value is " + cr.maxValue(inchToPriceMap, 8));
	}
	
	@Test
	public  void testCuttingRod1Prob(){
        
        int[] price = {0,3,5,8,9,10,20,22,25};
        //CuttingRod1 cr = new CuttingRod1(price);
        //int result = cr.maxValue();
        //System.out.println(result);
       
    }
}
