package com.app.medium;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class BestSightSeeingPairLeetcode1014 {
  private static int maxScoreSightseeingPair(int[] values) {
    int maxAi = values[0] + 0;
    int result = 0;
    for(int i = 1; i < values.length; i++) {
      result = Integer.max(result, maxAi + values[i] - i);
      maxAi = Integer.max(maxAi, values[i] + i);
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {8,1,5,2,6};
    int ans = maxScoreSightseeingPair(nums);

    System.out.println(ans);
  }
}
