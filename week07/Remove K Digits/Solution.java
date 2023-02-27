import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(num.length * k) 
// MC: O(n)
class Solution {

    public static String removeKdigits(String num, int k) {
        Stack<Integer> my_stack = new Stack<Integer>();

        for(int i=0; i<num.length(); i++) {
            if(my_stack.size() == 1) && (my_stack.peek() == 0) my_stack.pop();
            int n = num.charAt(i) - 48;

            while(my_stack.size() > 0 && k > 0) {
                int peeked = my_stack.peek();
                if(peeked > n) {
                    my_stack.pop();
                    k--;
                } else break;
            }
            my_stack.add(n);
        }
        while(k > 0) {
            my_stack.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        String ansy = "";

        while(my_stack.size() > 0){
            int peeked = my_stack.peek();
            ansy = Integer.toString(peeked) + ansy;

            my_stack.pop();
        }

        if ansy == "" return 0;
        return ansy;
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        String ans = removeKdigits(num, k);
        System.out.println("-------------" + ans);
    }
 
}
