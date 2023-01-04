import java.util.*;
import java.io.*;
import java.math.*;

// TC: O(N)
// MC: O(N)

class Solution {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == ')') {
                if(stack.empty()) return false;
                if (stack.peek() != '(') break;
                stack.pop();
                continue;
            } else if(c == '}') {
                if(stack.empty()) return false;
                if (stack.peek() != '{') break;
                stack.pop();
                continue;
            } else if(c == ']') {
                if(stack.empty()) return false;
                if (stack.peek() != '[') break;
                stack.pop();
                continue;
            }
            stack.push(c);
        }       

        if(!stack.empty()) return false;

        return true;
    }
    public static void main(String args[]) {
        boolean is_valid = isValid("{[]}");
        System.out.println("is_valid-----------" + is_valid);
    }
}

