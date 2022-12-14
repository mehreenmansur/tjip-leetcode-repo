import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N+M)
// MC: O(1)
class Solution {
    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        int first = 0;
        int second = 0;
        int third = 0;
        boolean is_found = false;
        while(second < haystack.length()) {
            if(haystack.charAt(second) == needle.charAt(third)) {
                if(third == (needle.length() - 1)) return first;
                second++;
                third++; 
            } else if(haystack.charAt(second) != needle.charAt(third)){
                first++;
                second = first;
                third = 0;
            }
        }
        if(is_found == false) return -1;
        return first;     
    }

    public static void main(String[] args){
        // String haystack = "sadbutsad";
        // String needle = "sad";
        String haystack = "mississippi";
        String needle = "issip";
        int index = strStr(haystack, needle);

        System.out.println("---index---- : " + index);    
    }

}