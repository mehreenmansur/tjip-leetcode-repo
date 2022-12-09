import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    // O(n) time O(n) space
    public static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for(int i = 0; i < intervals.length; i++) {
            if(queue.size() == 0) {
                queue.add(intervals[i][1]);
            } else if(queue.peek() > intervals[i][0]){
                queue.add(intervals[i][1]);
            } else if(queue.peek() <= intervals[i][0]){
                queue.poll();
                queue.add(intervals[i][1]);
            }
        }     
        
        return queue.size();
    }
   
    public static void main(String[] args){


        int[][] intervals = {{0,30}, {5,10}, {15,20}};
        // int[][] intervals = {{7, 10}, {2, 4}};

        
        int rooms = minMeetingRooms(intervals);

        System.out.println("---rooms---- : " + rooms);
    }
}
