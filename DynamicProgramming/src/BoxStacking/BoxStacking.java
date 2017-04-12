package BoxStacking;
/*
* Given different dimensions and unlimited supply of boxes for each dimension, stack boxes
* on top of each other such that it has maximum height but with caveat that length and width
* of box on top should be strictly less than length and width of box under it. 
* You can rotate boxes as you like.
* 
* 1) Create all rotations of boxes such that length is always greater or equal to width
* 2) Sort boxes by base area in decreasing order (length * width). 
* This is because box with more area will never ever go on top of box with less area.
* 3) Take temp[] and result[] array of same size as total boxes after all rotations are done
* 4) Apply longest increasing subsequence type of algorithm to get max height.
* 
* If n number of dimensions are given total boxes after rotation will be 3n.
* So space complexity is O(n)
* Time complexity - O(nlogn) to sort boxes. O(n^2) to apply DP on it. So essentially it is O(n^2)
* 
* http://www.geeksforgeeks.org/dynamic-programming-set-21-box-stacking-problem/
* 
*/
import java.util.Arrays;

public class BoxStacking {

	public BoxStacking(){}
	
	public int getMaxHeight(Dimension[] input) {
		
		Dimension[] allRotationInput = new Dimension[input.length * 3];
		
		//get all rotations of the box dimension 
		createAllRotation(input, allRotationInput);
		
		//sort the array in decreasing order
		Arrays.sort(allRotationInput);
		printAllRotation(allRotationInput);
		
		int[] temp = new int[allRotationInput.length];
		int[] result = new int[allRotationInput.length];
		
		for (int i = 0; i < allRotationInput.length; i++) {
		     temp[i] = 	allRotationInput[i].height;
		     result[i] = i;
		}
		
		
		//check if box at ith location can fit on top of box at jth location
		//if the length and width of box at ith location is strictly < than length and width of box at jth location, it will fit
		for (int i = 1; i < allRotationInput.length; i++) {			
			for (int j = 0; j < i; j++) {
					if (allRotationInput[i].length < allRotationInput[j].length 
						&& allRotationInput[i].width < allRotationInput[j].width) {					
					int newHeight = temp[j] + allRotationInput[i].height; //best you can do at j + height of box at i
					if (newHeight > temp[i]) {
						temp[i] = newHeight;
						result[i] = j;
					}
				}
			}
		}
		
		//get the max height from the temp array
		int maxHeight = temp[0];
		int maxIndex = 0;
		for (int i = 1; i < temp.length; i++) {
			if (temp[i] > maxHeight) {
				maxHeight = temp[i];
				maxIndex = i;
			}
		}
		
		getBoxStack(maxIndex, result, allRotationInput);
		
		return maxHeight;
		
	}
	
	private void getBoxStack(int maxIndex, int[] result, Dimension[] allRotationInput) {

		System.out.println("Following boxes can be stacked on top of each other ");
		int box = maxIndex;
		int nextBox = result[box];

		while (box != nextBox) {
			Dimension boxDimension = allRotationInput[box];
			System.out.println("Box #" + box + "  - " + boxDimension.toString());
			box = nextBox;
			nextBox = result[nextBox];
		}
		Dimension boxDimension = allRotationInput[box];
		System.out.println("Box #" + box + "  - " + boxDimension.toString());
		
	}
	
	public void printAllRotation(Dimension[] allRotationInput) {
		System.out.println("All rotations of the box dimension ");
		for(Dimension d: allRotationInput) {
			System.out.println(d);
		}
	}
	
	private void createAllRotation(Dimension[] input, Dimension[] allRotationInput) {
        int index = 0;
        
        for (int i = 0; i < input.length; i++) {
        	int h = input[i].height;
        	int l = input[i].length;
        	int w = input[i].width;
        	
        	allRotationInput[index++] = Dimension.createDimension(h, l, w);
        	allRotationInput[index++] = Dimension.createDimension(l, h, w);
        	allRotationInput[index++] = Dimension.createDimension(w, l, h);
        	
        }
    }
}
