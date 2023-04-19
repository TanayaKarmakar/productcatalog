package com.app.educative.io.dp.lcs;

/**
 * @author t0k02w6 on 19/04/23
 * @project ds-algo-2021-leetcode
 */
public class LonestIncreasingSubsequence {
  private static int lis(int[] nums) {
    int n = nums.length;
    int[] lis = new int[n];

    int maxLen = 1;
    lis[0] = 1;
    for(int i = 1; i < n; i++) {
      lis[i] = 1;
      for(int j = 0; j < i; j++) {
        if(nums[j] < nums[i]) {
          lis[i] = Integer.max(lis[i], lis[j] + 1);
        }
      }
      maxLen = Integer.max(maxLen, lis[i]);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int[] nums = {4,2,3,6,10,1,12};

    int ans = lis(nums);

    System.out.println(ans);
  }
}
