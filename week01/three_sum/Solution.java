import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

     // (nlogn + O(n^2)) ~ O(n^2) time, O(n) space
     public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> three_sum_list = new ArrayList<>();

        for(int j=0; j<nums.length; j++) {
            if (nums[j] > 0) break;
            int first_num = nums[j];
            if(j > 0){
                if(nums[j -1] == nums[j]) continue;    
            }
            int pointer_two_index = nums.length - 1;
            int pointer_one_index = j + 1;

            while(pointer_one_index < pointer_two_index) {
                
                int pointer_one = nums[pointer_one_index];
                int pointer_two = nums[pointer_two_index];
                if((pointer_one + pointer_two + first_num) < 0) {
                    pointer_one_index++;
                }
                if((pointer_one + pointer_two + first_num) > 0) {
                    pointer_two_index--;
                }
                if((pointer_one + pointer_two + first_num) == 0) {
                    
                    List<Integer> list = Arrays.asList(first_num, pointer_one, pointer_two);
                    three_sum_list.add(list);
                    pointer_one_index++;
                    pointer_two_index--;
                    while ((pointer_one_index < pointer_two_index) && (nums[pointer_one_index] == nums[pointer_one_index - 1])) pointer_one_index++;
                }
            }
        }
        return three_sum_list;
    }
    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};

        List<List<Integer>> answer = threeSum(nums);
        System.out.println("------- : " + answer);
    }

}