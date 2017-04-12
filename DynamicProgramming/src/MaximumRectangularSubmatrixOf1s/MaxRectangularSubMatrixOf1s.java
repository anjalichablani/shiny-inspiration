package MaximumRectangularSubmatrixOf1s;

import java.util.Stack;
/**
 * Given a 2D matrix of 0s and 1s. Find largest rectangle of all 1s
 * in this matrix.
 * 
 * http://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
 * The idea is to update each column of a given row with corresponding column of previous row 
 * and find largest histogram area for for that row.
 * 
 * 
 * 
 * Maintain a temp array of same size as number of columns. 
 * Copy first row to this temp array and find largest rectangular area
 * for histogram. Then keep adding elements of next row to this temp
 * array if they are not zero. If they are zero then put zero there.
 * Every time calculate max area in histogram.
 *
 *Time complexity - O(rows*cols)
 *Space complexity - O(cols)
 */
public class MaxRectangularSubMatrixOf1s {

	public int computeMaxRectangle(int[][] matrix) {
		int[] input = new int[matrix[0].length];
		int maxArea = 0;
		int area = 0;
		for (int i = 0; i< matrix.length; i++) {
			for (int j = 0; j< matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					input[j] = 0;
				} else {
					input[j] = input[j] + matrix[i][j];
				}
			}
			
			//compute max area
			area = computeMaxAreaOfHistogram(input);
			if (area > maxArea) {
				maxArea = area;
			}
		}
		
		return maxArea;
		
	}
	
	
	private int computeMaxAreaOfHistogram (int[] input) {
		
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		int area = 0;
		int maxArea = 0;
		while (i < input.length) {
			if (stack.isEmpty()) {
				stack.push(i);
				i++;
				continue;
			}
			
			if (input[i] > input[stack.peek()]) {
				stack.push(i);
				i++; continue;
			}
			
			if (input[i]<= input[stack.peek()]) {		
				int top = stack.pop();
				int height  = input[top];
				
				if (stack.isEmpty()) {
					area = height * i;
				} else {
					area = height*(i-stack.peek()-1);
				}
				
				if (area > maxArea){
					maxArea = area;
				}
			}
		}
		
		while (!stack.isEmpty()) {
			int top = stack.pop();
			int height = input[top];
			if (stack.isEmpty()){
				area = height * i;
			} else {
				area = height *(i- stack.peek()-1);
			}
			
			if (area > maxArea){
				maxArea = area;
			}
		}
		
		return maxArea;
	}
}
