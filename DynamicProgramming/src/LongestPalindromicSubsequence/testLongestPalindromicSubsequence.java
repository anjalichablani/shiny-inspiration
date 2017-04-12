package LongestPalindromicSubsequence;

import org.junit.Test;

public class testLongestPalindromicSubsequence {

	@Test
	public void testPalindromicSubsequence_2(){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "agbxdndba";
        
        int result = lps.getLPSNonRecursive(str);
        System.out.println(result);
        
        //lps.findLongestPalindromicSubSequence(str);
	}
	
	
	@Test
	public void testPalindromicSubsequence(){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "agbdba";
        
        int result = lps.getLPSNonRecursive(str);
        System.out.println(result);
        
       // lps.findLongestPalindromicSubSequence(str);
	}
	
	
	@Test
	public void testPalindromicSubsequence_1(){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "geeksforgeeks";
        
        int result = lps.getLPSNonRecursive(str);
        System.out.println(result);
        
       // lps.findLongestPalindromicSubSequence(str);
	}
	
	
	@Test
	public void testPalindromicSubsequenceRecursive(){
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        String str = "agbdba";
 
         
        lps.findLongestPalindromicSubSequence(str);
	}
}
