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
    public static int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> myhash = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(!myhash.containsKey(target - nums[i])){
                myhash.put(nums[i], i);
            } else {
                ans[0] = i;
                ans[1] = myhash.get(target - nums[i]);
                break;
            }
        }
        return ans;
    }
    public static void main(String args[]) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] answer = twoSum(nums, target);
        // List<List<Integer>> answer = threeSum(new int[] {-1,0,1,2,-1,-4});
        // List<List<Integer>> answer = threeSum(new int[] {});
        System.out.println("answer-----------" + answer[0]);
        System.out.println("answer-----------" + answer[1]);
    }
}

