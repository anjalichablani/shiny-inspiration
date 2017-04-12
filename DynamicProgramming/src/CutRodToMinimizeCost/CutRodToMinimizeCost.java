package CutRodToMinimizeCost;

/**
 * 
 * http://qa.geeksforgeeks.org/4063/minimize-the-cutting-cost-latest-google-question
 * 
For example,

N = 6
A = [1, 2, 5]

-------------------------------
0   1   2    3    4     5     6

6 --> cut at 1 --> 0-1, 1-6  
5 --> cut at 2 --> 1-2, 2-6
4 --> cut at 5 --> 2-5, 5-6

If we make cuts in order [1, 2, 5], let us see what total cost would be.
For first cut, the length of rod is 6.
For second cut, the length of sub-rod in which we are making cut is 5(since we already have made a cut at 1).
For third cut, the length of sub-rod in which we are making cut is 4(since we already have made a cut at 2).
So, total cost is 6 + 5 + 4.

Cut order          | Sum of cost
(lexicographically | of each cut
 sorted)           |
___________________|_______________
[1, 2, 5]          | 6 + 5 + 4 = 15
[1, 5, 2]          | 6 + 5 + 4 = 15
[2, 1, 5]          | 6 + 2 + 4 = 12
[2, 5, 1]          | 6 + 4 + 2 = 12
[5, 1, 2]          | 6 + 5 + 4 = 15
[5, 2, 1]          | 6 + 5 + 2 = 13
*
*/

public class CutRodToMinimizeCost {
	
	public int cutRodToMinimizeCost(int[] cuts, int total) {
        int dp[][] = new int[total+1][total+1];
        for(int i = 0 ; i < dp.length; i++) {
            for(int j=0; j < dp[i].length ; j++) {
                dp[i][j] = -1;
            }
        }

        return cutRodToMinimizeCostInner(0, total,  cuts, dp);
        //return cutRod(0, total, cuts);
    } 
    
    //dp solution
    private int cutRodToMinimizeCostInner(int start, int end, int[]cuts, int [][] dp){
      
    	if(dp[start][end]!= -1){//Some initializations need to be done
            return dp[start][end];
        }
        
        int minCost = Integer.MAX_VALUE;
        boolean canCut = false;
        int cost = end - start;
       
        //Go thru all available cut points and check if possible to cut the given rod.
   	    //A rod can be cut if the cut point falls inside the rod start and end.  
        for(int i = 0; i < cuts.length; i++){
           if(cuts[i]> start && cuts[i]<end){
             int leftSideCutOfRod = cutRodToMinimizeCostInner(start, cuts[i], cuts, dp);
             int rightSideCutOfRod = cutRodToMinimizeCostInner(cuts[i], end, cuts, dp); 
             int totalCost = leftSideCutOfRod + rightSideCutOfRod + cost;
             minCost = Math.min(totalCost, minCost);
             canCut = true;
           } 
        }
        
        if (!canCut) {
        	dp[start][end] = 0;
        	return 0;
        }
        
        dp[start][end] = minCost;
        
        return dp[start][end];
    }
    
    //recursive soln - non dp
    public int cutRod(int start, int end, int[] cuts) {
    	 int minCost = Integer.MAX_VALUE;
    	 int cost = end-start;
    	 boolean canCut = false;
    	 
    	 //Go thru all available cut points and check if possible to cut the given rod.
    	 //A rod can be cut if the cut point falls inside the rod start and end. 
    	for(int i = 0; i < cuts.length; i++){
    	   if(cuts[i]> start && cuts[i]<end){
    		   int leftSideCutOfRod = cutRod(start, cuts[i], cuts);
    		   int rightSideCutOfRod = cutRod(cuts[i], end, cuts);
    		   int totalCost = leftSideCutOfRod + rightSideCutOfRod + cost;
    	       minCost = Math.min(totalCost, minCost);
    	       canCut = true;
    	   } 
    	}
    	
    	if (!canCut)
    		return 0;
    	
    	return minCost;
    }
    
   
}
