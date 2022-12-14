import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    // O(n) time O(n) space // use constant extra space?

    public static int firstMissingPositive(int[] nums) {
        boolean is_one_present = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                is_one_present = true;
            }
            if(nums[i] <= 0) {
                nums[i] = 1;
            }
        }

        if (is_one_present == false) return 1 ;

        int[] store = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if((nums[i] <= nums.length) && (nums[i] > 0)) {
                store[nums[i] - 1] = -1;            
            }
        }
        nums[0] = -1;

        int missing_number = nums.length + 1; //for cases like nums = {1}

        for(int i=0; i<nums.length; i++) {
            if((store[i] != -1)) {
                missing_number = i + 1;
                break;
            } 
        }
        return missing_number;
    } 
    public static void main(String[] args){
        // int[] nums = {7,8,9,11,12};
        // int[] nums = {3,4,-1,1};
        // int[] nums = {1,2,0};
        // int[] nums = {1,2,6,3,5,4};
        int[] nums = {1};

        int missing_number = firstMissingPositive(nums);

        System.out.println("---missing_number---- : " + missing_number);   
    }

}