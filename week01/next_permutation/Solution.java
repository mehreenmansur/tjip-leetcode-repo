import java.util.*;
import java.io.*;
import java.math.*;


//O(n) time O(1) space 
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 2) {
            swap(nums, 0, 1);
        } else {
            int i = nums.length - 2;
            while (i >= 0 && nums[i] >= nums[i+1]) i--;
            if (i >= 0) {
                int j = nums.length - 1;
                while (j > i && nums[i] >= nums[j]) j--;
                swap(nums, i, j);
            }
            reverse(nums, i+1, nums.length - 1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        if (j < nums.length) {
            int base = nums[i];
            nums[i] = nums[j];
            nums[j] = base;
        }
    }


    public void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }
    public static void main(String[] args){

        int[] nums = {1, 2, 3};

        nextPermutation(nums);

        for (int i = 0; i < nums.length; i++){
            System.out.println("------- : " + nums[i]);
        }    
    }

}