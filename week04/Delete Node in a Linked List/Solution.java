import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(1)
// MC: O(1)
class Solution {

    public void deleteNode(ListNode node) {        
        ListNode nextNode = node.next;
        node.next = nextNode.next;
        node.val = nextNode.val;
    }
}
