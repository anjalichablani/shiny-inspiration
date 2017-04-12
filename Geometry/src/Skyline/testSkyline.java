package Skyline;

import org.junit.Test;

public class testSkyline {

	@Test
	public void test() {
		 //int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
		
		int [][] buildings = {{1,3,3}, {2,4,4}, {5,8, 2}, {6,7,4}, {8,9,4}};
		 Skyline skyline = new Skyline();
		 skyline.getSkyLine(buildings);
		
	}
}
