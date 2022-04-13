package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 12/04/22
 * @project ds-algo-2021
 */
public class LongestConsecutiveSequenceLeetcode128 {
    private static int longestConsecutive(int[] nums) {
        if(nums.length <= 1)
            return nums.length;
        Map<Integer, Boolean> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, true);
        }

        int maxLen = 1;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int k = nums[i];
            int len = 0;
            while(map.containsKey(k) && map.get(k)) {
                map.put(k, false);
                k--;
                len++;
            }

            k = nums[i] + 1;
            while (map.containsKey(k) && map.get(k)) {
                map.put(k, false);
                k++;
                len++;
            }

            maxLen = Integer.max(maxLen, len);
        }
        return maxLen;
    }

    public static void main(String[] args) {

    }
}
