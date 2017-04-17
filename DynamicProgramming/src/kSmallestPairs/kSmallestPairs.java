package kSmallestPairs;

/**
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/#/description
 * 
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 */
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kSmallestPairs {
	
	public List<int[]> getkSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<>();
		
		if (nums1 == null || nums1.length == 0 || nums2==null|| nums2.length == 0) {
			return result;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k);
		
		// only need first k number in nums1 to start 
		for (int i=0; i<nums1.length && i<k ; i++) {  
            pq.offer( new Pair(0, nums1[i],nums2[0]));
        }
		
        for (int i=1; i<=k && !pq.isEmpty(); i++) { // get the first k sums
            Pair p = pq.poll(); 
            result.add( p.pair );
            if (p.index < nums2.length -1 ) { // get to next value in nums2
                int next = p.index+1;
                pq.offer( new Pair(next, p.pair[0], nums2[next]) );
            }
        }
        
        return result;
	}
	
	public class Pair implements Comparable<Pair>{
		int index;
		int[] pair;
		long sum;
		
		public Pair(int index, int a, int b){
			this.index = index;
			this.pair = new int[] {a, b};
			this.sum = (long) a + (long) b;
		}

		@Override
		public int compareTo(Pair o) {
			int val = this.sum <= o.sum? -1:1;
			return val;
			
		}
		
	}
}
