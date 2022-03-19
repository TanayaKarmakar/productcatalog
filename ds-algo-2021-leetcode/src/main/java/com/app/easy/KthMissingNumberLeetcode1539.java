package com.app.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class KthMissingNumberLeetcode1539 {
    private static int missingNumber(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            int x = nums[mid] - (mid + 1);
            if(x < k)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start + k;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 2;
        int ans = missingNumber(nums, k);
        System.out.println(ans);
    }
}
