import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static int strStr(String haystack, String needle) {

        
        int index = -1;
        int count = 0;
        int starting_index = 0;
        int target_length = needle.length();
        if(needle.length() > haystack.length()) return index;
        for(int i = 0; i< haystack.length(); i++) {
            if(count > 0 && (needle.charAt(starting_index) != haystack.charAt(i))) {
                count = 0;
                starting_index = 0;
                // index = -1;
                // break;
            }
            if(needle.charAt(starting_index) == haystack.charAt(i)){
                if(count == 0) {
                    index = i;
                }
                starting_index++;
                count++;
            }
            if(count == target_length) break;
        }
        if(count != target_length) {
            return -1;
        }
        return index;
    }

    public static void main(String[] args){
        // String haystack = "sadbutsad";
        // String needle = "sad";
        // String haystack = "leetcode";
        // String needle = "leeto";
        // String haystack = "hello";
        // String needle = "ll";
        String haystack = "mississippi";
        String needle = "issip";
        int index = strStr(haystack, needle);

        System.out.println("---index---- : " + index);    
    }

}