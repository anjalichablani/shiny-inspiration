package MinJumpToReachEnd;

import org.junit.Test;

public class testMinJumpToReachEnd {

	@Test
	public void test() {
		MinJumpToReachEnd mj = new MinJumpToReachEnd();
		int input[] = { 1, 3, 5, 3, 2, 2, 6, 1, 6, 8, 9 };

		int result = mj.computeMinJumpToReachEnd(input);
		System.out.println("Min jump to reach end " + result);

	}

	@Test
	public void test1() {
		MinJumpToReachEnd mj = new MinJumpToReachEnd();
		int input[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int result = mj.computeMinJumpToReachEnd(input);
		System.out.println("Min jump to reach end " + result);
	}
}
