package CountWaysToReachNthStair;

//There are n stairs, a person standing at the bottom wants to reach the top. 
//The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, the person can reach the top.
/* 
Input: n = 1
Output: 1
There is only one way to climb 1 stair

Input: n = 2
Output: 2
There are two ways: (1, 1) and (2)

Input: n = 4
Output: 5
(1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)

http://www.geeksforgeeks.org/count-ways-reach-nth-stair 
*/
public class CountWaysToReachNthStair {

	public int countWays(int n) {
		int[] fibCache = new int[n+1];
		int count = countWaysUtil(fibCache, n);
		return count;
	}
	
	private int countWaysUtil(int[] fibCache, int n) {		
		if (n <= 1)
			fibCache[n] = 1;
		
		if (fibCache[n] == 0) {
			fibCache[n] = countWaysUtil(fibCache, n-1) + countWaysUtil(fibCache, n-2);
		}
		
		return fibCache[n];
	}
}
