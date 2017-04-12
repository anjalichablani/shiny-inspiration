package PrintMaximumAs;
/**
 * 
 * http://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
 *Below is the problem statement.

Imagine you have a special keyboard with the following keys: 
Key 1:  Prints 'A' on screen
Key 2: (Ctrl-A): Select screen
Key 3: (Ctrl-C): Copy selection to buffer
Key 4: (Ctrl-V): Print buffer on screen appending it
                 after what has already been printed. 

If you can only press the keyboard for N times (with the above four
keys), write a program to produce maximum numbers of A's. That is to
say, the input parameter is N (No. of keys that you can press), the 
output is M (No. of As that you can produce)

Example:

Input:  N = 3
Output: 3
We can at most get 3 A's on screen by pressing 
following key sequence.
A, A, A

Input:  N = 7
Output: 9
We can at most get 9 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V

Input:  N = 11
Output: 27
We can at most get 27 A's on screen by pressing 
following key sequence.
A, A, A, Ctrl A, Ctrl C, Ctrl V, Ctrl V, Ctrl A, 
Ctrl C, Ctrl V, Ctrl V

For N < 7, the output is N itself
*/
public class MaxNumberOfAs {

	private int findMaxAs(int n) {

		if (n < 7) {
			return n;
		}

		int[] temp = new int[n + 1];
		for (int i = 0; i < 7; i++) {
			temp[i] = i;
		}
		
		for (int i = 7; i <= n; i++) {
			
			int j = i-3; //at least 1 combination of (ctrl-A, ctrl-C and ctrl-V) keys.. so minus 3 keys up front from n. Remaining keys is # of times pressing A key.
			int multiplier = 2; //since we are planning to use at least once ctrl-v operation we will double printed A's. So start with 2.
			                    //each time a A is reduced we replace it with ctrl-v.. with each ctrl-v being added we double the printed A's.
			                    //multiplier # is nothing but # of times printed A's will get pasted
			while( j > 0) {
				temp[i] = Math.max(temp[i], temp[j] * multiplier);
				multiplier += 1;
				j--;
			}
		}
		return temp[n];
	}
	

	public void computeMaxNumberOfAs(int n) {
		
		System.out.println("Max number of As possible with " + n + " keystrokes: "
				+ findMaxAs(n));

	}
}