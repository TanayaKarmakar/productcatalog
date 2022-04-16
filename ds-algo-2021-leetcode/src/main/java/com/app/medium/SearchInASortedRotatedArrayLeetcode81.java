package com.app.medium;

/**
 * @author t0k02w6 on 14/04/22
 * @project ds-algo-2021
 */
public class SearchInASortedRotatedArrayLeetcode81 {
    private static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == target)
                return true;
            else if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
