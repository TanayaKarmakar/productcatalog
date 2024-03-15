package com.app.medium;

public class FindMinimumInSortedAndRotatedArrayLeetcode153 {
    private static int findMin(int[] nums) {
        int maxIndx = findMaxHelper(nums);
        return nums[maxIndx + 1];
    }

    private static int findMaxHelper(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = (n - 1);

        while(start <= end) {
            int mid = (start + end) >> 1;
            if(mid + 1 < n && nums[mid] > nums[mid + 1])
                return mid;
            else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                return (mid - 1);
            else if(nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
