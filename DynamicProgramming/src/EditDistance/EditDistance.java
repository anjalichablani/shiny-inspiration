package EditDistance;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * @author anjali.chablani
 *
 */
public class EditDistance {

	//recursive is complex..better to understand dynamic here
    public int recEditDistance(String str1, String str2, int m,int n){
        
    	 // If first string is empty, the only option is to
        // insert all characters of second string into first
    	if (m == 0) return n;
        
        // If second string is empty, the only option is to
        // remove all characters of first string
        if (n == 0) return m;
        
        
        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return recEditDistance(str1, str2, m-1, n-1);
        
        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
     
        		
		int insert = recEditDistance(str1, str2, m, n - 1); // Insert
		int remove = recEditDistance(str1, str2, m - 1, n); // Remove
		int replace = recEditDistance(str1, str2, m - 1, n - 1); // Replace

		int minOp = min(insert, remove, replace);
		return 1 + minOp;
                       
    }
	

    
	//dynamic
	public int computeEditDistance(String s1, String s2) {
		int[][] temp = new int[s1.length() + 1][s2.length() + 1];

		for (int j = 0; j <= s2.length(); j++) {
			temp[0][j] = j;
		}
		for (int i = 0; i <= s1.length(); i++) {
			temp[i][0] = i;
		}

		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					temp[i][j] = temp[i - 1][j - 1];
				} else {
					temp[i][j] = 1 +
							min(temp[i][j - 1],  //insert
								temp[i - 1][j - 1], //replace
								temp[i - 1][j]);  //remove
				}
			}
		}

		printEdits(temp, s1, s2);
		return temp[s1.length()][s2.length()];
	}
	
	private int min(int a, int b, int c) {
		int k = Math.min(a, b);
		return Math.min(k, c);
	}
	
	public void printEdits(int[][] temp, String s1, String s2) {
		int i = s1.length();
		int j = s2.length();
		
		while(true) {
           if (i == 0 || j == 0) {
                break;
           }
		
           if (s1.charAt(i-1) == s2.charAt(j-1)) {
        	   i = i -1;
        	   j  = j-1;
           } else if (temp[i][j] == temp[i-1][j-1] + 1) {
        	   System.out.println("Replace " + s2.charAt(j-1) + " in string2 with " + s1.charAt(i-1) + " in string1");
               i = i-1;
               j = j-1;
           } else if (temp[i][j] == temp[i-1][j]+1) {
        	   System.out.println("Delete in string1 " + s1.charAt(i-1));
               i = i-1;
           } else if (temp[i][j] == temp[i][j-1] + 1) {
        	   System.out.println("Delete in string2 " + s2.charAt(j-1));
               j = j -1;
           } else {
        	   throw new IllegalArgumentException("Something wrong with given data");
           }
		}
	}
}
