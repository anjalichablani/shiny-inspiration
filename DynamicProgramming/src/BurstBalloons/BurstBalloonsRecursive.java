package BurstBalloons;

/**
* 
* Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented
* by array nums. You are asked to burst all the balloons. If the you burst balloon i you will
* get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst,
* the left and right then becomes adjacent.
* Find the maximum coins you can collect by bursting the balloons wisely.
*
* Time complexity O(n^3)
* Space complexity O(n^2)
*
* Reference
* https://leetcode.com/problems/burst-balloons/
*/
 
public class BurstBalloonsRecursive {

	public int BurstBalloonsRec(int[] nums){
		
		int[] temp = new int[nums.length+2];
		temp[0] = 1;
		temp[temp.length - 1] = 1;
		
		for (int i=0; i < nums.length; i++){
			temp[i+1] = nums[i];
		}
		
		return BurstBalloonsRecInner(temp);
		
	}
	
	private int BurstBalloonsRecInner(int[] nums) {
		if (nums.length == 2)
			return 0;
		
		int max = 0;
		
		for (int i = 1; i < nums.length-1; i++) {
			int val = nums[i-1] * nums[i] * nums[i+1];
			int[]newArray = formNewArray(nums, i);
			int result = BurstBalloonsRecInner(newArray);
			val = val + result;
			if (val > max) {
				 max = val;
			}
		}
		
		return max;
	}
	
	private int[] formNewArray(int[] nums, int excludeIndex) {
		int[] temp = new int[nums.length-1];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == excludeIndex){
				continue;
			}
			temp[index++] = nums[i];
		}
		
		return temp;
	}
}
