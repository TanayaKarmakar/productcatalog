package com.app.medium;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class KthLargestElementInTheArrayLeetcode215 {
    private static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = (n - k);
        return kThLargestRec(nums, k, 0, n - 1);
    }

    private static int kThLargestRec(int[] nums, int k, int start, int end) {
//        if(start == end)
//            return nums[start];
//        if(start > end)
//            return -1;
        int pivot = findPivot(nums, start, end);
        if(pivot > k)
            return kThLargestRec(nums, k, start, pivot - 1);
        else if(pivot < k)
            return kThLargestRec(nums, k, pivot + 1, end);
        return nums[pivot];
    }

    private static int findPivot(int[] nums, int start, int end) {
        int i = start - 1;
        int pivot = nums[end];
        for(int j = start; j <= end - 1; j++) {
            if(nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, end);
        return (i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int ans = findKthLargest(nums, k);

        System.out.println(ans);
    }
}
