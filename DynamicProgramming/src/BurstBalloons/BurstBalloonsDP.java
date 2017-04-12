package BurstBalloons;

/*
* Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented
* by array nums. You are asked to burst all the balloons. If you burst balloon i you will
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
public class BurstBalloonsDP {

	public int BurstBalloons(int[] nums) {
		int[][] temp = new int[nums.length][nums.length];
		for (int len = 1; len <= nums.length; len++) {
			for (int i = 0; i < nums.length - len; i++) {
				int j = i + len - 1;
				for (int k = i; k <= j; k++) {
					
					//leftValue/rightValue is initially 1. If there is element on
                    // left/right of k then left/right value will take that value.
					int leftValue = 1;
					int rightValue = 1;

					if (i != 0) {
						leftValue = nums[i - 1];
					}

					if (j != nums.length - 1) {
						rightValue = nums[j + 1];
					}

					int val = leftValue * nums[k] * rightValue;

					//before is initially 0. If k is i then before will
                    //stay 0 otherwise it gets value T[i][k-1]
                    //after is similarly 0 initially. if k is j then after will
                    //stay 0 other will get value T[k+1][j]
					int before = 0;
					int after = 0;
					if (k != i) {
						before = temp[i][k - 1];
					}
					if (k != j) {
						after = temp[k + 1][j];
					}

					int total = val + before + after;
					temp[i][j] = Math.max(total, temp[i][j]);
				}
			}
		}

		return temp[0][nums.length - 1];
	}
}
