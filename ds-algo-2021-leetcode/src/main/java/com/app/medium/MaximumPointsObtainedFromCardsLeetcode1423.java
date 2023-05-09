package com.app.medium;

/**
 * @author t0k02w6 on 08/05/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumPointsObtainedFromCardsLeetcode1423 {
  private static int maxScore(int[] cardPoints, int k) {
    int left = 0;
    int n = cardPoints.length;
    int right = n - 1;
    int maxPoints = 0;
    int totalPoints = 0;
    for(left = 0; left < k; left++) {
      totalPoints += cardPoints[left];
    }

    maxPoints = Integer.max(maxPoints, totalPoints);
    left--;
    while(left >= 0) {
      totalPoints -= cardPoints[left];
      left--;

      totalPoints += cardPoints[right];
      right--;

      maxPoints = Integer.max(totalPoints, maxPoints);
    }
    return maxPoints;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6,1};
    int k = 3;

    int ans = maxScore(nums, k);

    System.out.println(ans);
  }
}
