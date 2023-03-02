import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) depth level of the root 
// MC: O(1)
class Solution {
    public static class TreeNode {
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
    }
    public static int max_sum = Integer.MIN_VALUE;
    public static int find_max_chain_sum(TreeNode root) {
        if (root == null) return 0;
        int left = find_max_chain_sum(root.left);
        int right = find_max_chain_sum(root.right);
        max_sum = Math.max(max_sum, (left + right + root.val));

        return Math.max(0, (Math.max(left, right) + root.val));
    }

    public static int maxPathSum(TreeNode root) {
        find_max_chain_sum(root);
        return max_sum;
    }
    public static void main(String args[]) {
        int root = {-10,9,20,null,null,15,7};
        int ans = find_max_chain_sum(root);
        System.out.println("----s----" + ans);
    }
}
