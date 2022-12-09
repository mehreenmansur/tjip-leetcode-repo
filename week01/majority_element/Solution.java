class Solution {

    public static int majorityElement(int[] nums) {
        int vote, candidate;
        vote = candidate = 0;

        for(int i : nums) {
            if(vote == 0) {
                candidate = i;
                vote++;
                continue;
            }
            if(candidate == i){
                vote++;
            } else{
                vote--;
            }
        }
        return candidate;
    } 
    public static void main(String[] args){
        int[] nums = {3,2,3};

        int ans = majorityElement(nums);
        System.out.println("---ans---- : " + ans);  
    }

}