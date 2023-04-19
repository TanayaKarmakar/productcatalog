package com.app.educative.io.dp.lcs;

/**
 * @author t0k02w6 on 19/04/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumSumIncreasingSubsequence {
  private static int findMSIS(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];
    lis[0] = nums[0];

    int maxSum = nums[0];
    for(int i = 1; i < n; i++) {
      lis[i] = nums[i];
      for(int j = 0; j < i; j++) {
        if(nums[j] < nums[i]) {
          lis[i] = Integer.max(lis[i], lis[j] + nums[i]);
        }
      }
      maxSum = Integer.max(lis[i], maxSum);
    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] nums = {4,1,2,6,10,1,12};
    int ans = findMSIS(nums);

    System.out.println(ans);
  }
}
