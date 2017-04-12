package DungeonGame;

import org.junit.Test;

public class testDungeonGame {

	@Test
	public void test(){
		DungeonGame dg = new DungeonGame();
	    int[][] dungeon = {{-2, -3, 3}, 
	    		           {-5, -10, 1}, 
	    		           {10, 30, -30}};
	    
	    System.out.print("Minimum health needed at start : " + dg.calculateMinimumHP(dungeon));
	}
	
	@Test
	public void test1(){
		DungeonGame dg = new DungeonGame();
	    int[][] dungeon = {{-2, -3, 3}, 
	    		           {-5, -10, 1}, 
	    		           {10, 30, -5}};
	    
	    System.out.print("Minimum health needed at start : " + dg.calculateMinimumHP(dungeon));
	}
}
