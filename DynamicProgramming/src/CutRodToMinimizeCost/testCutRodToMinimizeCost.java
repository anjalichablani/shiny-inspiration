package CutRodToMinimizeCost;

import org.junit.Test;

public class testCutRodToMinimizeCost {

	@Test
	public void test() {
		int markings[] = {2,3,6,7};
        CutRodToMinimizeCost cr = new CutRodToMinimizeCost();
        int cost = cr.cutRodToMinimizeCost(markings, 8);
        System.out.println(cost);  
	}
	
	@Test
	public void test1() {
		int markings[] = {1, 2, 5};
        CutRodToMinimizeCost cr = new CutRodToMinimizeCost();
        int cost = cr.cutRodToMinimizeCost(markings, 6);
        System.out.println(cost);  
	}
}
