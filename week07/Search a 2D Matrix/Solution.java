import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(log(m * n)) 
// MC: O(1)

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int L = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int R = (row * column) - 1;
        while(L <= R) {
            int mid = (L + R) / 2;
            int dr = mid / column; // to convert in 2d indexes
            int dc = mid % column;
            if(matrix[dr][dc] > target) R = mid - 1;
            else if(matrix[dr][dc] < target) L = mid + 1;
            else return true;
        }
        return false;
    }
}