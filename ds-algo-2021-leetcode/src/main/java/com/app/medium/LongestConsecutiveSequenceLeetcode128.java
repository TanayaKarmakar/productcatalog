package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 20/09/22
 * @project ds-algo-2021-leetcode
 */
public class LongestConsecutiveSequenceLeetcode128 {
    private static int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], false);
        }

        int maxLen = 1;
        for(int i = 0; i < nums.length; i++) {
            int k = nums[i];
            int count = 0;
            while(map.containsKey(k) && !map.get(k)) {
                map.put(k, true);
                count++;
                k--;
            }
            k = nums[i] + 1;
            while(map.containsKey(k) && !map.get(k)) {
                map.put(k, true);
                count++;
                k++;
            }
            maxLen = Integer.max(maxLen, count);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int ans = longestConsecutive(nums);

        System.out.println(ans);
    }
}
