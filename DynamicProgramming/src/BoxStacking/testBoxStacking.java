package BoxStacking;

import org.junit.Test;

public class testBoxStacking {

	@Test
	public void test() {
		
		Dimension[] input = {new Dimension(3, 2, 5), new Dimension(1, 2, 4)};		
		BoxStacking boxStacking = new BoxStacking();
		int result = boxStacking.getMaxHeight(input);
		System.out.println("Max Height that can be obtained by stacking boxes with the above dimensions is " + result);
		
	}
}
