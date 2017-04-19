package DecodeWays;
/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * 26-> Z
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * https://leetcode.com/problems/decode-ways/
 */

import java.util.HashMap;
import java.util.Map;

public class DecodeWaysRec {

	public int getNumOfDecoding(String str) {
		if (str.length() == 0) {
            return 0;
        }
		
		Map<Integer, Integer> dp = new HashMap<>();
		int numOfDecoding = getNumOfDecodingInner(str, 0, dp);
		
		return numOfDecoding;
		
	}
	
	private int getNumOfDecodingInner(String str, int start, Map<Integer, Integer> dp ) {
	
		if (str.length() == start) {
			return 1;
		}
		if (dp.containsKey(start)) {
			return dp.get(start);
		}
		
		String s1 = str.substring(start, start+1);
		
		if (s1.equals("0")) {
            dp.put(start, 0);
            return 0;
        }
		
		int c1 = 0;
		c1 = getNumOfDecodingInner(str, start+1, dp);
		
		int c2 = 0;
		if (start < str.length() -1) {
			String s2 = str.substring(start, start+2);
			int resultStr = Integer.valueOf(s2);
			if(resultStr >= 10 && resultStr <= 26) {
				c2 = getNumOfDecodingInner(str, start+2, dp);
			}
		}
		
		dp.put(start, c1+c2);
		
		return c1 + c2;
	}
	
	
	
}
