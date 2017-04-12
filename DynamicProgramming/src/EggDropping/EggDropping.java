package EggDropping;

public class EggDropping {

	
	/**
	 * The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36
	 * floors.
	 * 
	 * Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will
	 * cause the eggs to break on landing. We make a few assumptions:
	 * 
	 * …..An egg that survives a fall can be used again. …..A broken egg must be discarded. …..The effect of a fall is
	 * the same for all eggs. …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
	 * …..If an egg survives a fall then it would survive a shorter fall. …..It is not ruled out that the first-floor
	 * windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
	 * 
	 * If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried
	 * out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second floor
	 * window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs
	 * are available. What is the least number of egg-droppings that is guaranteed to work in all cases? The problem is
	 * not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that
	 * total number of trials are minimized.
	 */
	public int findMinTrialsForDroppingEggs(int floors, int eggs) {
		/* A 2D table where entery eggFloor[i][j] will represent minimum
	       number of trials needed for i eggs and j floors. */
	        int eggFloor[][] = new int[eggs+1][floors+1];
	        
	        int i, j;
	        int res;
	        
	          
	       // We always need j trials for one egg and j floors.
	        for (j = 0; j <= floors; j++) {
	        	eggFloor[0][j] = 0;
	            eggFloor[1][j] = j;
	        }
	          
	        // Fill rest of the entries in table using optimal substructure
	        // property
	        for (i = 2; i <= eggs; i++) {
	            for (j = 1; j <= floors; j++) {
	                int min = Integer.MAX_VALUE;
	                for (int k = 1; k <= j; k++) {
	                     res = 1 + Math.max(eggFloor[i-1][k-1], eggFloor[i][j-k]);
	                     if (res < min) {
	                        min = res;
	                     }
	                }
	                eggFloor[i][j] = min;
	            }
	        }
	          
	        printCache(eggFloor);
	        
	        return eggFloor[eggs][floors];
	}
	
	private void printCache(int[][] cache) {
		System.out.println("Cache : ");
		for (int row = 0; row < cache.length; row++) {
			for (int col = 0; col < cache[0].length; col++)
				System.out.print(cache[row][col]);
			System.out.println();
		}
		
	}
}
