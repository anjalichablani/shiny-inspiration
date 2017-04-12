package SubsetSum;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 * 
 * https://www.youtube.com/watch?v=s6FhG--P7z0&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=4
*/
public class SubsetSum {

	
	public boolean computeSubsetSum(int[] input, int total) {
		
		boolean[][] temp = new boolean[input.length+1][total+1];
		
		for (int i = 0 ; i<= input.length; i++) {
			temp[i][0] = true;
		}
		
		for(int i= 1; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
			
				if (j - input[i-1] >= 0) {
					int residualValue = j - input[i-1];
					temp[i][j] = temp[i-1][j] || temp[i-1][residualValue];
				} else {
					temp[i][j] = temp[i-1][j];
				}
			}
		}
		
		boolean result = temp[input.length][total];
		if (result) {
			List<Integer>  list = getArrayNumbersThatSumUpToTotal(temp, total, input);
			System.out.println(list.toString());
		}
		return result;
	}
	
	private List<Integer> getArrayNumbersThatSumUpToTotal(boolean[][] temp, int total, int[] input) {	
		int i = input.length;
		int j = total;
		List<Integer> list = new ArrayList<>();
		
		while (i > 0 ) {	
			if (temp[i][j] != temp[i-1][j]) {
			   list.add(input[i-1]);
			   total = total - input[i-1];
			   i = i -1;
			   j = total;
			} else {
				i = i -1;
			}
		}
		return list;
	}
}
