package com.app.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author t0k02w6 on 18/04/22
 * @project ds-algo-2021
 */
public class MaximumContiguousSubarrayAbsoluteDiffLessThanEqualToLimitLeetcode1438 {
    private static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxD = new LinkedList<>();
        Deque<Integer> minD = new LinkedList<>();
        int i = 0;
        int j = 0;
        int n = nums.length;

        for(i = 0; i < n; i++) {
            while(!maxD.isEmpty() && maxD.peekLast() < nums[i])
                maxD.pollLast();
            while(!minD.isEmpty() && minD.peekLast() > nums[i])
                minD.pollLast();

            maxD.addLast(nums[i]);
            minD.addLast(nums[i]);

            int diff = Math.abs(maxD.peek() - minD.peek());
            if(diff > limit) {
                if(maxD.peek() == nums[j])
                    maxD.poll();
                if(minD.peek() == nums[j])
                    minD.poll();
                j++;
            }
        }
        return (i - j);
    }

    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        int limit = 4;

        int ans = longestSubarray(nums, limit);

        System.out.println(ans);
    }
}
