import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(S * maxlen of stack) length of string array ??
// MC: O(N)
class Solution {

    public static Stack<Character> my_stack = new Stack<Character>();
    public static String concat_string = "";

    public static void decode() {        
        int times = 0;
        String new_word = "";
        while(!my_stack.empty()){
            if(my_stack.peek() != '[') {
                new_word += my_stack.peek();
                my_stack.pop();
            } else {
                my_stack.pop();
                String num = "";
                while((!my_stack.empty()) && (Character.isDigit(my_stack.peek())) ){
                    num = my_stack.peek() + num;
                    my_stack.pop();
                }

                times = Integer.parseInt(num);
                break;
            }
        }
        
        new_word = new_word.repeat(times);

        for(int i=(new_word.length() - 1); i >=0; i--) {
            my_stack.push(new_word.charAt(i));
        }
    }

    public static String decodeString(String strs) {
        for(int i=0; i<strs.length(); i++) {
            if(strs.charAt(i) == ']') {
                decode();
                continue;
            }
            my_stack.push(strs.charAt(i));
        }
        while(!my_stack.empty()) {
            concat_string = my_stack.peek() + concat_string;
            my_stack.pop();
        }
        return concat_string;
    }
    public static void main(String args[]) {
        // String s = "3[a]2[bc]";
        // String s = "2[abc]3[cd]ef";
        String s = "100[leetcode]";
        String ans = decodeString(s);
        System.out.println("----s----" + ans);
    }
}
