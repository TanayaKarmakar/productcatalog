package com.app.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequenceLeetcode128 {
    private static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], false);
        }

        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            int currLen = 0;
            int currItem = nums[i];
            while(map.containsKey(currItem) && !map.get(currItem)) {
                map.put(currItem, true);
                currItem++;
                currLen++;
            }

            currItem = nums[i] - 1;
            while(map.containsKey(currItem) && !map.get(currItem)) {
                map.put(currItem, true);
                currItem--;
                currLen++;
            }

            maxLen = Integer.max(maxLen, currLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};

        int ans = longestConsecutive(nums);

        System.out.println(ans);

        nums = new int[]{0,3,7,2,5,8,4,6,0,1};

        ans = longestConsecutive(nums);

        System.out.println(ans);
    }
}
