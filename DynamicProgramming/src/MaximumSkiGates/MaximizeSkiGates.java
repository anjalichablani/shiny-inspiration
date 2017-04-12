package MaximumSkiGates;

import java.util.HashMap;
import java.util.Map;

public class MaximizeSkiGates {
    class Index {
        int remainingChanges;
        int current;
        boolean isRight;
        int prevItem;

        Index(int remainingChanges, int current, boolean isRight, int prevItem) {
            this.remainingChanges = remainingChanges;
            this.current = current;
            this.isRight = isRight;
            this.prevItem = prevItem;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index obj = (Index) o;

            if (this.remainingChanges != obj.remainingChanges) 
            	return false;
            if (this.current != obj.current) 
            	return false;
            if (this.isRight != obj.isRight) 
            	return false;
            
             if(prevItem == obj.prevItem)
            	 return true;
             
             return false;

        }

        @Override
        public int hashCode() {
            int result = remainingChanges;
            result = 31 * result + current;
            result = 31 * result + (isRight ? 1 : 0);
            result = 31 * result + prevItem;
            return result;
        }
    }

    public int solution(int[] gates, int totalDirectionChanges) {
        Map<Index, Integer> dpMap = new HashMap<>();
        int result =  solution(gates, totalDirectionChanges, 0, false, -1, dpMap);
        return result;
    }

    public int solution(int[] gates, int remainingDirectionChanges, int current, boolean isRight, int prevItem, Map<Index, Integer> dpMap) {
        if(current >= gates.length) {
            return 0;
        }

        Index index = new Index(remainingDirectionChanges, current, isRight, prevItem);
        if(dpMap.containsKey(index)) {
           int indexVal = dpMap.get(index);
           return indexVal;
        }

        int val1 = 0, val2 = 0;
        //if current gate is picked.
        if((isRight && gates[current] < prevItem) || (!isRight && gates[current] > prevItem)) {
            //if we decide to continue in same direction.
            val1 = 1 + solution(gates, remainingDirectionChanges, current + 1, isRight, gates[current], dpMap);
            if(remainingDirectionChanges > 0) {
                //if we flip direction. We can only do that if remainingDirectionChanges > 0
                val2 = 1 + solution(gates, remainingDirectionChanges - 1, current + 1, !isRight, gates[current], dpMap);
            }
        }

        //if current gate is not picked
        int val3 = solution(gates, remainingDirectionChanges, current + 1, isRight, prevItem, dpMap);

        //max of all 3 possibilities
        int max = Math.max(Math.max(val1, val2), val3);
        dpMap.put(index, max);
        return max;
    }
}
