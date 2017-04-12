package LongestEvenLengthSubstringOfEqualHalf;

import org.junit.Test;

public class testLongestEvenLengthSubstringOfEqualHalf {

	@Test
	public void test() {
		int input[] = {1,5,3,8,0,2,14,9};
        LongestEvenLengthSubstringOfEqualHalf lel = new LongestEvenLengthSubstringOfEqualHalf();
        System.out.println("Max lenght is " + lel.findMaxLength(input));
	}
	
}
