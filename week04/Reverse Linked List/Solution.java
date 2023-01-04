import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) N is length of LL
// MC: O(1)
class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode nxt = null;
        while(current != null) {
            nxt = current.next;
            current.next = previous;
            previous = current;
            current = nxt;
        }
        return previous;
    }
}
