import java.util.*;
import java.io.*;
import java.math.*;

class Solution { //O(1) time & space
    
    public static int trap(int[] height) {
        int left_pointer = 0;
        int right_pointer = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        int water = 0;

        while(left_pointer < right_pointer) {
            if(height[right_pointer] > height[left_pointer]) {

                if(left_max <= height[left_pointer]) {
                    
                    left_max = height[left_pointer];
                } else {
                    water += (left_max - height[left_pointer]);
                }
                left_pointer++;
            } else {
                if(right_max <= height[right_pointer]) {
                    right_max = height[right_pointer];
                } else {
                    water += (right_max - height[right_pointer]);
                }
                right_pointer--;
            }
        }
        return water;
    }


    public static void main(String[] args){
        
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int water_unit = trap(height);
        System.out.println("----answer--- : " + water_unit);
    }
}
