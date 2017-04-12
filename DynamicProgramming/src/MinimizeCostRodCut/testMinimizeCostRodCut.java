package MinimizeCostRodCut;

import org.junit.Test;


public class testMinimizeCostRodCut {

	@Test
	public void test1() {
		int markings[] = {1, 2, 5};
		MinimizeCostRodCut cr = new MinimizeCostRodCut();
        int cost = cr.minCost(markings, 6);
        System.out.println(cost);  
	}
}
