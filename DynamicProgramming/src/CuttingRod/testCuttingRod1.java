package CuttingRod;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class testCuttingRod1 {

	@Test
	public void test1() {
		Map<Integer, Integer> inchToPriceMap = new HashMap<Integer, Integer>();
		inchToPriceMap.put(1, 2);
		inchToPriceMap.put(2,5);
		inchToPriceMap.put(3,7);
		inchToPriceMap.put(4,8);
		
		int rodLen = 8;
		CuttingRod1 cr = new CuttingRod1(inchToPriceMap, rodLen);
		int profit = cr.maxValue();
		
		System.out.println(profit);
		
	}
}
