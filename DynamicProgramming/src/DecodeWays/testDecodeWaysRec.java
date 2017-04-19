package DecodeWays;

import org.junit.Test;

public class testDecodeWaysRec {

	@Test
	public void test() {
		DecodeWaysRec d = new DecodeWaysRec();
		int result = d.getNumOfDecoding("1268");
		System.out.println(result);
	}
	
}
