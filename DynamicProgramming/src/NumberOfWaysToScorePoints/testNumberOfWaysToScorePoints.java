package NumberOfWaysToScorePoints;

import org.junit.Test;

public class testNumberOfWaysToScorePoints {

	@Test
	public void test() {
		int score[] = { 1, 2, 3 };
		NumberOfWaysToScorePoints now = new NumberOfWaysToScorePoints();
		System.out.println(now.computeNumberOfWaysToScorePoints(score, 4));
	}
	
	@Test
	public void test_1() {
		int score[] = { 3, 5, 10 };
		NumberOfWaysToScorePoints now = new NumberOfWaysToScorePoints();
		System.out.println(now.computeNumberOfWaysToScorePoints(score, 18));

	}
}
