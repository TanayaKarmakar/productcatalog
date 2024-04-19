package com.app.medium;

import java.util.TreeMap;

public class DivideArrayIntoSetOfKConsecutiveNumbersLeetcode1296 {
    private static boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();

        for(int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        while(!freqMap.isEmpty()) {
            int start = freqMap.firstKey();

            for(int num = start; num < (start + k); num++) {
                if(!freqMap.containsKey(num))
                    return false;
                int value = freqMap.get(num);
                value--;
                if(value == 0) {
                    freqMap.remove(num);
                    continue;
                }
                freqMap.put(num, value);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,2,3,4,3,4,5,9,10,11};
        int k = 3;
        boolean ans = isPossibleDivide(nums, k);

        System.out.println(ans);
    }
}
