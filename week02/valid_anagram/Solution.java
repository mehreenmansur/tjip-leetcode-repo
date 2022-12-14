import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    // public static List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> answers = new ArrayList<>();
    //     int count = 0;
    //     for (int i = 0; i< nums.length; i++) {
    //         int a = nums[i];
            
    //     }

    //     Hashtable<Integer, Integer> hash = new Hashtable<>();
    //     for (int i = 0; i< nums.length; i++) {
    //         int fixed = nums[i];
    //         // int sum =
    //         for (int j = 0; j < nums.length; j++) {
    //             System.out.println("j----" + j);
    //             int remaining = - (fixed + nums[j]);
    //             if(i!=j && !hash.isEmpty() && hash.containsValue(remaining)){
    //                 System.out.println(" ");
    //                 System.out.println("IF");
    //                 // System.out.println("i----" + i);
    //                 // System.out.println("j----" + j);
    //                 // System.out.println("remaining----" + remaining);
    //                 // System.out.println("hash.get(remaining)----" + hash.get(remaining));
    //                 System.out.println(hash.get(remaining));
    //                 List<Integer> list = new ArrayList<Integer>();
    //                 int a = fixed;
    //                 int b = nums[j];
    //                 int c = remaining;
    //                 int max = (a > b && a > c) ? a : (b > a && b > c) ? b : c;
    //                 int min = (a < b && a < c) ? a : (b < a && b < c) ? b : c;
    //                 int middle = (min != a && max != a) ? a : (min != b && max != b) ? b : c;
    //                 list.add(min);
    //                 list.add(middle);
    //                 list.add(max);
    //                 if(!answers.contains(list)){
    //                     answers.add(list);
    //                 }
    //                 count += 1;
                    
    //             } else if(!hash.containsValue(j)) {
    //                 System.out.println("else if");
    //                 System.out.println("nums[j] ----:" + nums[j]);
    //                 System.out.println("j ----:" + j);
    //                 hash.put(j, nums[j]);
    //                 System.out.println("Initial Table is: " + hash);

    //               // }
    //             }
             
    //         }
    //     }
    //     return answers;
    
    // }
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

