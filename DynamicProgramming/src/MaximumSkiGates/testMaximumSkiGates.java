package MaximumSkiGates;

import org.junit.Test;

public class testMaximumSkiGates {

	@Test
	public void test(){
		 int input[] = {15, 13, 5, 7, 4, 10, 12, 8, 2, 11, 6, 9 , 3};
	     MaximizeSkiGates sg = new MaximizeSkiGates();
	     System.out.println(sg.solution(input, 2));
	}
}
