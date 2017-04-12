package EggDropping;

import org.junit.Test;

public class testEggDrop {

	@Test
	public void testEggDropping() {
		EggDropping ed = new EggDropping();
		int floors = 6;
		int eggs = 2;
		int result = ed.findMinTrialsForDroppingEggs(floors, eggs);
		
		System.out.println(result);
		
	}
}
