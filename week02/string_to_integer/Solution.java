import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static int myAtoi(String s) {
        s = s.trim();
        
        int index, num, sign;
        index = num = 0;
        sign = 1;
        int length = s.length();
        boolean is_neg, is_pos;
        is_pos = is_neg = false;
        
        if((s.charAt(index) == '-') && (index < length)) {
            is_neg = true;
            sign = -1;
            index++;
        } else if( (s.charAt(index) == '+') && (index < length) ) {
            is_pos = true;
            index++;
        }
        while((index < length) && (Character.isDigit(s.charAt(index)))) {
            int digit = Character.getNumericValue(s.charAt(index));
            if((num > (Integer.MAX_VALUE / 10)) || ((num == (Integer.MAX_VALUE / 10)) && (digit > (Integer.MAX_VALUE % 10)))) {
                return Integer.MAX_VALUE;
            }
            if((num < (Integer.MIN_VALUE / 10)) || ((num == (Integer.MIN_VALUE / 10)) && (digit > (Integer.MAX_VALUE % 10)))) {
                return Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            index++;
        }
        return num * sign;
        // int num = 0;
        // int sign = 1;
        // boolean is_digit, is_neg, is_pos;
        // is_pos = is_digit = is_neg = false;

        // for(int i=0; i<s.length(); i++) {
        //     if(is_digit == true && !Character.isDigit(s.charAt(i))) break;
        //     if (s.charAt(i) == '-') {
        //         if (is_digit == true) break;
        //         if (is_neg == true) break;
        //         is_neg = true;
        //         sign = -1;
        //         if((i > 0) && (s.charAt(i - 1) == '+')) break;
        //         continue;
        //     };
        //     if ((s.charAt(i) == '+') && (i > 0) && (s.charAt(i - 1) == '-')) break;

        //     if (s.charAt(i) == '+' && is_neg == false) {
        //         if(is_pos == true) return 0;
        //         is_pos = true;
        //         continue;
        //     }


        //     if(Character.isDigit(s.charAt(i))) {
        //         int digit = Character.getNumericValue(s.charAt(i));
                
        //         if ((num > Integer.MAX_VALUE / 10) || 
        //         (num == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {   

        //             return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        //         }
        //         if ((num < Integer.MIN_VALUE / 10) || 
        //         (num == Integer.MIN_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {   

        //             return Integer.MIN_VALUE;
        //         }

        //         num = num * 10 + digit * sign;
        //         is_digit = true;
        //         continue;
        //     } 
        //     break;
        // }
        
        // return num;
    }
    public static void main(String args[]) {
        String s = "+-12";
        String t = "cx";
        int digit = myAtoi(s);
        System.out.println("digit-----------:" + digit);
    }
}

