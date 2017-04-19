package LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

	public int computeLongestConsecutive(int[] input) {
		int max = 1;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < input.length; i++) {
			int key = input[i];
			if (map.containsKey(key)) {
				continue;
			}

			int left = 0, right = 0;
			if (map.containsKey(key - 1)) { // #of elements to left of me
				left = map.get(key - 1);
			}
			if (map.containsKey(key + 1)) { // #of elements to right of me
				right = map.get(key + 1);
			}
			// sum: length of the sequence n is in
			int sum = left + right + 1;
			map.put(key, sum);

			// keep track of the max length
			if (sum > max) {
				max = sum;
			}

			// extend the length to the boundary(s)
			// of the sequence
			// will do nothing if n has no neighbors
			map.put(key - left, sum); // subtract from key #of left elements to
										// get left boundary
			map.put(key + right, sum); // add to key #of right elements to get
										// right boundary
		}

		return max;
	}
}
