class Solution {
    public static boolean has_zero = false; 
    public static int pointZero(int[] nums, int pointer){
        for (int i = pointer; i<nums.length; i++) {
            if(nums[i] == 0) {
                has_zero = true;
                pointer = i;
                break;
            }
        }
        return pointer;
    }

    public static void moveZeroes(int[] nums) {
        int pointer = pointZero(nums, 0);
        if(has_zero == false) {
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0 && i > pointer) {
                nums[pointer] = nums[i];
                nums[i] = 0;
                pointer = pointZero(nums, pointer + 1);
            }
        }

    } 
    public static void main(String[] args){
        // int[] nums = {0,1,0,3,12};
        // int[] nums = {2,1};
        int[] nums = {0};

        moveZeroes(nums);

        for (int i = 0; i < nums.length; i++){
            System.out.println("------- : " + nums[i]);
        }    
    }

}