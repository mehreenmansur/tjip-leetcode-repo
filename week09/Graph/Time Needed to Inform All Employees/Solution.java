import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) manager.length
// MC: O(N)

class Solution {
    public static int time = 0;
    public static Map<Integer, List<Integer>> emp_map = new HashMap<>();

    public static int dfs(int id, int[] informTime) {
        if(!emp_map.containsKey(id)) return 0;
        List<Integer> emps = emp_map.get(id);
        
        int max = 0;
        for(Integer i : emps) {
            max = Math.max(max, dfs(i, informTime));
        }
        
        return max + informTime[id];
    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        for(int i = 0; i < manager.length; i++) {
            if(manager[i] != -1) {

                if(!emp_map.containsKey(manager[i])){
                    emp_map.put(manager[i], new ArrayList<>());
                }
                emp_map.get(manager[i]).add(i);
            };
        }
        if (emp_map.size() == 0) return 0;
        return dfs(headID, informTime);
    }

    public static void main(String args[]) {
        int n = 15;
        int headID = 0;
        int[] manager = {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        int[] informTime = {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        int ans = numOfMinutes(n, headID, manager, informTime);
        System.out.println("----s----" + ans);
    }
}
