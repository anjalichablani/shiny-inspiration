package LongestPalindromeSubstring;

public class LongestPalindromeSubstringDP {

	public int computeLongestPalindromeDynamic(String str) {
		
        boolean temp[][] = new boolean[str.length()][str.length()];
        
        for(int i=0; i < temp.length; i++){
            temp[i][i] = true;
        }
        
        int max = 1;
        int[] maxIndex = new int[2];
        
        for(int len = 2; len <= str.length(); len++){
            int longest = 0;
            for(int i=0; i <= str.length()-len; i++){
                int j = i + len-1;
                longest = 0;
                if(len == 2){
                    if(str.charAt(i) == str.charAt(j)){
                        temp[i][j] = true;
                        longest = 2;
                    }
                }else{
                    if(str.charAt(i) ==str.charAt(j) && temp[i+1][j-1]){
                        temp[i][j] = true;
                        longest = j -i + 1;
                    }
                }
                
                if(longest > max){
                    max = longest;
                    maxIndex[0] = i;
                    maxIndex[1] = j;
                }
            }
        }
        
        printLongestPalindrome(maxIndex, str);
        return max;
    }
	
	private void printLongestPalindrome(int[] maxIndex, String str) {
		
		System.out.print("\nLongest Palindromic String: ");
		for (int i = maxIndex[0]; i <= maxIndex[1]; i++) {
			System.out.print(str.charAt(i));
		}
		System.out.print("\n");
	}
}
