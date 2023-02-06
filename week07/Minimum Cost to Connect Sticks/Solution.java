import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(NlogN) time to add sticks array in PQ 
// MC: O(N) length of PQ which is length of sticks array
class Solution {

    public int connectSticks(int[] sticks) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<sticks.length(); i++) pq.add(sticks[i]);
        while(pq.size > 1) {
            int first = pq.peek();
            pq.poll();
            int second = pq.peek();
            pq.poll();
            cost += first + second;
        }
        return cost;     
    }

    public static void main(String args[]) {
        int[] sticks = {2,4,3};
        int ans = connectSticks(sticks);
        System.out.println("----s----" + ans);
    }
}
