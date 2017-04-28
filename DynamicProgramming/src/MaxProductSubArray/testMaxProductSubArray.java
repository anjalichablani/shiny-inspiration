package MaxProductSubArray;

import org.junit.Test;

public class testMaxProductSubArray {

	@Test
	public void test(){
		int[] input = {2,3,-2,4};
		MaxProductSubArray mp = new MaxProductSubArray();
		int result = mp.maxProduct(input);
		System.out.println(result);
	}
	
	@Test
	public void test_1(){
		int[] input = {-2,-3, 4, -1, -2, 1, 5, -3};
		MaxProductSubArray mp = new MaxProductSubArray();
		int result = mp.maxProduct1(input);
		System.out.println(result);
	}
	
	@Test
	public void test_2(){
		int[] input = {-2,-3, 4, 1, 5};
		MaxProductSubArray mp = new MaxProductSubArray();
		int result = mp.maxProduct1(input);
		System.out.println(result);
	}
	
	@Test
	public void test_3(){
		int[] input = {2,3, -2, 4, 8};
		MaxProductSubArray mp = new MaxProductSubArray();
		int result = mp.maxProduct1(input);
		System.out.println(result);
	}
	
	@Test
	public void test_4(){
		int[] input = {2,3, -2, 4};
		MaxProductSubArray mp = new MaxProductSubArray();
		int result = mp.maxProduct1(input);
		System.out.println(result);
	}
}
