package com.app.medium;

import java.util.Arrays;

public class FirstAndLastElementInASortedArrayLeetcode34 {
    private static int[] searchRange(int[] nums, int target) {
        int leftIndx = findLeftMostOcc(nums, target);
        if(leftIndx == -1)
            return new int[]{-1, -1};
        int rightIndx = findRightMostOcc(nums, target);
        return new int[]{leftIndx, rightIndx};
    }

    private static int findLeftMostOcc(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = (n - 1);

        while(start <= end) {
            int mid =(start + end) >> 1;
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target))
                return mid;
            else if(nums[mid] >= target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    private static int findRightMostOcc(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = (n - 1);
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == target && (mid == n - 1 || nums[mid + 1] != target))
                return mid;
            else if(nums[mid] <= target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
