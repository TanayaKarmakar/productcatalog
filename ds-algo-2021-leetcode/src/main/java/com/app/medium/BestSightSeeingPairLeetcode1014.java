package com.app.medium;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class BestSightSeeingPairLeetcode1014 {
    private static int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int[] dp = new int[n];
        dp[0] = values[0] + 0;
        int old = dp[0];
        int finalAns = Integer.MIN_VALUE;
        for(int i = 1; i < n; i++) {
            int current = old + values[i] - i;
            dp[i] = current;
            old = Integer.max(old, values[i] + i);
            finalAns = Integer.max(finalAns, dp[i]);
        }
        return finalAns;
    }

    public static void main(String[] args) {
        int[] nums = {8,1,5,2,6};

        int ans = maxScoreSightseeingPair(nums);

        System.out.println(ans);
    }
}
