package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class RemoveElementLeetcode27 {
    private static int removeElement(int[] nums, int val) {
        int i = -1;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;

        int ans = removeElement(nums, val);

        System.out.println(ans);
    }
}
