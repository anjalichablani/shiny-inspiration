package MaximumLengthChainPair;

import org.junit.Test;

public class testMaximumLengthChainPair {

	@Test
	public void test() {
		MaximumLengthChainPair.Pair p = new MaximumLengthChainPair.Pair(5,7);
		MaximumLengthChainPair.Pair p1 = new MaximumLengthChainPair.Pair(2,3);
		MaximumLengthChainPair.Pair p2 = new MaximumLengthChainPair.Pair(2,6);
		MaximumLengthChainPair.Pair p3 = new MaximumLengthChainPair.Pair(9,11);
		MaximumLengthChainPair.Pair p4 = new MaximumLengthChainPair.Pair(8,10);
		MaximumLengthChainPair.Pair p5 = new MaximumLengthChainPair.Pair(11,14);
	        
		MaximumLengthChainPair.Pair[] pairs = {p,p1,p2,p3,p4,p5};
	    MaximumLengthChainPair mlcp = new MaximumLengthChainPair();
	    int r = mlcp.getMaximumLengthChainPair(pairs);
	    System.out.print(r);
	}
	
	@Test
	public void test_1() {
		MaximumLengthChainPair.Pair p = new MaximumLengthChainPair.Pair(5,24);
		MaximumLengthChainPair.Pair p1 = new MaximumLengthChainPair.Pair(39,60);
		MaximumLengthChainPair.Pair p2 = new MaximumLengthChainPair.Pair(15,28);
		MaximumLengthChainPair.Pair p3 = new MaximumLengthChainPair.Pair(27,40);
		MaximumLengthChainPair.Pair p4 = new MaximumLengthChainPair.Pair(50,90);
		     
		MaximumLengthChainPair.Pair[] pairs = {p,p1,p2,p3,p4};
	    MaximumLengthChainPair mlcp = new MaximumLengthChainPair();
	    int r = mlcp.getMaximumLengthChainPair(pairs);
	    System.out.print(r);
	}
}
