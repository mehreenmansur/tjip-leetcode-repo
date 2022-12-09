import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> myhash = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(!myhash.containsKey(target - nums[i])){
                myhash.put(nums[i], i);
            } else {
                ans[0] = i;
                ans[1] = myhash.get(target - nums[i]);
                break;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] answer = twoSum(nums, target);
        System.out.println("answer-----------" + answer[1]);
    }
}

