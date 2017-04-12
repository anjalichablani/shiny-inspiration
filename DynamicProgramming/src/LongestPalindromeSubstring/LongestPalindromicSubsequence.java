package LongestPalindromicSubsequence;
/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * do non-recursive
 * 
 */
import java.util.Arrays;
import java.util.Stack;

public class LongestPalindromicSubsequence {

	public int getLPSNonRecursive(String str) {
        int temp[][] = new int[str.length()][str.length()];
        
        for(int i=0; i < str.length(); i++){
        	temp[i][i] = 1;
        }
      
        for(int len = 2; len <= str.length(); len++){
            for(int i = 0; i <= str.length()-len; i++){
                int j = i + len - 1;
                if(len == 2){
                	if (str.charAt(i) == str.charAt(j)){
                	  temp[i][j] = 2;
                	}
                } else {
                	if (str.charAt(i) == str.charAt(j)) {
                       temp[i][j] = temp[i + 1][j-1] + 2;
                	} else{
                       temp[i][j] = Math.max(temp[i + 1][j], temp[i][j - 1]);
                   }
               }
            }
        }
        
        print(str, temp);
        return temp[0][str.length()-1];
    }


	public void print(String str, int[][] temp) {
		int start = 0;
		int end = str.length() - 1;
		System.out.println("Longest common palindromic substring for input " + str + " is ");
		Stack<Character> stack = new Stack<Character>();
		
		while (start <= end) {
			if (str.charAt(start) == str.charAt(end)) {
				System.out.print(str.charAt(start));
				if (start < end)
					stack.add(str.charAt(start));
				start++;
				end--;
			} else {
				if (temp[start + 1][end] >= temp[start][end - 1])
					start++;
				else
					end--;
			}
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		
		System.out.println();
	}
	
	public void findLongestPalindromicSubSequence(String str) {
	
		if (str == null || str.length() == 0)
			return;
		
		int[][] temp = new int[str.length()][str.length()];
		for(int i = 0; i < str.length(); i++) {
			Arrays.fill(temp[i], Integer.MIN_VALUE);
		}
		
		int result = findLongestPalindromicSubSequence(str, 0, str.length()-1, temp);
		
		System.out.println("Length of longest palindrome subsequence: " + result);
		print(str, temp);
		
	}
	
	private int findLongestPalindromicSubSequence(String input, int start, int end, int[][] temp) {
		if (start > end)
			return 0;
		
		if (temp[start][end] == Integer.MIN_VALUE) {
			if (input.charAt(start) == input.charAt(end)) {
				int x = findLongestPalindromicSubSequence(input, start + 1, end - 1, temp);
				temp[start][end] = 2 + x;
			} else {
				int r1 = findLongestPalindromicSubSequence(input, start + 1, end, temp);
				int r2 = findLongestPalindromicSubSequence(input, start, end - 1, temp);
				temp[start][end] = Math.max(r1, r2);
			}
		}
		
		return temp[start][end];
	}
}
