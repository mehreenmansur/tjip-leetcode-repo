import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    // O(n) time O(n) space for HashSet

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i : nums) {
            set.add(i);
        }

        int longest_seq = 0;

        for(int i : set) {
            if(!set.contains(num - 1)) { //check if its the starting num so that rest of the nums are not counted / for TLE
                int num = i;
                
                crnt_max_len++;

                while(set.contains(num + 1)) {
                    num += 1;
                    crnt_max_len++;
                }
            }
            longest_seq = Math.max(longest_seq, crnt_max_len);
        }        

        return longest_seq;

    } 
    public static void main(String[] args){
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        // int[] nums = {100,4,200,1,3,2};

        int longest_seq = longestConsecutive(nums);

        System.out.println("---longest_seq---- : " + longest_seq);   
    }

}