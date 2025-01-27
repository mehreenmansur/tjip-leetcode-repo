import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(S+W)
// MC: O(N)
class Solution {
    public static boolean isSubSeq(String s, List<List<Integer>> list) {
        int last_index = -1;
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            int key = s.charAt(i) - 'a';
            List<Integer> bs_list = list.get(key);
            if(bs_list.size() == 0) return false;
            int start = 0, end = bs_list.size() ;
   
            while (start < end) {
                int mid = (start + end) / 2;
                // Move to left side if target is greater
                if (bs_list.get(mid) > last_index) {
                    end = mid;
                }
                else {
                    start = mid + 1;
                }
            }
            if (start == bs_list.size()) {
                return false;   
            } else {
                last_index = bs_list.get(start);
                count++;
            }

        }
        if (count == s.length()) return true;
        return false;
    }
    public static int numMatchingSubseq(String s, String[] words) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<27; i++) {
            list.add(new ArrayList<Integer>());
        }


        for(int i=0; i<s.length(); i++) {
            int key = s.charAt(i) - 'a';
            list.get(key).add(i);
        }
        
        int sub_seq_count = 0;
        for(String word : words) {
            sub_seq_count += isSubSeq(word, list) ? 1 : 0;
        }


        return sub_seq_count;

    }

   public static void main(String args[]) {
        String[] s = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        // String[] s = {"a","bb","acd","ace"};
        int count = numMatchingSubseq("dsahjpjauf", s);
        System.out.println(" count----" + count);

    }
}

