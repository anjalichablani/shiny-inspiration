package PartitionArrayToEqualSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*Given an array is it possible to split it up into 2 equal
*sum partitions. Partition need not be equal sized. Just equal sum.
*
*http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
*
*Following are the two main steps to solve this problem:
1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.
*/

public class PartitionArrayToEqualSum {

	public boolean computePartition(int[] input) {
		
		int sum = computeArraySum(input);
		if (sum %2 != 0) {
			return false;
		}
		
		int total = sum/2;
		
		
		boolean[][] temp = new boolean[input.length+1][total+1];
		List<Integer> list = computeSubsetSum(input,temp, total);
		
		List<Integer> inputList = Arrays.stream(input).boxed().collect(Collectors.toList());
		for (int k : list) {
			inputList.remove((Integer)k);
		}
		
		System.out.println(list.toString());	
		System.out.println(inputList.toString());
		
		return true;
	}
	
	private List<Integer> computeSubsetSum(int[] input, boolean[][] temp, int total) {
		
		for (int i = 0;i <= input.length; i++) {
		   	temp[i][0] = true;
		}
		
		int residualValue;
		for (int i=1; i<=input.length; i++) {
			for(int j=1; j<=total; j++) {
				if (j - input[i-1] >=0) {
					residualValue = j - input[i-1];
					temp[i][j] = temp[i-1][residualValue];
				} else {
					temp[i][j] = temp[i-1][j];
				}
			}
		}
		
		return getSubset(input, temp, total);	
	}
	
	private  List<Integer> getSubset(int[] input, boolean[][] temp, int total) {
		
		int i = input.length;
		int j = total;
		List<Integer> list = new ArrayList<>();
		while (i > 0) {
			if (temp[i][j] != temp[i-1][j]) {
				list.add(input[i-1]);
				total = total - input[i-1];
				i = i-1;
				j = total;
			} else {
				i = i -1;
			}
		}
		
		return list;
	}
	
	private int computeArraySum(int[] input) {
		int sum = 0;
		for(int i =0; i< input.length; i++) {
			sum += input[i];
		}
		
		return sum;
	}
}
