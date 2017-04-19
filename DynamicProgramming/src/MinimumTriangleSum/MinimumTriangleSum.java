package MinimumTriangleSum;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on
 * the row below.
 * 
 * https://leetcode.com/problems/triangle/
 */
import java.util.List;

public class MinimumTriangleSum {

	public int minimumTotal(List<List<Integer>> triangle) {
        
		int noOfList = triangle.size();
        int[] dp = new int[noOfList];

        int lastListSize = triangle.get(noOfList - 1).size();
        List<Integer> lastList = triangle.get(noOfList - 1);
        
        for (int i = 0; i < lastListSize ; i++) {
            dp[i] = lastList.get(i);
        }

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }
}
