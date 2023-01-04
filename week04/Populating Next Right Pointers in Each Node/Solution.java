import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) N is length of LL
// MC: O(1)
class Solution {

    public Node connect(Node root) {
        if(root == null) {
            return root;
        }

        Node leftmost = root;
        while(leftmost.left != null){
            Node head = leftmost;

            while(head != null){
                head.left.next = head.right;
                if(head.next != null){
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
