package TwoStringInterleavingToFormThird;

/**
 * http://www.geeksforgeeks.org/check-whether-a-given-string-is-an-interleaving-of-two-other-given-strings-set-2/
 * https://leetcode.com/problems/interleaving-string/#/description
 *
 */
public class TwoStringInterleavingToFormThird {

	
	public boolean isInterleaved(String str1, String str2, String str3){
        boolean T[][] = new boolean[str1.length() +1][str2.length() +1];
        
        if(str1.length() + str2.length() != str3.length()){
            return false;
        }
        
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int k = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str3.charAt(k) == str2.charAt(j-1)){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1.charAt(i-1) == str3.charAt(k)){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    T[i][j] = (str1.charAt(i-1) == str3.charAt(k) ? T[i-1][j] : false) || 
                    		(str2.charAt(j-1) == str3.charAt(k) ? T[i][j-1] : false);
                }
            }
        }
        return T[str1.length()][str2.length()];
    }
	
	 public boolean isInterleavedRecursive(String str1, String str2, String str3,int pos1, int pos2, int pos3){
	        if(pos1 == str1.length() && pos2 == str2.length() && pos3 == str3.length()){
	            return true;
	        }
	        
	        if(pos3 == str3.length()){
	            return false;
	        }
	        boolean t1 = false;
	        boolean t2 = false;
	        if (pos1 < str1.length()) {
	        	if(str1.charAt(pos1) == str3.charAt(pos3)) {
	        		t1 = isInterleavedRecursive(str1, str2, str3, pos1+1, pos2, pos3+1);
	        	}
	        }
	        
	        if (pos2 < str2.length()) {
	        	if(str2.charAt(pos2) == str3.charAt(pos3)) {
	        		t2 = isInterleavedRecursive(str1, str2, str3, pos1, pos2+1, pos3+1);
	        	}
	        }
	        
	        return t1 || t2;
	      //  return (pos1 < str1.length() && str1.charAt(pos1) == str3.charAt(pos3) && isInterleavedRecursive(str1, str2, str3, pos1+1, pos2, pos3+1))
	        //        || (pos2 < str2.length() && str2.charAt(pos2) == str3.charAt(pos3) && isInterleavedRecursive(str1, str2, str3, pos1, pos2+1, pos3+1));
	        
	    }

}
