package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class SubarraySumEqualsKLeetcode560 {
    private static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int preSum = 0;

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            if(map.containsKey(preSum - k))
                count += map.get(preSum - k);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
