class Solution {

    // O(n) time, O(1) space

    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        int min = 1000009;

        for(int price : prices) {
            if(price < min) {
                min = price;
            } else if((price - min) > max_profit) {
                max_profit = price - min;
            }
        }

        return max_profit;  
    } 
    public static void main(String[] args){
        // int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};

        int max_profit = maxProfit(prices);
        System.out.println("---max_profit---- : " + max_profit);
    }
}