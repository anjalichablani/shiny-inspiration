package RemoveToMake2TimesMinGreaterThanMax;

import org.junit.Test;

public class testRemoveToMake2IntoMinGreaterThanMax {

	@Test
	public void test() {
		int[] arr = {5, 1, 3, 1, 3, 8, 3};
		RemoveToMake2IntoMinGreaterThanMax r = new RemoveToMake2IntoMinGreaterThanMax();
		int minRemovals = r.computeMinimumRemovalsFromEnd(arr);
		System.out.println(minRemovals);
	}
	
	@Test
	public void test1() {
		int[] arr = {4, 5, 100, 9, 10, 11, 12, 15, 200};
		RemoveToMake2IntoMinGreaterThanMax r = new RemoveToMake2IntoMinGreaterThanMax();
		int minRemovals = r.computeMinimumRemovalsFromEnd(arr);
		System.out.println(minRemovals);
	}
	
	@Test
	public void test2() {
		int[] arr = {20, 7, 5, 6};
		RemoveToMake2IntoMinGreaterThanMax r = new RemoveToMake2IntoMinGreaterThanMax();
		int minRemovals = r.computeMinimumRemovalsFromEnd(arr);
		System.out.println(minRemovals);
	}
	
	@Test
	public void test3() {
		int[] arr = {4, 7, 5, 6};
		RemoveToMake2IntoMinGreaterThanMax r = new RemoveToMake2IntoMinGreaterThanMax();
		int minRemovals = r.computeMinimumRemovalsFromEnd(arr);
		System.out.println(minRemovals);
	}
	
	@Test
	public void test4() {
		int[] arr = {20, 4, 1, 3};
		RemoveToMake2IntoMinGreaterThanMax r = new RemoveToMake2IntoMinGreaterThanMax();
		int minRemovals = r.computeMinimumRemovalsFromEnd(arr);
		System.out.println(minRemovals);
	}
}
