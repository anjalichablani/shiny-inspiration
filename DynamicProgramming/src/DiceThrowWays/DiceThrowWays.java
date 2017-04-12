package DiceThrowWays;
/**
 * Given n dice each with f faces, numbered from 1 to f, find the number of ways to get sum X. 
 * X is the summation of values on each face when all the dice are thrown.
 *
 *http://www.geeksforgeeks.org/dice-throw-problem/
 */
public class DiceThrowWays {

	public int numberOfWays(int dice, int f, int total) {

		//n - # of dices, f - # possible on each dice, sum - is the summation of values on each face when all the dice are thrown.
		
		int temp[][] = new int[dice + 1][total + 1];
		temp[0][0] = 1;
	
		for (int i = 1; i <= dice; i++) { //# of dices
			int valPossible = i * f; //f is values possible on each dice (ex: f is 4 then 1,2,3,4)
			for (int j = 1; j <= valPossible && j <= total; j++) {
				if (i == j) { //where # of dice and sum (j) to obtain is same then at least we know 1 way is possible.
					temp[i][j] = 1;
					continue;
				}
				if (j < i) { //suppose sum (j) is less than # of dice available then it is not possible so continue. 
					         //example: i cannot get sum 1 with 2 dice coming into play..with 1 - 1 on each i will get min 2.
					continue;
				}
				
				//if throwing current dice gives k value then residual (j-k) value should be obtainable from 
				//from the remaining dices. Hence we get that from [i-1] [j-k].
				//On current dice i can roll from 1 to f ..*here 1, 2, 3, 4 since f =4
				int noOfWays = 0;
				for (int k = 1; k <= f; k++) {
					if (k <= j) { //what i get rolling current dice should be <= sum j 
						int residualValue = j -k;
						noOfWays += temp[i - 1][residualValue]; //current # of ways possible + ways possible for residual value.
					}
				}
				temp[i][j] = noOfWays;
			}
		}
		
		return temp[dice][total];
	}
}
