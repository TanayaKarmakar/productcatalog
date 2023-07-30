package com.app.medium;

/**
 * @author t0k02w6 on 08/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumPointsObtainedFromCardsLeetcode1423 {
  private static int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;
    int score = 0;
    int left = 0;
    int right = n - 1;

    for(left = 0;  left < k; left++) {
      score += cardPoints[left];
    }

    left--;
    int maxScore = score;
    while(left >= 0) {
      score -= cardPoints[left];
      score += cardPoints[right];

      maxScore = Integer.max(maxScore, score);

      left--;
      right--;
    }
    return maxScore;
  }

  public static void main(String[] args) {
    int[] cardPoints = {1,2,3,4,5,6,1};
    int k = 3;

    int ans = maxScore(cardPoints, k);
    System.out.println(ans);
  }
}
