package com.app.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class LongestContinuousSubarrayWithAbsoluteDifferenceLessThanOrEqualToLimitLeetcode1438 {
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

      int diff = maxD.peekFirst() - minD.peekFirst();
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
    int[] nums = {8,2,7,4};
    int limit = 4;
    int ans = longestSubarray(nums, limit);

    System.out.println(ans);
  }
}
