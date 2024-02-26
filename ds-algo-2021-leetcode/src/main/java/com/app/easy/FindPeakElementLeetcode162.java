package com.app.easy;

public class FindPeakElementLeetcode162 {
    private static int findPeakElement(int[] nums) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1)
            return 0;
        return findPeakHelper(nums, 0, nums.length - 1);
    }

    private static int findPeakHelper(int[] nums, int start, int end) {
        if(start > end)
            return -1;
        int mid = (start + end) >> 1;
        if(isPeak(nums, mid))
            return mid;
        if(mid - 1 >= 0 && nums[mid] < nums[mid - 1])
            return findPeakHelper(nums, start, mid - 1);
        else
            return findPeakHelper(nums, mid + 1, end);
    }

    private static boolean isPeak(int[] nums, int mid) {
        if(mid == 0)
            return nums[mid] > nums[mid + 1];
        else if(mid == nums.length - 1)
            return nums[mid] > nums[mid - 1];
        else
            return nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1];
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
        System.out.println(findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
