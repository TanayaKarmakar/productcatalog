package com.app.easy;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class SortArrayByParityLeetcode905 {
    private static int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int i = -1;
        for(int j = 0; j < n; j++) {
            if(nums[j] % 2 == 0) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
