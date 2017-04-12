package MinJumpToReachEnd;

import java.util.Arrays;

//Given an array of integers where each element represents the max number of steps 
//that can be made forward from that element. 
//Write a function to return the minimum number of jumps to reach the 
//end of the array (starting from the first element). 
//If an element is 0, then cannot move through that element.

public class MinJumpToReachEnd {

	public int computeMinJumpToReachEnd(int[] input) {
		
		int[] results = new int[input.length];
		int[] jumps = new int[input.length];
		jumps[0] = 0;
		
        for(int i=1; i < input.length ; i++){
            jumps[i] = Integer.MAX_VALUE-1;
        }
        
		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if ((j + input[j]) >= i) { //i is reachable or within range
					if (jumps[j]+1 < jumps[i]) {
					  jumps[i] = jumps[j]+1;
					  results[i] = j;
					}
				}
			}
		}
		
		printResults(results);
		printJumps(jumps);
		return jumps[input.length-1];
	}
	
    private void printResults(int[] results) {	
		
    	System.out.println("Results");
        System.out.println(Arrays.toString(results));
        
        System.out.println("Path taken - ");
        
        int dest = results.length -1;
        int predecessor = results[dest];		
        while (dest != predecessor) {
        	System.out.print(dest + "->");
        	dest = predecessor;
        	predecessor = results[dest];
        }
        System.out.print(dest);
	}
    
	private void printJumps(int[] jumps) {
		System.out.println("\nJumps");
		System.out.println(Arrays.toString(jumps));
	}
}
