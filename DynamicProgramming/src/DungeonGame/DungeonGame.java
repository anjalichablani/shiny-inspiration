package DungeonGame;

/**
 *
 * Minimum life needed for knight to reach princess in 2D matrix.
 * 
 * Time complexity O(n^2)
 * Space complexity O(n^2)
 *
 * https://leetcode.com/problems/dungeon-game/
 *
 */
public class DungeonGame {

	
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        
        int[][] healthMatrix = new int[dungeon.length][dungeon[0].length];

        int m = dungeon.length - 1;
        int n = dungeon[0].length - 1;

        int x = 1 - dungeon[m][n];
        healthMatrix[m][n] = Math.max(x , 1);

        
        for (int i = m - 1, j = n; i >= 0; i--) {
        	int health = healthMatrix[i + 1][j];
        	int charm = dungeon[i][j];
        	healthMatrix[i][j] = Math.max(health - charm , 1);
        }

        for (int j = n - 1, i = m; j >= 0; j--) {
        	int health = healthMatrix[i][j+1];
        	int charm = dungeon[i][j];
        	healthMatrix[i][j] = Math.max(health - charm, 1);
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
            	int health1 = healthMatrix[i + 1][j];        	
            	int health2 = healthMatrix[i][j + 1];
            	int charm = dungeon[i][j];
            	
            	int val1 = Math.max(health1 - charm, 1);
            	int val2 = Math.max(health2 - charm, 1);
            	
            	healthMatrix[i][j] = Math.min(val1, val2);
            }
        }

        printHealthMatrix(healthMatrix);
        return healthMatrix[0][0];
    }

    public void printHealthMatrix(int[][] healthMatrix) {
    	
    	for (int i = 0; i < healthMatrix.length; i++){
    		for(int j = 0; j < healthMatrix[0].length; j++){
    			System.out.print(String.format("%2d ", healthMatrix[i][j]));
    		}
    		System.out.print("\n");
    	}
    }
}
