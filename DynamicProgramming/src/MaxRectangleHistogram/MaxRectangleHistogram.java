package MaxRectangleHistogram;

import java.util.Stack;

public class MaxRectangleHistogram {

	public int maxRectangleHistogram(int[] input) {
		if (input == null || input.length == 0) {
			return 0;
		}

		// Stack is used to store the indices
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int area = 0;
		int i= 0;
		
		while (i < input.length) {
			if (stack.isEmpty()) {
				stack.push(i);
				i++;
				continue;
			} 
			
			if (input[i] > input[stack.peek()]) {
				stack.push(i);
				i++;
				continue;
			}
			
			if (input[i] <= input[stack.peek()])  {
				int top = stack.pop();
                int height = input[top];
				if (stack.isEmpty()) {
					area = height * i;
				} else {
					area = height * (i - stack.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			 int height = input[top];
			// if stack is empty means everything till i has to be
			// greater or equal to input[top] so get area by
			// input[top] * i;
			if (stack.isEmpty()) {
				area = height * i;
			}
			// if stack is not empty then everything from i-1 to
			// input.peek() + 1
			// has to be greater or equal to input[top]
			// so area = input[top]*(i - stack.peek() - 1);
			else {
				area = height * (i - stack.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;
	}
}
