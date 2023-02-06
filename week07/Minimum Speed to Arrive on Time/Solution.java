import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(NlogN)
// MC: O(N) for PQ 
class Solution {

    public int minMeetingRooms(int[][] intervals) {
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
}
