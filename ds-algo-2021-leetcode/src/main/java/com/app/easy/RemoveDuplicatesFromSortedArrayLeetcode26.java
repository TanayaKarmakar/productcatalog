package com.app.easy;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class RemoveDuplicatesFromSortedArrayLeetcode26 {
    private static int removeDuplicates(int[] nums) {
        int len = 1;
        int i = 0;
        while(i < nums.length) {
            int j = i + 1;
            while(j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if(j < nums.length) {
                nums[len++] = nums[j];
            }
            i = j;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int ans = removeDuplicates(nums);

        System.out.println(ans);
    }
}
