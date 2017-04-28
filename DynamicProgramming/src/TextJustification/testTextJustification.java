package TextJustification;

import org.junit.Test;

public class testTextJustification {

	@Test
	public void test_1(){
        String str = "Anjali likes to code";
        TextJustification tj = new TextJustification();
        tj.justify(str, 10);
    }
	
	
	
	@Test
	public void test_2(){
		String str = "Geeks for Geeks presents word wrap problem";
        TextJustification tj = new TextJustification();
        tj.justify(str, 15);
    }
	
}
