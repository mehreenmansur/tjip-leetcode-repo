import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) number of courses
// MC: O(N)


// too many ifs perhaps, more precise code possible? 
class Solution {
    public static Map<Integer, List<Integer>> map_courses = new HashMap<>();
    public static boolean canFinish = true;

    public static boolean dfs(int root, boolean[] visit, boolean[] explored) {
        if (visit[root] == true) return false; 
        if (explored[root] == true) return true;

        visit[root] = true;
        boolean canExplore = true;

        if(map_courses.containsKey(root)) {
            List<Integer> children = map_courses.get(root);
            
            for(Integer i : children) {
                if(explored[i] == false)
                    canExplore = dfs(i, visit, explored);
                if (canExplore == false) break;
            }
        }

        explored[root] = true;
        visit[root] = false;

        return canExplore;
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < prerequisites.length; i++) {
            if(!map_courses.containsKey(prerequisites[i][0])){
                map_courses.put(prerequisites[i][0], new ArrayList<>());
            }
            map_courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] explored = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(map_courses.containsKey(i)) {
                canFinish = dfs(i, visit, explored);
                if (canFinish == false) break;
            }
        }
        return canFinish;
    }

    public static void main(String args[]) {
        int numCourses = 3;
        // int[][] prerequisites = {{0,1}, {0,1}};
        // int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        // int[][] prerequisites = {{0,1},{0,2},{1,2}};
        int[][] prerequisites = {{1,0},{1,2},{0,1}};
        boolean ans = canFinish( numCourses, prerequisites);
        System.out.println("----s----" + ans);
    }
}
