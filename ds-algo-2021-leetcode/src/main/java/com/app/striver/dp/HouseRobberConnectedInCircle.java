package com.app.striver.dp;

import java.util.Arrays;

/**
 * @author t0k02w6 on 06/08/23
 * @project ds-algo-2021-leetcode
 */
public class HouseRobberConnectedInCircle {
  private static long getMaxMoney(int[] nums) {
    int n = nums.length;
    int prev2 = nums[0];
    int prev = Integer.max(nums[0], nums[1]);

    for(int i = 2; i < n; i++) {
      int current = Integer.max(prev, prev2 + nums[i]);
      prev2 = prev;
      prev = current;
    }
    return prev;
  }

  private static long maxMoney(int[] nums) {
    int n = nums.length;

    int[] temp1 = new int[n];
    int[] temp2 = new int[n];

    for(int i = 0; i < n; i++) {
      if(i != 0)
        temp1[i] = nums[i];
      if(i != n - 1)
        temp2[i] = nums[i];
    }
    return Long.max(getMaxMoney(temp1), getMaxMoney(temp2));
  }

  public static void main(String[] args) {

  }
}
