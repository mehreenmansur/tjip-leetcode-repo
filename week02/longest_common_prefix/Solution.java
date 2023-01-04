import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(S) sum of length of all words
// MC: O(1)
class Solution {
    
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for(int i=0; i<prefix.length(); i++) {
            for(int j=1; j<strs.length; j++) {
                if((i == strs[j].length()) || (strs[j].charAt(i) != prefix.charAt(i))) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }
    public static void main(String args[]) {
        // String[] strs = {"flower","flow","flight"};
        String[] strs = {};
        String answer = longestCommonPrefix(strs);
        System.out.println("answer-----------" + answer);
    }
}

