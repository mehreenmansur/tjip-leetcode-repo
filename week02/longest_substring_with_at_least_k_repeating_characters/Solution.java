import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(S*K)
// MC: O(N)
class Solution {
    public static int findLongestSubstring(String s, int k, int uniqCharThreshold) {
        int L, R, max_len, uniqCharInWindow, countCharFreqK;
        L = R = max_len = uniqCharInWindow = countCharFreqK = 0;
        int[] ascii_freq = new int[123];
        
        while(R < s.length()){
            ascii_freq[s.charAt(R)]++;
            if(ascii_freq[s.charAt(R)] == 1) uniqCharInWindow++;
            if(ascii_freq[s.charAt(R)] == k) countCharFreqK++;
            R++;
            
            while(uniqCharInWindow > uniqCharThreshold){
                ascii_freq[s.charAt(L)]--;
                if(ascii_freq[s.charAt(L)] == 0) uniqCharInWindow--;
                if(ascii_freq[s.charAt(L)] == (k - 1)) countCharFreqK--;
                L++;
            }
            if(uniqCharInWindow == countCharFreqK) {
                max_len = Math.max(max_len, R - L);
            }
        }
        return max_len;
    }

    public static int longestSubstring(String s, int k) {
        int max_len = 0;

        for(int uniqChar = 1; uniqChar <=26; uniqChar++) {
            max_len = Math.max(max_len, findLongestSubstring(s, k, uniqChar));
        }

        return max_len;
    }
   public static void main(String args[]) {
        // String s = "aaabb";
        int count = longestSubstring("ababbc", 2);
        System.out.println(" count----" + count);

    }
}

