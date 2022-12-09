class Solution {

    //O(n) time & O(1) space
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // suggest better naming of pointers?
        int first_pointer = m - 1;
        int second_pointer = n - 1;

        if(nums2.length == 0) return;

        for(int i = m + n - 1; i >= 0; i--) {
            if(second_pointer < 0) break;

            if(first_pointer >= 0 && (nums1[first_pointer] > nums2[second_pointer])) {
                nums1[i] = nums1[first_pointer];
                first_pointer--;
            } else  {
                nums1[i] = nums2[second_pointer];
                second_pointer--;
            }
        }

        for(int i : nums1) {
            System.out.println("---i---- : " + i);
        }

    }
        
    public static void main(String[] args){

        // int[] nums1 = {1,2,3,0,0,0};
        // int m = 3;
        // int[] nums2 = {2,5,6};
        // int n = 3;

        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        // int[] nums = {0};

        merge(nums1, m, nums2, n);  
    }

}