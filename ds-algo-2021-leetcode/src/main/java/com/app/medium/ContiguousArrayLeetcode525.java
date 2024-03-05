package com.app.medium;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayLeetcode525 {
    private static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int maxlen = 0;
        int preSum = 0;
        for(int i = 0; i < nums.length; i++) {
            preSum += (nums[i] == 0 ? -1: nums[i]);
            if(preSum == 0) {
                maxlen = (i + 1);
            }
            if(map.containsKey(preSum)) {
                maxlen = Integer.max(maxlen, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,1,0,1,0,1,0,1,1,0,0};
        int ans = findMaxLength(nums);

        System.out.println(ans);
    }
}
