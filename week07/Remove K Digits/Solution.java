import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(log 2(n)) 
// MC: O(1)
class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Integer> my_stack = new Stack<Integer>my_stack;


        int L = nums[0];
        int R = nums[nums.size - 1];
        while(R > L) {
            int mid = L + (R - L) / 2;
            if(nums[mid] < nums[mid + 1]) L = mid + 1;
            else R = M;
        }
        return L;  
    }

    public static void main(String[] args) {
    }
 
}
