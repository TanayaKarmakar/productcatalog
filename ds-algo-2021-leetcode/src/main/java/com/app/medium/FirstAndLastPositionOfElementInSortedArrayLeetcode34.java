package com.app.medium;

import java.util.Arrays;

/**
 * @author t0k02w6 on 01/08/21
 * @project ds-algo-2021
 */
public class FirstAndLastPositionOfElementInSortedArrayLeetcode34 {
    private static int leftMostIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target))
                return mid;
            else if(nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int rightMostIndex(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] != target))
                return mid;
            else if(nums[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private static int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};
        if(nums.length == 1) {
            if(nums[0] != target)
                return new int[]{-1, -1};
            return new int[]{0,0};
        }
        int lIndx = leftMostIndex(nums, target);
        if(lIndx == -1)
            return new int[] {-1, -1};
        int rIndx = rightMostIndex(nums, target);
        return new int[]{lIndx, rIndx};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int []ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));

        target = 6;
        ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
