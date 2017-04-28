package UglyNumbers;

import org.junit.Test;

public class testUgly {

	@Test
	public void test(){
		UglyNumber s = new UglyNumber();
		boolean result = s.isUgly(14);
		System.out.println(result);
		
	}
	
	@Test
	public void test_1(){
		UglyNumber s = new UglyNumber();
		boolean result = s.isUgly(9);
		System.out.println(result);
		
	}
	
	@Test
	public void test_2(){
		Solutions un = new Solutions();
		int no = un.nthUglyNumber(12);
	    System.out.println("12th ugly no. is "+ no);
	}
	
	@Test
	public void test_3(){
		Solutions un = new Solutions();
		int no = un.nthUglyNumber(333);
	    System.out.println("333rd ugly no. is "+ no);
	}
	
	@Test
	public void test_4(){
		Solutions un = new Solutions();
		int no = un.nthUglyNumberDP(7);
	    System.out.println("7th ugly no. is "+ no);
	}
}
