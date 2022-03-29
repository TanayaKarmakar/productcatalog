package com.app.medium;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
public class PeakElementLeetcode162 {
    private static int findPeakElement(int[] nums) {
        if(nums.length == 1)
            return 0;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(isPeakElement(nums, mid))
                return mid;
            else if(mid - 1 >= 0 && nums[mid] < nums[mid - 1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static boolean isPeakElement(int[] nums, int mid) {
        if(mid == 0)
            return nums[mid] > nums[mid + 1];
        else if(mid == nums.length - 1)
            return nums[mid] > nums[mid - 1];
        else
            return (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2};

        int ans = findPeakElement(nums);

        System.out.println(ans);
    }
}
