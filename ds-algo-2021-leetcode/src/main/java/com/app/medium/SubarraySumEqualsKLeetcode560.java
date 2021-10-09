package com.app.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 06/10/21
 * @project ds-algo-2021
 */
public class SubarraySumEqualsKLeetcode560 {
    public static int subarraySum(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for(int num: nums) {
            sum += num;
            if(map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};

        int count = subarraySum(nums, 2);
        System.out.println(count);
    }
}
