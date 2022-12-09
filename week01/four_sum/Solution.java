import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> sum = new ArrayList<>();
        
        if (start == nums.length) {
            return sum;
        }
        
        int average_value = target / k;

        if  (nums[start] > average_value || average_value > nums[nums.length - 1]) {
            return sum;
        }
        
        if (k == 2) {
            return twoSum(nums, target, start);
        }
    
        for (int i = start; i < nums.length; ++i) {
            if (i == start || nums[i - 1] != nums[i]) {
                for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    sum.add(new ArrayList<>(Arrays.asList(nums[i])));
                    sum.get(sum.size() - 1).addAll(subset);
                }
            }
        }
    
        return sum;
    }
        
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> sum = new ArrayList<>();
        Set<Long> s = new HashSet<>();
    
        for (int i = start; i < nums.length; ++i) {
            if (sum.isEmpty() || sum.get(sum.size() - 1).get(1) != nums[i]) {
                if (s.contains(target - nums[i])) {
                    sum.add(Arrays.asList((int)target - nums[i], nums[i]));
                }
            }
            s.add((int)nums[i]);
        }
                                                  
        return sum;
    }

    public static void main(String[] args){
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        List<List<Integer>> answer = fourSum(nums, target);
        System.out.println("------- : " + answer);
    }
}