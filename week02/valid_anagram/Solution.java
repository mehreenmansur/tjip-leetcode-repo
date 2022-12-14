import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static int BASE = 997;
    public static long MOD = 101103107109113L;


    public static long getHash(String s) {
        long mul = 1;

        for(int i = 0; i<s.length(); i++) {
            mul *= (s.charAt(i) + BASE);
            if( mul >= MOD ) mul %= MOD;
        }
        return mul;

    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        if(getHash(s) == getHash(t)) return true;
        return false;
    }
    public static void main(String args[]) {
        String s = "nl";
        String t = "cx";
        boolean is_anagram = isAnagram(s, t);
        System.out.println("is_anagram-----------" + is_anagram);
    }
}

