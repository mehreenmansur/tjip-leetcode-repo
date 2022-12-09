class Solution {
    public static int singleNumber(int[] nums) {
        int answer = 0;
        for (int i : nums) {
            answer ^= i;
        }
        return answer;
    } 
    public static void main(String[] args){
        int[] nums = {1};

        int answer = singleNumber(nums);
        System.out.println("------- : " + answer);
    }

}