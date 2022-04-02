package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 29/03/22
 * @project ds-algo-2021
 */
public class ContiguousArrayLeetcode525 {
    private static int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }
        int max = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if(prefixSum == 0)
                max = (i + 1);
            if(map.containsKey(prefixSum))
                max = Integer.max(max, i - map.get(prefixSum) + 1);
            else
                map.put(prefixSum, i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,1};

        int ans = findMaxLength(nums);

        System.out.println(ans);
    }
}
