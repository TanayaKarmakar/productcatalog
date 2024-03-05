package com.app.medium;

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayWithAbsDiffLessThanOrEqualToLimitLeetcode1438 {
    private static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();
        int j = 0;
        int i = 0;
        for(i = 0; i < nums.length; i++) {
            while(!maxD.isEmpty() && maxD.peekLast() < nums[i]) {
                maxD.pollLast();
            }

            while(!minD.isEmpty() && minD.peekLast() > nums[i]) {
                minD.pollLast();
            }

            maxD.addLast(nums[i]);
            minD.addLast(nums[i]);

            int diff = maxD.peek() - minD.peek();
            if(diff > limit) {
                if(nums[j] == maxD.peek())
                    maxD.pollFirst();
                if(nums[j] == minD.peek())
                    minD.pollFirst();
                j++;
            }
        }
        return (i - j);
    }

    public static void main(String[] args) {

    }
}
