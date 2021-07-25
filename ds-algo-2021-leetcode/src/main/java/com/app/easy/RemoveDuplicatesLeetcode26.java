package com.app.easy;

/**
 * @author t0k02w6 on 25/07/21
 * @project ds-algo-2021
 */
public class RemoveDuplicatesLeetcode26 {
    private static int removeDuplicates(int[] nums) {
        if(nums.length <= 1)
            return nums.length;

        int len = 1;
        int curr = nums[0];
        for(int i = 0; i < nums.length;) {
            if(curr == nums[i])
                i++;
            else {
                nums[len++] = nums[i];
                curr = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int len = removeDuplicates(nums);

        for(int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");
        System.out.println();
    }
}
