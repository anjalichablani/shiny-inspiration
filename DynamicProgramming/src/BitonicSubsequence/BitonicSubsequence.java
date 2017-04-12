package BitonicSubsequence;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class BitonicSubsequence {
	
	int[] lis;
	int[] lds;
	int[] arr;
	Map<Integer, Set<Integer>> lisMap;
	Map<Integer, Set<Integer>> ldsMap;
	
	public BitonicSubsequence(int[] arr) {
		
		//Map that stores longest increasing subsequence for the key
		lisMap = new HashMap<Integer, Set<Integer>>();
		
		//Map that stores longest decreasing subsequence for the key
		ldsMap = new HashMap<Integer, Set<Integer>>();
		
		lis = new int[arr.length]; //longest increasing subsequence length
		lds = new int[arr.length]; //longest decreasing subsequence length
		
		//initialize auxiliary dp array to 1
		for(int i=0; i< arr.length; i++) {
			lis[i] = 1;
			lds[i] = 1;
			lisMap.put(arr[i], new TreeSet<Integer>());
			ldsMap.put(arr[i], new TreeSet<Integer>(Collections.reverseOrder()));
		}
		this.arr = arr;
	}
	
	public void getBitonicSubsequence() {	

		computeLongestIncreasingSubsequence();
		computeLongestDecreasingSubsequence();
		
		// longest bitonic subsequence length
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < arr.length; i++) {
			int val = (lis[i] + lds[i]) - 1;
			if (val > max) {
				max = val;
				index = i;
			}
		}
		
		printLIS();
		printLDS();
		printBitonicSubsequence(index, max);
		
		
	}
	
	private void computeLongestIncreasingSubsequence() {
		// calculate longest increasing subsequence length
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {					
					if (lis[j]+ 1 > lis[i]) {
						 lis[i] = lis[j] + 1;
						 lisMap.get(arr[i]).add(arr[j]);
					}			  
				}
			}
		}
	}
	
	private void computeLongestDecreasingSubsequence() {
		//go in reverse order
		//initialize  i = arr.length - 2;
		//initialize  j = arr.length -1;
		
		//calculate longest decreasing subsequence length
		for (int i = arr.length - 2; i >= 0; i--) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[i]) {
					if (lds[j] + 1 > lds[i]){
					  lds[i] = lds[j] + 1;
					  ldsMap.get(arr[i]).add(arr[j]);
					}
				}
			}
		}
	}

	private void printBitonicSubsequence(int index, int max) {

		System.out.println("\nLength of LBS is " + max);
		int key = arr[index];

		for (int val : lisMap.get(key)) {
			System.out.print(val + ",");
		}
		
		System.out.print(key + ",");

		Iterator<Integer> it = ldsMap.get(key).iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
			if (it.hasNext()) {
				System.out.print(",");
			}
		}
	}

	private void printLIS() {
		
		System.out.println("Map maintaining longest increasing subsequence for every element");
		for(Entry <Integer, Set<Integer>> entry: lisMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	private void printLDS() {
		System.out.println("Map maintaining longest decreasing subsequence for every element");
		for(Entry <Integer, Set<Integer>> entry: ldsMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
