import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(S * maxlen of stack) length of string array ??
// MC: O(N)

public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
     public static void main(String args[]) {
       
    }
 }

class Solution {
    public static int maxDepth(TreeNode root) {        
        if (root == null) {
          return 0;
        } else {
          int left = maxDepth(root.left);
          int right = maxDepth(root.right);
          return Math.max(left, right) + 1;
        }
    }

    
    public static void main(String args[]) {
        int root = {3,9,20,null,null,15,7};
        int ans = maxDepth(root);
        System.out.println("----s----" + ans);
    }
}
