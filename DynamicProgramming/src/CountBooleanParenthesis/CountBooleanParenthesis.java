package CountBooleanParenthesis;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-37-boolean-parenthesization-problem/
 * 
 * http://www.codemiles.com/java/bitwise-operators-in-java-t3480.html
 * 
 * Boolean Parenthesization Problem

Given a boolean expression with following symbols.

Symbols
    'T' ---> true 
    'F' ---> false 

And following operators filled between symbols

Operators
    &   ---> boolean AND
    |   ---> boolean OR
    ^   ---> boolean XOR 

Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.

Let the input be in form of two arrays one contains the symbols (T and F) in order and other 
contains operators (&, | and ^}

Examples: 
Input: symbol[]    = {T, F, T}
       operator[]  = {^, &}
Output: 2

The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
       operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )". 

Input: symbol[]    = {T, T, F, T}
       operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T) 
and (T|((T&F)^T)). 

 *
 */
public class CountBooleanParenthesis {

	public int computeBooleanParenthesis(char[] symbols, char[] operator){
		
		if (symbols == null|| symbols.length == 0 || operator == null|| operator.length==0){
			return 0;
		}
		
		int n = symbols.length;
		int[][] T = new int[n][n];
		int[][] F = new int[n][n];
		
		for (int i=0; i < symbols.length; i++){
			if (symbols[i] == 'T') {
				T[i][i] = 1;
			} 
			
			if (symbols[i] == 'F') {
				F[i][i] = 1;
			}
		}
		
		
		for (int len = 2; len <= symbols.length; len++){
			for (int i = 0; i <= symbols.length-len; i++) {
				int j = i+len-1;
				 
				T[i][j] = F[i][j] = 0;
				for (int k =i; k < j; k++) {
					if (operator[k] == '^') {
						T[i][j] += F[i][k]*T[k+1][j] + T[i][k]*F[k+1][j];
						F[i][j] += T[i][k]*T[k+1][j] + F[i][k]*F[k+1][j]; 
						
					}else if (operator[k] == '&') {
						T[i][j] += T[i][k]*T[k+1][j];
						F[i][j] += F[i][k]*F[k+1][j] + T[i][k]*F[k+1][j] + F[i][k]*T[k+1][j];
						
					}else if (operator[k] == '|') {
						T[i][j] += T[i][k]*T[k+1][j] + F[i][k]*T[k+1][j] + T[i][k]*F[k+1][j];
						F[i][j] += F[i][k] * F[k+1][j];
					}
				}
			}
		}
		return T[0][n-1];
	}
}
