import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(m*n) traverse whole board
// MC: O(m*n)
class Solution {

    public static void dfs(char[][] board, int r, int c, int rows, int columns){
        if(r >= rows || c >= columns || r<0 || c<0 || board[r][c] == '.') return;

        board[r][c] = '.';
        
        dfs(board, r + 1, c, rows, columns);
        dfs(board, r - 1, c, rows, columns);
        dfs(board, r, c + 1, rows, columns);
        dfs(board, r, c - 1, rows, columns);
    }

    public static int countBattleships(char[][] board) {
        if (board == null || board.length == 0) return 0;

        int rows = board.length;
        int columns = board[0].length;
        int battleships = 0;
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < columns; c++) {
                if(board[r][c] == 'X') {
                    battleships++;
                    dfs(board, r , c, rows, columns);
                }
            }
        }
        return battleships;
    }

    // follow-up Q
    // using only O(1) extra memory and without modifying the values board

    public static int countBattleships(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;
        int battleships = 0;

        for(int i =0; i< rows; i++){
            for(int j=0; j< columns; j++){
                if(board[i][j] == '.') continue;

                //only count the first ship
                if(i > 0 && board[i - 1][j] == 'X') continue; // check top
                if(j > 0 && board[i][j - 1] == 'X') continue; // check left

                battleships++;
            }
        }
        return battleships;
    }
    
    public static void main(String args[]) {
        char[][] board = {
            {'.'}
          // {'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}
            
        };
        int battleships = countBattleships(board);
        System.out.println("----s----" + battleships);
    }
}
