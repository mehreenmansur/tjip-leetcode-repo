import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N) length of LL
// MC: O(1) no extra space needed copy inside original list
class Solution {

    public Node copyRandomList(Node head) {
        if(head == null) return null;

        //copy new node adjuscent next to each original node
        Node root = head;
        while(head != null) {
            Node copyNode = new Node(head.val);
            Node nextHead = head.next;
            head.next = copyNode;
            copyNode.next = nextHead;
            head = nextHead;     
        }

        //copy each original random to new node random
        head = root;
        while(head != null) {
            head.next.random = head.random;
            head = head.next.next;
        }

        //detach 2 linked lists
        head = root;
        Node rootCopyNode = head.next;
        Node copyNode = head.next;
        while((head.next != null) && (head.next.next != null)) { 
            head.next = head.next.next;
            copyNode.next = head.next.next;
            head = head.next;
            copyNode = head.next;
        }
        head.next = null;
        copyNode.next = null;

        return rootCopyNode; 
    }
}
