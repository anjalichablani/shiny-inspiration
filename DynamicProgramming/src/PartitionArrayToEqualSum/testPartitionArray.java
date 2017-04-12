package PartitionArrayToEqualSum;

import org.junit.Test;

public class testPartitionArray {

	@Test
	public void test() {
	
		int[] input = {1, 5, 11, 5};
		PartitionArrayToEqualSum partition = new PartitionArrayToEqualSum();
		boolean result = partition.computePartition(input);
		System.out.println("Array can be partitioned in equal sum - "  + result);
	}
	
	@Test
	public void test_1() {
	
		int[] input = {1, 5, 3};
		PartitionArrayToEqualSum partition = new PartitionArrayToEqualSum();
		boolean result = partition.computePartition(input);
		System.out.println("Array can be partitioned in equal sum - "  + result);
	}
	
	@Test
	public void test_2() {
	
		int[] input = {3, 1, 1, 2, 2, 1};
		PartitionArrayToEqualSum partition = new PartitionArrayToEqualSum();
		boolean result = partition.computePartition(input);
		System.out.println("Array can be partitioned in equal sum - "  + result);
	}
}
