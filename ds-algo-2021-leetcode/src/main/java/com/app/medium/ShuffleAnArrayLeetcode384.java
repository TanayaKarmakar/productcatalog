package com.app.medium;

import java.util.Random;

/**
 * @author t0k02w6 on 25/06/23
 * @project ds-algo-2021-leetcode
 */


public class ShuffleAnArrayLeetcode384 {
  static class Solution {
    private int[] originalConfig;
    private int[] current;
    private Random rand;

    public Solution(int[] nums) {
      this.originalConfig = new int[nums.length];
      for(int i = 0; i < nums.length; i++) {
        originalConfig[i] = nums[i];
      }
      this.current = nums;
      rand = new Random();
    }

    public int[] reset() {
      return this.originalConfig;
    }

    public int[] shuffle() {
      if(current.length == 0)
        return new int[]{};
      int min = 0;
      int max = current.length - 1;
      int randIndx = rand.nextInt(max - min + 1);
      swap(current, randIndx, max);
      return current;
    }

    private void swap(int[] nums, int i, int j) {
      int tmp = nums[i];
      nums[i] = nums[j];
      nums[j] = tmp;
    }

  }

  public static void main(String[] args) {

  }
}
