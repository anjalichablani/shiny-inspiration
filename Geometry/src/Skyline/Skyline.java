package Skyline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Given skyline of a city merge the buildings
//https://www.youtube.com/watch?v=GSBLe8cKu0s&t=662s
public class Skyline {
	
	public void getSkyLine(int[][] buildings) {
		BuildingPoint[] buildingPoints = getBuildingPoints(buildings);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.add(0);
		int prevMaxHeight = 0;
		List<int[]> output = new ArrayList<int[]> ();
		for(BuildingPoint bp: buildingPoints) {
			if (bp.isStart) { //if it is start of building then add the height to pq
				pq.add(bp.height);
			} else { //if it is end of building then decrement or remove the height from pq.
				pq.remove(bp.height);
			}
		
		    //if height changes from previous height then this building x becomes critcal x.
            // So add it to the result.

			int currentMaxHeight = pq.peek();
			if (prevMaxHeight != currentMaxHeight) {
				if(bp.isStart) {
					output.add(new int[]{bp.x, bp.height});
				} else {
					output.add(new int[]{bp.x, currentMaxHeight});
				}
				prevMaxHeight = currentMaxHeight;
			}
		}
			
		for (int[] skylinePoint: output) {
			System.out.println(skylinePoint[0] + "," + skylinePoint[1]);
		}
	}
	
	public BuildingPoint[] getBuildingPoints(int[][] buildings) {
		//for all start and end of building put them into List of BuildingPoint

		BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
		int index = 0;
		
		for (int[] building: buildings) {
		    BuildingPoint bp = new BuildingPoint();	
		    bp.x = building[0];
		    bp.isStart = true;
		    bp.height = building[2];
		    buildingPoints[index++] = bp;
		    
		    BuildingPoint bp1 = new BuildingPoint();	
		    bp1.x = building[1];
		    bp1.isStart = false;
		    bp1.height = building[2];
		    buildingPoints[index++] = bp1;
		    
		    
		}
		Arrays.sort(buildingPoints);
		for (BuildingPoint bp: buildingPoints) {
     		System.out.println(bp.toString());
		}
		return buildingPoints;
	}
	
	
}
