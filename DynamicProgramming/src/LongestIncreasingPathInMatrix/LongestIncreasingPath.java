package LongestIncreasingPathInMatrix;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or down. 
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * 
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/#/description
 * 
 * Do DFS from every cell
   Compare every 4 direction and skip cells that are out of boundary or smaller
   Get matrix max from every cell's max
   The key is to cache the distance because it's highly possible to revisit a cell

 * Time complexity is O(n*m)
 * Space complexity is O(n*m)

 *
 */
public class LongestIncreasingPath {

    public int computeLongestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[][] distance = new int[matrix.length][matrix[0].length];
        int max = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int r = dfs(matrix, i, j, distance, Integer.MIN_VALUE);
                if (r > max) {
                    max = r;
                }
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int i, int j, int[][] distance, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length) {
            return 0;
        }

        if (matrix[i][j] <= prev) {
            return 0;
        }

        if (matrix[i][j] > prev && distance[i][j] != 0) {
            return distance[i][j];
        }

        int v1 = dfs(matrix, i - 1, j, distance, matrix[i][j]);  //up
        int v2 = dfs(matrix, i, j - 1, distance, matrix[i][j]);  //left
        int v3 = dfs(matrix, i + 1, j, distance, matrix[i][j]);  //down
        int v4 = dfs(matrix, i, j + 1, distance, matrix[i][j]);  //right
        distance[i][j] = 1 + Math.max(Math.max(v1, v2), Math.max(v3, v4));
        return distance[i][j];
    }
}