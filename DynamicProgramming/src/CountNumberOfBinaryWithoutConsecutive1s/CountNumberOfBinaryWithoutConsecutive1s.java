package CountNumberOfBinaryWithoutConsecutive1s;

/**
 * 
Count number of binary strings without consecutive 1’s
Given a positive integer N, count all possible distinct binary strings of length N such that there are no consecutive 1’s.

Examples:

Input:  N = 2
Output: 3
// The 3 strings are 00, 01, 10
Although possible combinations are 00, 01, 10, 11
1 of them have consecutive 1 so discard

Input: N = 3
Output: 5
// The 5 strings are 000, 001, 010, 100, 101
Although possible combinations are 000, 001, 010, 100, 011, 101, 110, 111
3 of them have consecutive 1 so discard

http://www.geeksforgeeks.org/count-number-binary-strings-without-consecutive-1s/
*/

public class CountNumberOfBinaryWithoutConsecutive1s {

	public int count(int n){
        int a[] = new int[n];
        int b[] = new int[n];
        
        a[0] = 1;
        b[0] = 1;
        
        for(int i=1; i < n; i++){
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        
        return a[n-1] + b[n-1];
    }
    
    public int countSimple(int n){
        int a = 1;
        int b = 1;
        
        for(int i=1; i < n; i++){
            int tmp = a;
        	a = a + b;
            b = tmp;
        }
        
        return a + b;
    }

}
