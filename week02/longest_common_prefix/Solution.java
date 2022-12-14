import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        int end_index = 0;
        boolean matched = false; 
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        for(int i = 1; i<strs.length; i++) {
            String compare = strs[i];
            for(int j = 0; j<compare.length(); j++) {
                if(j >= prefix.length()) break;
                if(compare.charAt(j) == prefix.charAt(j)){
                    end_index = j;
                    matched true;
                    continue;
                }
                break;
            }
            prefix = compare.substring(0, end_index + 1);
        }
        if(matched == false) return "";
        return prefix;
    }
    public static void main(String args[]) {
        String[] strs = {"flower","flow","flight"};
        String answer = longestCommonPrefix(strs);
        System.out.println("answer-----------" + answer);
    }
}

