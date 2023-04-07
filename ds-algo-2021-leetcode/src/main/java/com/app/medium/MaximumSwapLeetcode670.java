package com.app.medium;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumSwapLeetcode670 {
  private static int maximumSwap(int num) {
    char[] numArr = String.valueOf(num).toCharArray();

    int maxNum = num;
    int n = numArr.length;

    for(int i = n - 2; i >= 0; i--) {
      for(int j = i + 1; j < n; j++) {
        if(numArr[i] < numArr[j]) {
          swap(numArr, i, j);
          int currentNum = Integer.parseInt(new String(numArr));
          maxNum = Integer.max(maxNum, currentNum);
          swap(numArr, i, j);
        }
      }
    }

    return maxNum;
  }

  private static void swap(char[] nums, int i, int j) {
    char tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    System.out.println(maximumSwap(9973));
    System.out.println(maximumSwap(2736));
  }
}
