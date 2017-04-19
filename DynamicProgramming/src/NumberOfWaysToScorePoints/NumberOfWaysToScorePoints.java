package NumberOfWaysToScorePoints;
/**
 * 
 * Finding the number of ways a given score could be reached for a game with 3 different ways of scoring (e.g. 3, 5 and 10 points).
 * test case
 * what happens if total can't be formed with given values
 * what if numbers are 0 or negative
 
 */
 
import java.util.Stack;

public class NumberOfWaysToScorePoints {

	public int computeNumberOfWaysToScorePoints(int[] scores, int total) {
		
		int[] temp = new int[total+1];
		//score of 0 can be achieved only 1 way
		temp[0] = 1;
		for (int i = 0; i < scores.length; i++) {
			for(int j = 0; j <= total; j++) {
				if (j < scores[i]){
					continue;
				}
				
				int residualValue = j - scores[i];
				temp[j] = temp[j] + temp[residualValue];
			}
			
		}
		
		return temp[total];
		
	}
	
	public void printScoreCombination(int total, int[]scores) {
		Stack<Integer> result = new Stack<Integer>();
		
		printScoreCombinationInner(total, scores, 0, result);
	}
	
	private void printScoreCombinationInner(int total, int[] scores, int start,
			Stack<Integer> result) {

		if (total == 0) {
			for (Integer r : result) {
				System.out.println(r + " ");
			}
			System.out.println("\n");
		}

		for (int i = start; i < scores.length; i++) {
			if (total > scores[i]) {
				result.push(scores[i]);
				int newTotal = total - scores[i];
				printScoreCombinationInner(newTotal, scores, i, result);
				result.pop();
			}
		}
	}
}
