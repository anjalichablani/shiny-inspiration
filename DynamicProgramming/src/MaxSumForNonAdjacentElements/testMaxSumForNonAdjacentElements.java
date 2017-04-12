package MaxSumForNonAdjacentElements;

import org.junit.*;
public class testMaxSumForNonAdjacentElements {

	@Test
	public void test() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input = {3, 2, 5, 10, 7};
		int result = msn.maxSum(input);
		System.out.println(result);
	}
	
	@Test
	public void test_circular() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input = {3, 2, 5, 10, 7};
		int result = msn.maxSumCircularArray(input);
		System.out.println(result);
	}
	
	@Test
	public void test_1() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input = {5, 5, 10, 100, 10, 5};
		int result = msn.maxSum(input);
		System.out.println(result);
	}
	
	@Test
	public void test_circular_1() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input = {5, 5, 10, 100, 10, 5};
		int result = msn.maxSumCircularArray(input);
		System.out.println(result);
	}
	
	@Test
	public void test_2() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input = {5,  5, 10, 40, 50, 35};
		int result = msn.maxSum(input);
		System.out.println(result);
	}
	
	@Test
	public void test_circular_2() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input =  {5,  5, 10, 40, 50, 35};
		int result = msn.maxSumCircularArray(input);
		System.out.println(result);
	}
	
	@Test
	public void test_3() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input =  { 2, 10, 13, 4, 2, 15, 10 };
		int result = msn.maxSum(input);
		System.out.println(result);
	}
	
	@Test
	public void test_circular_3() {
		MaxSumForNonAdjacentElements msn = new MaxSumForNonAdjacentElements();
		int[] input =  { 2, 10, 13, 4, 2, 15, 10 };
		int result = msn.maxSumCircularArray(input);
		System.out.println(result);
	}
}
