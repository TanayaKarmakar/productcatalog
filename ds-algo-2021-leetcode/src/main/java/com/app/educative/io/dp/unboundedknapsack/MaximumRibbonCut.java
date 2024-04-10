package com.app.educative.io.dp.unboundedknapsack;

public class MaximumRibbonCut {
    private static int maxCut(int totalLen, int[] ribbons) {
        int[] dp = new int[totalLen + 1];

        for(int i = 1; i <= totalLen; i++) {
            int result = Integer.MIN_VALUE;
            for(int j = 0; j < ribbons.length; j++) {
                if(i >= ribbons[j]) {
                    result = Integer.max(result, dp[i - ribbons[j]]);
                }
            }
            if(result != Integer.MIN_VALUE)
                dp[i] = result + 1;
        }
        return dp[totalLen];
    }

    public static void main(String[] args) {
        int[] ribbons = {2,3,5};
        int totalLen = 5;
        int ans = maxCut(totalLen, ribbons);

        System.out.println(ans);
    }
}
