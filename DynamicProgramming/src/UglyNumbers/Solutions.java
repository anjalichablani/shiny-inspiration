package UglyNumbers;
/**
 * http://www.geeksforgeeks.org/ugly-numbers/
 * 
 * https://leetcode.com/problems/ugly-number-ii/#/description
 *
 * 
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690. 
 */
public class Solutions {
	
	//dp efficient solution
	public int nthUglyNumberDP(int n){
		int arr[] = new int[n];
		int count = 1;
		arr[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		while (count < n) {
			int minNumber = minimum(arr[i2] * 2, arr[i3] * 3, arr[i5] * 5);
			if (minNumber == arr[i2] * 2) {
				i2++;
			}
			if (minNumber == arr[i3] * 3) {
				i3++;
			}
			if (minNumber == arr[i5] * 5) {
				i5++;
			}
			arr[count++] = minNumber;
		}

		return arr[n - 1];
	}
	
	private int minimum (int a, int b , int c) {
		int r = Math.min(a, b);
		return Math.min(r, c);
	}
	    
  //brute force	
    public int nthUglyNumber(int n) {
        int count = 1;
        int i = 1;
        while (count< n){
            if (isUgly(i)) {
                System.out.println("Ugly Number: " + i + " count :" + count);
                count++;
            }
            i++;
        }
        
        return i--;
        
    }
    
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