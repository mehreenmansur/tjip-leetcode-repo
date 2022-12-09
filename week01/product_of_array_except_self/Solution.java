import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    // O(n) time O(n) space
    public static int[] productExceptSelf(int[] nums) {        
        int[] pre_fix = new int[nums.length];
        int[] post_fix = new int[nums.length];
        int[] answer = new int[nums.length];
        int pre_fix_product = 1;
        int post_fix_product = 1;
        int index = nums.length - 1;

        for(int i = 0; i<nums.length; i++) {
            pre_fix_product *= nums[i];
            pre_fix[i] = pre_fix_product;

            post_fix_product *= nums[index];
            post_fix[index] = post_fix_product;

            index--;
        }

        for(int i = 0; i<nums.length; i++) {
            if(i==0) {
                answer[i] = post_fix[i + 1];
            } else if(i == (nums.length - 1)) {
                answer[i] = pre_fix[i - 1];
            } else {
                answer[i] = pre_fix[i - 1] * post_fix[i + 1];
            }
        }
        return answer;
    }

    // O(n) time O(1) space
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int[] prefix_products = new int[nums.length];
        prefix_products[0] = 1;

        for(int i=1; i<nums.length; i++) { 
            product *= nums[i - 1];
            prefix_products[i] = product;
        }

        product = 1;
        for(int i = nums.length - 1; i>=0; i--) {
            prefix_products[i] *= product ;
            product *= nums[i];
        }
        return prefix_products;

    }
   
    public static void main(String[] args){
        // int[] nums = {1,2,3,4};
        int[] nums = {-1,1,0,-3,3};

        int[] answer = productExceptSelf(nums);

        for(int i = 0; i<nums.length; i++) {
            System.out.println("---i---- : " + answer[i]);
        }
    }
}