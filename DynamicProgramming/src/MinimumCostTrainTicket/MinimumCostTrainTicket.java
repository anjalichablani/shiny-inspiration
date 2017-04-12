package MinimumCostTrainTicket;
/**
 * http://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/
 * 
 * Find the minimum cost to reach destination using a train
   There are N stations on route of a train. 
   The train goes from station 0 to N-1. The ticket cost for all pair of stations (i, j) is given where j is greater than i. 
   Find the minimum cost to reach the destination.

   Consider the following example:
Input: 
cost[N][N] = { {0, 15, 80, 90},
              {INF, 0, 40, 50},
              {INF, INF, 0, 70},
              {INF, INF, INF, 0}
             };
There are 4 stations and cost[i][j] indicates cost to reach j 
from i. The entries where j < i are meaningless.

Output:
The minimum cost is 65
The minimum cost can be obtained by first going to station 1 
from 0. Then from station 1 to station 3.
 *
 */
public class MinimumCostTrainTicket {

	public int minCost(int ticket[][]) {
		if ((ticket == null) || (ticket.length == 0))
		   return 0;
		
		int temp[] = new int[ticket.length];
		int result[] = new int[ticket.length];
		
		result[0] = -1;
		temp[0] = 0;
		for (int i = 1; i < temp.length; i++) {
			temp[i] = Integer.MAX_VALUE;
			result[i] = 0;
		}

		for (int i = 0; i < temp.length; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				//cost to reach i is temp[i] + the ticket cost to reach j from i
				int newCost = temp[i] + ticket[i][j];
				if (newCost < temp[j]) {
					temp[j] = newCost;
					result[j] = i;
				}
			}
		}

		// printing actual stations
		int i = ticket.length - 1;
		while (i != -1) {
			System.out.print(i + " ");
			i = result[i];
		}
		System.out.println();
		return temp[ticket.length - 1];
	}

}
