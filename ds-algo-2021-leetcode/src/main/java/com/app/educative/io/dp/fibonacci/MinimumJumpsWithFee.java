package com.app.educative.io.dp.fibonacci;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumJumpsWithFee {
  private static int minValue(int[] fee) {
    int n = fee.length;
    int[] dp = new int[n];
    return minValueRec(fee, dp, 0);
  }

  private static int minValueRec(int[] fee, int[] dp, int currentIndx) {
    if(currentIndx >= fee.length)
      return 0;
    if(dp[currentIndx] == 0) {
      int take1Step = minValueRec(fee, dp, currentIndx + 1);
      int take2Step = minValueRec(fee, dp, currentIndx + 2);
      int take3Step = minValueRec(fee, dp, currentIndx + 3);

      dp[currentIndx] = fee[currentIndx] + Integer.min(take1Step, Integer.min(take2Step, take3Step));
    }
    return dp[currentIndx];
  }

  public static void main(String[] args) {
    System.out.println(minValue(new int[]{1,2,5,2,1,2}));
    System.out.println(minValue(new int[]{2,3,4,5}));
  }
}
