package com.app.easy;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class SearchInsertPositionLeetcode35 {
    private static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        int ans = searchInsert(nums, target);

        System.out.println(ans);
    }
}
