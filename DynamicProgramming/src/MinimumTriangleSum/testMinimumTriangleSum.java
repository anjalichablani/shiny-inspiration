package MinimumTriangleSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class testMinimumTriangleSum {

	@Test
	public void test(){
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();		
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		
		MinimumTriangleSum mts = new MinimumTriangleSum();
		int result = mts.minimumTotal(triangle);
		System.out.print(result);
		
		/*
		for (List<Integer> l: triangle) {
			for (Integer i: l){
			  System.out.print(i);
			}
			System.out.print("\n");
		}
		*/
	}
	
	@Test
	public void test_1(){
		
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();		
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(5, 7, 6));
		triangle.add(Arrays.asList(4, 3, 8, 1));
		
		MinimumTriangleSum mts = new MinimumTriangleSum();
		int result = mts.minimumTotal(triangle);
		System.out.print(result);
		
		/*
		for (List<Integer> l: triangle) {
			for (Integer i: l){
			  System.out.print(i);
			}
			System.out.print("\n");
		}
		*/
	}
}
