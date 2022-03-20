package com.app.medium;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class MaximumNumberOfPointsWithCostLeetcode1937 {
    private static long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];

        long finalResult = Long.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0) {
                    dp[i][j] = points[i][j];
                } else {
                    long maxVal = Integer.MIN_VALUE;
                    for(int k = 0; k < n; k++) {
                        long val = points[i][j] + dp[i - 1][k] - Math.abs(j - k);
                        maxVal = Long.max(maxVal, val);
                    }
                    dp[i][j] = maxVal;
                }
                finalResult = Long.max(finalResult, dp[i][j]);
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2,3},{1,5,1},{3,1,1}};

        long ans = maxPoints(points);

        System.out.println(ans);

        points = new int[][] {{0,3,0,4,2},{5,4,2,4,1},{5,0,0,5,1},{2,0,1,0,3}};

        ans = maxPoints(points);

        System.out.println(ans);
    }
}
