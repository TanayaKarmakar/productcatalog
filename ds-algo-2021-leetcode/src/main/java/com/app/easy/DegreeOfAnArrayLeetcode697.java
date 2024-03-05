package com.app.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArrayLeetcode697 {
    private static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> freqMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!freqMap.containsKey(nums[i])) {
                freqMap.put(nums[i], new ArrayList<>());
            }
            freqMap.get(nums[i]).add(i);
        }

        int deg = 0;
        for(Map.Entry<Integer, List<Integer>> entry: freqMap.entrySet()) {
            deg = Integer.max(deg, entry.getValue().size());
        }

        int minLen = nums.length;
        for(Map.Entry<Integer, List<Integer>> entry: freqMap.entrySet()) {
            if(entry.getValue().size() == deg) {
                int firstEntry = entry.getValue().get(0);
                int lastEntry = entry.getValue().get(entry.getValue().size() - 1);
                minLen = Integer.min(minLen, (lastEntry - firstEntry + 1));
            }
        }
        return minLen;
    }

    public static void main(String[] args) {

    }
}
