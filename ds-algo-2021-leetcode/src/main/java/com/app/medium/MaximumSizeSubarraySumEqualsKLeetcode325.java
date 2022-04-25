package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 23/04/22
 * @project ds-algo-2021
 */
public class MaximumSizeSubarraySumEqualsKLeetcode325 {
    private static int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if(prefixSum == k)
                res = i + 1;
            if(map.containsKey(prefixSum - k))
                res = Integer.max(res, i - map.get(prefixSum - k));
            if(!map.containsKey(prefixSum))
                map.put(prefixSum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1};
        int k = -1;

        int ans = maxSubArrayLen(nums, k);

        System.out.println(ans);
    }
}
