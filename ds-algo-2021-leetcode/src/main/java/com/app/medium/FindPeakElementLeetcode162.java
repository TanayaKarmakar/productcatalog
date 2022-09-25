package com.app.medium;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class FindPeakElementLeetcode162 {
    private static int findPeakElement(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(isPeak(nums, mid, n))
                return mid;
            else if(nums[mid] < nums[mid - 1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static boolean isPeak(int[] nums, int mid, int n) {
        if(mid == 0)
            return nums[mid] > nums[mid + 1];
        else if(mid == n - 1)
            return nums[mid] > nums[mid - 1];
        else
            return nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1];
    }

    public static void main(String[] args) {

    }
}
