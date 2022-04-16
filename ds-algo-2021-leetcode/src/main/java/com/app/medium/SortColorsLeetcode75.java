package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 14/04/22
 * @project ds-algo-2021
 */
public class SortColorsLeetcode75 {
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            int el = nums[mid];

            switch (el) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high);
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1};

        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }
}
