package com.app.medium;

/**
 * @author t0k02w6 on 01/08/21
 * @project ds-algo-2021
 */
public class SearchInASortedAndRotatedArrayLeetcode33 {
    private static int findSmallestElement(int[] nums) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;


        while(start <= end) {
            int mid = (start + end) >> 1;
            if(mid + 1 < n && nums[mid] > nums[mid + 1])
                return mid;
            else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid])
                return (mid - 1);
            else if(nums[start] <= nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
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


    private static int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;
        if(nums.length == 1) {
            if(nums[0] != target)
                return -1;
            return 0;
        }
        int indx = findSmallestElement(nums);
        if(indx == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            if (target >= nums[0] && target <= nums[indx])
                return binarySearch(nums, 0, indx, target);
            else
                return binarySearch(nums, indx + 1, nums.length - 1, target);
        }
    }



    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;

        int ans = search(nums,target);
        System.out.println(ans);

        target = 3;
        ans = search(nums,target);
        System.out.println(ans);
    }
}
