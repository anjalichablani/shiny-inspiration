package UglyNumbers;
/**
 *  
Write a program to check whether a given number is an ugly number.
Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.

Note that 1 is typically treated as an ugly number. 

https://leetcode.com/problems/ugly-number/#/description
 *
 */
public class UglyNumber {
    public boolean isUgly(int num) {
    	if (num <= 0) {
    		return false;
    	}
        num = divideNumber (num, 2);
        num = divideNumber (num, 3);
        num = divideNumber(num, 5);
        
        return num == 1? true: false;
        
    }
    
    private int divideNumber (int number, int divisor) {
        while (number%divisor == 0) {
            number = number/divisor;
        }
        return number;
    }
}