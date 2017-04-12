package MinimumCostTrainTicket;

import org.junit.Test;

public class testMinimumCostTrainTicket {

	@Test
	public void test() {
	int input[][] = {
				      {0, 15, 80, 90},
                      {-1, 0,  40, 50},
                      {-1, -1,  0,  70},
                      {-1, -1,  -1,  0}};
     MinimumCostTrainTicket mctt = new MinimumCostTrainTicket();
     System.out.println(mctt.minCost(input));
	}
	
	@Test
	public void test_1() {
	int input[][] = {
				      {0, 15, 80, 90},
                      {-1, 0,  40, 50},
                      {-1, -1,  0,  7},
                      {-1, -1,  -1,  0}};
     MinimumCostTrainTicket mctt = new MinimumCostTrainTicket();
     System.out.println(mctt.minCost(input));
	}
}
