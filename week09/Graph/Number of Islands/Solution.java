import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(m*n) traverse whole grid
// MC: O(m*n)
class Solution {

    public static void dfs(char[][] grid, int r, int c, int rows, int columns){
        if(r >= rows || c >= columns || r<0 || c<0 || grid[r][c] == '0') return;

        grid[r][c] = '0';
        
        dfs(grid, r + 1, c, rows, columns);
        dfs(grid, r - 1, c, rows, columns);
        dfs(grid, r, c + 1, rows, columns);
        dfs(grid, r, c - 1, rows, columns);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;
        int islands = 0;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++) {
                if(grid[r][c] == '1') {
                    islands++;
                    dfs(grid, r , c, rows, columns);
                }
            }
        }
        return islands;
    }
    public static void main(String args[]) {
        char[][] grid = {
          {'1','1','1','1','0'},
          {'1','1','0','1','0'},
          {'1','1','0','0','0'},
          {'0','0','0','0','0'}
        };
        int islands = numIslands(grid);
        System.out.println("----s----" + islands);
    }
}
