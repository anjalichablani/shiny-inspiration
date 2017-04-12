package MaxRectangleHistogram;

import org.junit.Test;

public class testMaxRectangleHistogram {

	@Test
	public void test() {
		int heights[] = {6, 2, 5, 4, 5, 1, 6};
		//int heights[] = {2,2,2,6,1,5,4,2,2,2,2};
		MaxRectangleHistogram hist = new MaxRectangleHistogram();
		int maxRect = hist.maxRectangleHistogram(heights);
		System.out.println("Max Rectangle in histogram is of size " + maxRect);
	}
}
