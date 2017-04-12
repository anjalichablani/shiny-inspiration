package SubsetSum;

import org.junit.Test;

public class testSubsetSum {

	@Test
	public void test_1() {
		int[] input = {2,3, 7,8};
		int total = 11;
		SubsetSum s = new SubsetSum();
		boolean result = s.computeSubsetSum(input, total);
		System.out.println(result);
	}
	
	@Test
     public void test_2() {
		int[] input = {2,3, 7,8};
		int total = 14;
		SubsetSum s = new SubsetSum();
		boolean result = s.computeSubsetSum(input, total);
		System.out.println(result);
	}
	
	@Test
	public void test_3(){
		int[] input = {3, 34, 4, 12, 5, 2};
		int total = 9;
		SubsetSum s = new SubsetSum();
		boolean result = s.computeSubsetSum(input, total);
		System.out.println(result);
	}
}

