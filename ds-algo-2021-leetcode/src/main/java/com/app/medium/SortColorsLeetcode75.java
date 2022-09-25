package com.app.medium;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class SortColorsLeetcode75 {
    private static void sortColors(int[] nums) {
        if(nums.length <= 1)
            return;
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while(mid <= high) {
            int num = nums[mid];
            switch (num) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    continue;
                case 1:
                    mid++;
                    continue;
                case 2:
                    swap(nums, mid, high);
                    high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {

    }
}
