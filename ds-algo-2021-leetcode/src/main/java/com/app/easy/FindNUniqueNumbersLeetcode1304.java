package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 12/02/23
 * @project ds-algo-2021
 */
public class FindNUniqueNumbersLeetcode1304 {
  public static int[] sumZero(int n) {
    if(n == 1)
      return new int[]{0};
    if(n % 2 == 0)
      return buildArrayForEven(n);
    else
      return buildArrayForOdd(n);
  }

  private static int[] buildArrayForOdd(int n) {
    int[] nums = new int[n];
    int mid = n / 2;
    int sum = 0;
    int k = 1;
    for(int i = mid; i < n; i++) {
      nums[i] = k++;
      sum += nums[i];
    }

    k = -1;
    for(int i = mid - 1; i > 0; i--) {
      nums[i] = k--;
      sum += nums[i];
    }

    nums[0] = -sum;
    return nums;
  }

  private static int[] buildArrayForEven(int n) {
    int[] nums = new int[n];
    int mid = n / 2;
    int k = 1;
    for(int i = mid; i < n; i++) {
      nums[i] = k++;
    }

    k = -1;
    for(int i = mid - 1; i >= 0; i--) {
      nums[i] = k--;
    }
    return nums;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(sumZero(3)));
  }
}
