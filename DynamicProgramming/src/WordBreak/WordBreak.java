package WordBreak;

//Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated 
//sequence of dictionary words.

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class WordBreak {

	Map<String, Boolean> dictionary;
	Queue<String> q = new ArrayDeque<>();
	
	public WordBreak() {
		dictionary = new HashMap<String, Boolean>();
	    dictionary.put("mobile", true);
	    dictionary.put("samsung",true);
	    dictionary.put("sam",true);
	    dictionary.put("sung",true);
	    dictionary.put("man",true);
	    dictionary.put("mango",true);
	    dictionary.put("icecream",true);
	    dictionary.put("and",true);
	    dictionary.put("go",true);
	    dictionary.put("i",true);
	    dictionary.put("like",true);
	    dictionary.put("ice",true);
	    dictionary.put("cream",true);
	}
	
	/* A utility function to check whether a word is present in dictionary or not.*/	 
	boolean dictionaryContains(String word) {	    
	    return dictionary.containsKey(word);
	}
	
	boolean wordBreak(String str) {
	    int size = str.length();
	    
	    if (size == 0)   
	    	return true;
	 
	    // Create the DP table to store results of subproblems. The value wb[i]
	    // will be true if str[0..i] can be segmented into dictionary words,
	    // otherwise false.
	    boolean[] wb = new boolean[size+1];
	 
	    String word = null;
	    boolean isContain = false;
	    for (int i=1; i<=size; i++)
	    {
	        // if wb[i] is false, then check if current prefix can make it true.
	        // Current prefix is "str.substr(0, i)"
	    	word = str.substring(0, i);
	    	isContain = dictionaryContains(word);
	        if (isContain && wb[i] == false){
	        	wb[i] = true;
	        	q.add(word);
	        }
	          
	 
	        // wb[i] is true, then check for all substrings starting from
	        // (i+1)th character and store their results.
	        if (wb[i] == true)
	        {
	            // If we reached the last prefix
	            if (i == size)
	                return true;
	 
	            for (int j = i+1; j <= size; j++)
	            {
	                // Update wb[j] if it is false and can be updated
	                // Note the parameter passed to dictionaryContains() is
	                // substring starting from index 'i' and length 'j'
	            	word = str.substring(i, j);
	            	isContain = dictionaryContains(word);
	                if (isContain && wb[j] == false){
	                    wb[j] = true;
	                    q.add(word);
	                }
	 
	                // If we reached the last character
	                if (j == size && wb[j] == true)
	                    return true;
	            }
	        }
	    }
	 
	    /* Uncomment these lines to print DP table "wb[]"*/
	     //for (int i = 1; i <= size; i++) {
	       // System.out.println(wb[i]); 
	     //}
	 
	    // If we have tried all prefixes and none of them worked
	    return false;
	}
	 
	private void printAllSegmentedWords() {
		System.out.println("following words can be formed: ");
		
		while(!q.isEmpty()) {
			System.out.println(q.remove());
		}
	}
	
	public static void main(String [] args) {
		WordBreak rec = new WordBreak();
		
		String str1 = "ilikelikeimangoiii";
		String str2 = "ilikesamsung";		
		String str3 = "iiiiiiii";
		String str4 = "samsungandmango";
		String str5 = "samsungandmangok";
		String str6 = "keepgoinguntiltheend";
		String str7 = "ilikeicecreamandmango";
		boolean output = rec.wordBreak(str7);
		rec.printAllSegmentedWords();
		
		System.out.println(str7 + " can be segmented into dictionary words : " + output);
	}
}
