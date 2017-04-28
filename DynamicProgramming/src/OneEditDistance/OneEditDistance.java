package OneEditDistance;
/**
 * http://www.geeksforgeeks.org/check-if-two-given-strings-are-at-edit-distance-one/
 * 
 * Time complexity: O(n)
   Auxiliary Space: O(1)
   
 * An edit between two strings is one of the following changes.

    Add a character
    Delete a character
    Change a character

Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit. 
Expected time complexity is O(m+n) where m and n are lengths of two strings.

Examples:

Input:  s1 = "geeks", s2 = "geek"
Output: yes
Number of edits is 1

Input:  s1 = "geeks", s2 = "geeks"
Output: no
Number of edits is 0

Input:  s1 = "geaks", s2 = "geeks"
Output: yes
Number of edits is 1

Input:  s1 = "peaks", s2 = "geeks"
Output: no
Number of edits is 2

 *
 */
public class OneEditDistance {

	public boolean isEditDistanceOne(String str1, String str2) {

	    // If difference between lengths is more than
	    // 1, then strings can't be at one distance
	    if (Math.abs(str1.length() - str2.length()) > 1)
	        return false;
	 
	    int i = 0;
	    int j = 0;
	    int count = 0;
	    while (i < str1.length() && j < str2.length()) {
	    	if (str1.charAt(i) != str2.charAt(j)) {
	    		if (count == 1){
	    			return false;
	    		}
	    	    // If length of one string is more, then only possible edit is to remove a character
	    		if (str1.length() > str2.length()) {
	    			i++;
	    		} else if (str2.length() > str1.length()){
	    			j++;
	    		} else { //If lengths of both strings is same, replace a character
	    			i++; j++;
	    		}
	    		count++;
	    	} else {
	    		i++; j++;
	    	}	
	    }
	    
	    if(i < str1.length() || j< str2.length()) {
	    	if (count ==0) {
	    		count++;
	    	}
	    }
	    
	    return count == 1; //if count == 1 return true else false
	}
}
