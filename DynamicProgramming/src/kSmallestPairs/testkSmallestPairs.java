package kSmallestPairs;

import java.util.List;
import org.junit.Test;

public class testkSmallestPairs {

	@Test
	public void test() {
		int[] nums1 = {1, 7,11};
		int[] nums2 = {2,4,6};
		
		kSmallestPairs ksp = new kSmallestPairs();
		List<int[]> list = ksp.getkSmallestPairs(nums1, nums2, 3);
		
		
		for (int[] arr : list) {
		 System.out.print(String.format("[%s,%s]",arr[0], arr[1]));
		}
	}
	
	@Test
	public void test_1() {
		int[] nums1 = {2, 4, 6, 8, 12};
		int[] nums2 = {1, 7, 11};
		
		kSmallestPairs ksp = new kSmallestPairs();
		List<int[]> list = ksp.getkSmallestPairs(nums1, nums2, 5);
		
		
		for (int[] arr : list) {
		 System.out.print(String.format("[%s,%s]",arr[0], arr[1]));
		}
	}
	
	@Test
	public void test_2() {
		int[] nums1 = {1, 1, 2};
		int[] nums2 = {1, 2, 3};
		
		kSmallestPairs ksp = new kSmallestPairs();
		List<int[]> list = ksp.getkSmallestPairs(nums1, nums2, 2);
		
		
		for (int[] arr : list) {
		 System.out.print(String.format("[%s,%s]",arr[0], arr[1]));
		}
	}
	
	@Test
	public void test_3() {
		int[] nums1 = {1, 2};
		int[] nums2 = {3};
		
		kSmallestPairs ksp = new kSmallestPairs();
		List<int[]> list = ksp.getkSmallestPairs(nums1, nums2, 3);
		
		
		for (int[] arr : list) {
		 System.out.print(String.format("[%s,%s]",arr[0], arr[1]));
		}
	}
}
