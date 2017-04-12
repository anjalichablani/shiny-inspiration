package MinimizeCostRodCut;

//viral's implementation
import java.util.Arrays;

public class MinimizeCostRodCut {
	
		public int minCost(int[] weakPoints, int length) {
			int[][] cache = new int[length+1][length+1];
			for (int i = 0; i < cache.length; i++) {
				Arrays.fill(cache[i], Integer.MAX_VALUE);
			}
			
			for (int i = 0; i < cache.length; i++)
				cache[i][0] = 0;
			
			minCostInner(weakPoints, 0, weakPoints.length - 1, 0, length, cache);
			return cache[0][length];
		}

		private int minCostInner(int[] weakPoints, int startIndex, int endIndex, int rodStart, int rodEnd, int[][] cache) {
			if (startIndex > endIndex)
				cache[rodStart][rodEnd] = 0;
			
			if (cache[rodStart][rodEnd] != Integer.MAX_VALUE)
				return cache[rodStart][rodEnd];
			
			for (int k = startIndex; k <= endIndex; k++) {
				int cost = minCostInner(weakPoints, startIndex, k - 1, rodStart, weakPoints[k], cache) + 
						minCostInner(weakPoints, k+1, endIndex, weakPoints[k], rodEnd, cache);
				
				if (cost < cache[rodStart][rodEnd])
					cache[rodStart][rodEnd] = cost;
			}
			
			cache[rodStart][rodEnd] += rodEnd - rodStart;
			
			return cache[rodStart][rodEnd];
		}
		
		
	

}
