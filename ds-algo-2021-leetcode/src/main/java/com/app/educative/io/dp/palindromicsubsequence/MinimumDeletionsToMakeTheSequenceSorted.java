package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumDeletionsToMakeTheSequenceSorted {
  private static int minDeletion(int[] nums) {
    int n = nums.length;
    int maxLen = 1;
    int[] lis = new int[n];

    lis[0] = 1;
    for(int i = 1; i < n; i++) {
      lis[i] = 1;
      for(int j = 0; j < i; j++) {
        if(nums[j] < nums[i]) {
          lis[i] = Integer.max(lis[i], lis[j] + 1);
        }
      }
      maxLen = Integer.max(lis[i], maxLen);
    }

    return (n - maxLen);
  }

  public static void main(String[] args) {
    int[] nums = {4,2,3,6,10,1,12};
    int len = minDeletion(nums);

    System.out.println(len);
  }
}
