package FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/frog-jump/ A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the
 * river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1
 * unit.
 * 
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog
 * can only jump in the forward direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100. Each stone's position will be a non-negative integer < 2^31. The first
 * stone's position is always 0. Example 1:
 * 
 * [0,1,3,5,6,8,12,17]
 * 
 * There are a total of 8 stones. The first stone at the 0th unit, second stone at the 1st unit, third stone at the 3rd
 * unit, and so on... The last stone at the 17th unit.
 * 
 * Return true. The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone,
 * then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.
 * Example 2:
 * 
 * [0,1,2,3,4,8,9,11]
 * 
 * Return false. There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 *
 */

public class FrogJump {

	public boolean canCross(int[] stones) {

		// There has to be at least 2 stones and the first 2 stones have to be 0
		// and 1
		if (stones == null || stones.length < 2 || stones[0] != 0
				|| stones[1] != 1)
			return false;

		//last stone position
		int destinationStone = stones[stones.length-1];
		
		// We maintain a set of stone position just to lookup if the jump we are attempting is going
        // to land on a stone or in water
		Set<Integer> stonePositionSet = new HashSet<Integer>();
		for (int i = 0; i < stones.length; i++) {
			stonePositionSet.add(stones[i]);
		}

		// We maintain a map of stone position and the set of last jump sizes made to reach that stone.
        // Note => Using a list instead of set will reduce performance by a lot due to duplicate jumps sizes
        // see test case with 1000 stones.
		Map<Integer, Set<Integer>> stonePositionToJumpsToReach = new HashMap<Integer, Set<Integer>>();
		stonePositionToJumpsToReach.put(stones[0], new HashSet<Integer>());
		stonePositionToJumpsToReach.get(stones[0]).add(0);

		// We start from stone 0 and then check which next stones can we reach
        // by making a jump from current stone
		for (int i = 0; i < stones.length; i++) {
			int stonePosition = stones[i];

			 // If the current stone is reachable then we need to get the last jumps made to reach here
			if (stonePositionToJumpsToReach.containsKey(stonePosition)) {
				if (stonePosition == destinationStone) 
					return true;
				
				Set<Integer> jumps = stonePositionToJumpsToReach.get(stonePosition);
				for (Integer jump : jumps) {
					// For each jump used to reach current stone, we check what 
	            	// next hops are reachable with jump of +/- 1 on current jump
					for (int k = jump - 1; k <= jump + 1; k++) {
						int nextHop = stonePosition + k;
						if (nextHop <= stonePosition) {
							continue;
						}
						// check if there is a stone at next hop
						if (stonePositionSet.contains(nextHop)) {
							Set<Integer> jumpSet = stonePositionToJumpsToReach
									.get(nextHop);
							if (jumpSet == null) {
								jumpSet = new HashSet<Integer>();
								stonePositionToJumpsToReach.put(nextHop,
										jumpSet);
							}
							jumpSet.add(k);
						}
					}
				}
			}
		}
		
		if (stonePositionToJumpsToReach.containsKey(destinationStone)) {
			return true;
		}

		return false;
	}
}
