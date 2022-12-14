import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N*S) length of string array * each word length?
// MC: O(N)
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

    public static List<List<String>> groupAnagrams(String[] strs) {
        int[] hashed_indexes = new int[strs.length];
        HashMap<Long, List<String>> my_map = new HashMap<Long, List<String>>();
        for(int i=0; i<strs.length; i++) {
            long hash = getHash(strs[i]);
            if(my_map.containsKey(hash)){
                List list = my_map.get(hash);
                list.add(strs[i]);
                my_map.put(hash, list);
            } else {
                my_map.put(hash, new ArrayList<>(Arrays.asList(strs[i])));
            }
        }
        return new ArrayList(my_map.values());
    }
    public static void main(String args[]) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> anagrams = groupAnagrams(s);
    }
}

