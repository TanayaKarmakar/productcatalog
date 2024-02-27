package com.app.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximumLeetcode239 {
    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> maxD = new LinkedList<>();

        for(int i = 0; i < k; i++) {
            while(!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i])
                maxD.pollLast();
            maxD.addLast(i);
        }
        int j = 0;

        for(int i = k; i < n; i++) {
            result[j++] = nums[maxD.peek()];

            while(!maxD.isEmpty() && maxD.peek() < (i - k + 1)) {
                maxD.poll();
            }

            while(!maxD.isEmpty() && nums[maxD.peekLast()] < nums[i]) {
                maxD.pollLast();
            }
            maxD.addLast(i);
        }
        result[j++] = nums[maxD.peek()];
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.println(Arrays.toString(result));
    }
}
