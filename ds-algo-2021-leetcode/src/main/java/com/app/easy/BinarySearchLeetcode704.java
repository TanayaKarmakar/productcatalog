package com.app.easy;

public class BinarySearchLeetcode704 {
    private static int search(int[] nums, int target) {
        int n = nums.length - 1;
        int start = 0;
        int end = n;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
