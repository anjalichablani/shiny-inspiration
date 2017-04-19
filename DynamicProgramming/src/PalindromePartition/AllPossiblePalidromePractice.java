package PalindromePartition;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPossiblePalidromePractice {

	public List<List<String>> getAllPossiblePalindrome(String str) {

		if (str == null || str.length() == 0) {
			return null;
		}

		List<List<String>> result = new ArrayList<List<String>>();

		if (str.length() == 1) {
			List<String> l = new ArrayList<String>();
			l.add(String.valueOf(str.charAt(0)));
			result.add(l);
			return result;
		}

		Boolean[][] temp = new Boolean[str.length()][str.length()];

		partition(str, 0, result, temp);

		return result;
	}

	private void partition(String str, int start, List<List<String>> result, Boolean[][] temp) {

		if (start >= str.length())
			return;

		boolean isPalindrome = false;
		for (int i = start; i < str.length(); i++) {
			if (temp[start][i] == null) {
				isPalindrome = checkPalindrome(str, start, i);
				temp[start][i] = isPalindrome;
			} else {
				isPalindrome = temp[start][i];
			}

			if (isPalindrome) {
				String current = str.substring(start, i + 1);
				int listSizeBefore = result.size();
				partition(str, i + 1, result, temp);
				int listSizeAfter = result.size();

				if (i == str.length() - 1) {
					LinkedList<String> palindromeList = new LinkedList<String>();
					palindromeList.add(current);
					result.add(palindromeList);
					return;
				}

				for (int k = listSizeBefore; k < listSizeAfter; k++) {
					LinkedList<String> ll = (LinkedList<String>) result.get(k);
					ll.addFirst(current);
				}

			}

		}

	}
	
	private boolean checkPalindrome(String str, int i,  int j) {
		while(i<j) {
		  if (str.charAt(i) != str.charAt(j)) {
			  return false;
		  }
		  i++;
		  j--;
		}
		
		return true;
	}
}
