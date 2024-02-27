package com.app.medium;

public class SearchInASortedAndRotatedArrayLeetcode33 {
    private static int search(int[] nums, int target) {
        int pivotIndx = findPivot(nums);
        if(pivotIndx == 0)
            return search(nums, 0, nums.length - 1, target);
        else {
            int indx = -1;
            indx = search(nums, 0, pivotIndx - 1, target);
            if(indx != -1)
                return indx;
            indx = search(nums, pivotIndx, nums.length - 1, target);
            return indx;
        }

    }

    private static int search(int []nums, int start, int end, int target) {
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

    private static int findPivot(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(mid + 1 < n && nums[mid] > nums[mid + 1])
                return mid + 1;
            else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                return mid;
            else if(nums[start] <= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
