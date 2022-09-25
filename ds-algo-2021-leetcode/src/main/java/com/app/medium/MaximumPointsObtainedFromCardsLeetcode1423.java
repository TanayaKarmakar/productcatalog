package com.app.medium;

/**
 * @author t0k02w6 on 22/09/22
 * @project ds-algo-2021-leetcode
 */
public class MaximumPointsObtainedFromCardsLeetcode1423 {
    private static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int maxSum = 0;
        int left = 0;
        int right = cardPoints.length - 1;
        for(left = 0; left < k; left++) {
            sum += cardPoints[left];
        }
        maxSum = Integer.max(maxSum, sum);
        left--;

        while(left >= 0) {
            sum -= cardPoints[left];
            left--;
            sum += cardPoints[right];
            right--;
            maxSum = Integer.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

    }
}
