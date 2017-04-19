package LongestConsecutiveSequence;

import org.junit.Test;

public class testLongestConsecutiveSequence {

	@Test
	public void test(){
		int [] input = {100, 4, 200, 1, 3, 2};
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		int result = lcs.computeLongestConsecutive(input);
		System.out.println(result);
	}
}
