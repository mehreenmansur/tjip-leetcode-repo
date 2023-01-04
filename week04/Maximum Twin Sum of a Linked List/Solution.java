import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) N is length of the linked-list
// MC: O(N)
class Solution {

    public int pairSum(ListNode head) { 
        ListNode this_head = head;
        Stack<Integer> stack = new Stack<Integer>();  
        int max, count;
        max = count = 0;

        while(head != null) {
            stack.push(head.val);
            head = head.next;
            count++;
        }
        while(count>0) {
            int first = this_head.val;
            int last = stack.peek();
            stack.pop();
            this_head = this_head.next;
            if((first + last) > max){
                max = first + last;
            }
            count -= 2;
        }
        return max;
    }
}
