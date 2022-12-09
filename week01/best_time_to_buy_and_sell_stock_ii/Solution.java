import java.util.*;
import java.io.*;
import java.math.*;

//O(n) time, O(1) space

class Solution {
    public static int maxProfit(int[] prices) {
        int min = 10001;
        int total_profit, max_profit;
        total_profit = max_profit = 0;

        for(int price : prices) {
            if((price - min) > max_profit) {
                max_profit = price - min;
            } else {
                min = price;
                total_profit += max_profit;
                max_profit = 0;
            }
        }

        if(max_profit != 0) {
            total_profit += max_profit;
        }
        return total_profit;
    }
    
    
    public static void main(String[] args){
        // int[] prices = { 7,1,5,3,6,4 };
        // int[] prices = { 1,2,3,4,5 };
        // int[] prices = { 7,6,4,3,1 };
        // int[] prices = { 6,1,3,2,4,7 };
        int[] prices = { 2,1,2,0,1 };
        // int[] prices = { 2,4,1 };
        int profit = maxProfit(prices);

        System.out.println("--profit--- : " + profit);
    }
}
