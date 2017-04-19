package PalindromePartition;

/***
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
https://leetcode.com/problems/palindrome-partitioning/#/description
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPossiblePalindrome {

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<List<String>>();

		if (s == null || s.length() == 0)
			return result;

		Boolean[][] cache = new Boolean[s.length()][s.length()];

		partitionInner(s, 0, result, cache);

		return result;
	}
    
	private Boolean isPalindrome(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i) != s.charAt(j))
				return false;

			i++;
			j--;
		}

		return true;
	}

	private void partitionInner(String s, int start, List<List<String>> result,
			Boolean[][] cache) {

		for (int i = start; i < s.length(); i++) {
			if (cache[start][i] == null) {
				cache[start][i] = isPalindrome(s, start, i);
			}

			if (cache[start][i]) {
				String current = s.substring(start, i + 1);

				if (i == s.length() - 1) {
					LinkedList<String> list = new LinkedList<>();
					list.add(current);
					result.add(list);
				} else {
					int before = result.size();
					partitionInner(s, i + 1, result, cache);
					int after = result.size();

					for (int j = before; j < after; j++) {
						LinkedList<String> list = (LinkedList<String>) result
								.get(j);
						list.addFirst(current);
					}
				}
			}
		}
	}
}

