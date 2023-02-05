package com.app.hard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;


/**
 * @author t0k02w6 on 28/01/23
 * @project ds-algo-2021
 */
public class SlidingWindowMaximumLeetcode239 {
  private static int[] maxSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    Deque<Integer> maxDq = new LinkedList<>();

    int[] result = new int[n - k + 1];
    for(int i = 0; i < k; i++) {
      while(!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[i])
        maxDq.pollLast();
      maxDq.addLast(i);
    }

    int j = 0;
    for(int i = k; i < n; i++) {
      result[j++] = nums[maxDq.peek()];

      while(!maxDq.isEmpty() && maxDq.peek() < (i - k + 1))
        maxDq.poll();
      while(!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[i])
        maxDq.pollLast();
      maxDq.addLast(i);
    }

    result[j++] = nums[maxDq.peek()];
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1,-1};
    int k = 1;
    int[] res = maxSlidingWindow(nums, k);

    System.out.println(Arrays.toString(res));
  }
}
