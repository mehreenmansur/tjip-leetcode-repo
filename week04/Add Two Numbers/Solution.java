import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(m)/O(n) maximum length of the max LL
// MC: O(m)/O(n)
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode rootNewNode = newNode;
        int carry = 0;

        while((l1 != null) || (l2 != null) || (carry != 0)){
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;
            int sum = carry + first + second;
            carry = sum / 10;
            newNode.next = new ListNode(sum % 10);
            newNode = newNode.next;
            if(l1 != null) {
                l1 = l1.next;    
            }
            if(l2 != null) {
                l2 = l2.next;    
            }
        }

        return rootNewNode.next;
    }
}
