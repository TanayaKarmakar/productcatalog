package com.app.medium;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class MaximumSwapLeetcode670 {
  private static int maximumSwap(int num) {
    String numStr = String.valueOf(num);
    int n = numStr.length();
    char[] nums = new char[n];

    for(int i = 0; i < numStr.length(); i++) {
      nums[i] = numStr.charAt(i);
    }

    Integer maxNumber = Integer.MIN_VALUE;
    for(int i = n - 2; i >= 0; i--) {
      for(int j = i + 1; j < n; j++) {
        if(nums[i] < nums[j]) {
          swap(nums, i, j);
          Integer newNum = Integer.parseInt(new String(nums));
          maxNumber = Integer.max(maxNumber, newNum);
          swap(nums, i, j);
        }
      }
    }
    return maxNumber == Integer.MIN_VALUE ? num: maxNumber;
  }

  private static void swap(char[] nums, int i, int j) {
    char tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {

  }
}
