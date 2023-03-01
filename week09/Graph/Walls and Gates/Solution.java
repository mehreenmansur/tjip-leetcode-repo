import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(m*n) traverse whole grid
// MC: O(m*n)
class Solution {

    public void dfs(int[][] rooms, int r, int c, int rows, int columns, int distance){
        if(r<0 || c<0 || r >= rows || c >= columns ||  rooms[r][c] < distance) return;
      
        rooms[r][c] = distance;

        //without condition dfs calls causes TLE
        if(((r + 1) < rows) && ((distance + 1) < rooms[r+1][c]))
          dfs(rooms, r + 1, c, rows, columns, distance + 1);
        if(r > 0 && ((distance + 1) < rooms[r - 1][c]))
          dfs(rooms, r - 1, c, rows, columns, distance + 1);
        if(((c + 1) < columns) && ((distance + 1) < rooms[r][c + 1]))
          dfs(rooms, r, c + 1, rows, columns, distance + 1);
        if(c > 0 && ((distance + 1) < rooms[r][c - 1]))
          dfs(rooms, r, c - 1, rows, columns, distance + 1);
    }

    public static void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return 0;

        int rows = rooms.length;
        int columns = rooms[0].length;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++) {
                if(rooms[r][c] == 0) {
                    dfs(rooms, r , c, rows, columns, 0);
                }
            }
        }
    }
    public static void main(String args[]) {
        int[][] rooms = {
            {2147483647, -1, 0, 2147483647},
            {2147483647, 2147483647, 2147483647, -1},
            {2147483647, -1, 2147483647, -1},
            {0, -1, 2147483647, 2147483647}
        };
        wallsAndGates(rooms);
    }
}
