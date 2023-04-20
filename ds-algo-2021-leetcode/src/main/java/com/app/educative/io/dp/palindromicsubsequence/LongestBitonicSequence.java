package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestBitonicSequence {
  private static int lbs(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
    lis[0] = 1;
    for(int i = 1; i < n; i++) {
      lis[i] = 1;
      for(int j = 0; j < i; j++) {
        if(nums[j] < nums[i]) {
          lis[i] = Integer.max(lis[i], lis[j] + 1);
        }
      }
    }

    int[] lds = new int[n];
    lds[n - 1] = 1;
    for(int i = n - 2; i >= 0; i--) {
      lds[i] = 1;
      for(int j = i + 1; j < n; j++) {
        if(nums[j] < nums[i]) {
          lds[i] = Integer.max(lds[i], lds[j] + 1);
        }
      }
    }

    int maxLen = 1;
    for(int i = 0; i < n; i++) {
      maxLen = Integer.max(maxLen, lis[i] + lds[i] - 1);
    }

    return maxLen;
  }

  public static void main(String[] args) {
    int[] nums = {4,2,3,6,10,1,12};
    System.out.println(lbs(nums));

    nums = new int[] {4,2,5,9,7,6,10,3,1};
    System.out.println(lbs(nums));
  }
}
