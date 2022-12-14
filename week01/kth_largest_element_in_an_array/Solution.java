import java.util.*;

class Solution {
    public static int findKthLargest(int[] nums, int k){
        if(nums.length == 0) return 0;

        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        int count = 0;

        for(int i : nums) {
            pQueue.add(i);
            count++;
            if(count > k) {
                pQueue.poll();
                count--;
            }
        }
        return pQueue.peek();
    }

    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int answer = findKthLargest(nums, k);
        
        System.out.println("----answer--- : " + answer);
   
    }

}

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

1 2 6 24