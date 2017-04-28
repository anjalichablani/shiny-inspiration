package OneEditDistance;

import org.junit.Test;

public class testOneEditDistance {

	@Test
	public void test(){
		 String s1 = "gfg";
		  String s2 = "gf";
		  OneEditDistance oed = new OneEditDistance();
		  boolean result = oed.isEditDistanceOne(s1, s2);
		  System.out.println(result);
	}
}
