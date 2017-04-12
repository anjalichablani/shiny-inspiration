package Immutable2DSumRangeQuery;

import org.junit.Test;

public class testImmutable2DSumRangeQuery {

	@Test
	public void test() {
		int[][] matrix = {{2,0,-3,4},
			              {6,3,2,-1},
				          {5,4,7,3},
				          {2,-6,8,1}};
				
	                     
		Immutable2DSumRangeQuery rq = new Immutable2DSumRangeQuery(matrix);
	    int rectangleSum = rq.sumQuery(1, 1, 3, 2); //{1,1} to {3,2}	    
	    System.out.println("Sum of given dimension is " + rectangleSum);
	    
	    rectangleSum = rq.sumQuery(0, 2, 3, 3); //{0,2} to {3,3}
	    System.out.println("Sum of given dimension is " + rectangleSum);
	    
	}
	
	
	@Test
	public void test1() {
		
		 int[][] matrix = {{3, 0, 1, 4, 2},
                           {5, 6, 3, 2, 1},
                           {1, 2, 0, 1, 5},
                           {4, 1, 0, 1, 7},
                           {1, 0, 3, 0, 5}};
	                     
		Immutable2DSumRangeQuery rq = new Immutable2DSumRangeQuery(matrix);
	    int rectangleSum = rq.sumQuery(1, 1, 2, 2); //{1,1} to {2,2}	    
	    System.out.println("Sum of given dimension is " + rectangleSum);
	    
	}
	
	@Test
	public void test2() {
		
		 int[][] matrix = {{2,0,-3,4}, 
				           {6, 3, 2, -1}, 
				           {5, 4, 7, 3}, 
				           {2, -6, 8, 1}};
	                     
		Immutable2DSumRangeQuery rq = new Immutable2DSumRangeQuery(matrix);
	    int rectangleSum = rq.sumQuery(1, 1, 2, 2); //{1,1} to {2,2}	    
	    System.out.println("Sum of given dimension is " + rectangleSum);
	    
	}
}
