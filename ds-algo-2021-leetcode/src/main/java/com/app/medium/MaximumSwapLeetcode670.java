package com.app.medium;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumSwapLeetcode670 {
  private static int maximumSwap(int num) {
    char[] numArr = String.valueOf(num).toCharArray();
    int n = numArr.length;
    int maxVal = num;
    for(int i = n - 2; i >= 0; i--) {
      for(int j = i + 1; j < n; j++) {
        if(numArr[i] < numArr[j]) {
          swap(numArr, i, j);
          int currentNum = Integer.parseInt(new String(numArr));
          maxVal = Integer.max(maxVal, currentNum);
          swap(numArr, i, j);
        }
      }
    }
    return maxVal;
  }

  private static void swap(char[] numArr, int i, int j) {
    char ch = numArr[i];
    numArr[i] = numArr[j];
    numArr[j] = ch;
  }

  public static void main(String[] args) {
    System.out.println(maximumSwap(2736));
    System.out.println(maximumSwap(9973));
  }
}
