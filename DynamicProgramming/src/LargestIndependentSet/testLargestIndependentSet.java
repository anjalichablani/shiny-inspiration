package LargestIndependentSet;

import org.junit.Test;

public class testLargestIndependentSet {

	@Test 
	public void testLISS() {
		
		LargestIndependentSet liss = new LargestIndependentSet();
		int [] data = {10, 20, 40, 50, 70, 80, 30, 60};
		liss.insert(data);
		
		liss.traverseTree();
		
		int result = liss.getLargestIndependentSet();
		System.out.println("Largest Independen set: " + result);
	}
}
