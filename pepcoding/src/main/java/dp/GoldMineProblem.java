package dp;

import common.Util;

/**
 * @author t0k02w6 on 10/03/22
 * @project ds-algo-2021
 */
public class GoldMineProblem {
    private static int maxGold(int[][] gold) {
        int m = gold.length;
        int n = gold[0].length;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            dp[i][0] = gold[i][0];
        }

        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                int option1 = (i - 1) >= 0 ? dp[i - 1][j - 1]: 0;
                int option2 = dp[i][j - 1];
                int option3 = (i + 1) < m ? dp[i + 1][j - 1]: 0;

                dp[i][j] = gold[i][j] + Integer.max(option1, Integer.max(option2, option3));
            }
        }

        Util.display2DArray(dp);

        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++) {
            maxValue = Integer.max(maxValue, dp[i][n - 1]);
        }

        return maxValue;
    }

    public static void main(String[] args) {
        int[][] gold = {{0,1,4,2,8,2},{4,3,6,5,0,4},{1,2,4,1,4,6},{2,0,7,3,2,2},{3,1,5,9,2,4},{2,7,0,8,5,1}};

        int ans = maxGold(gold);
        System.out.println(ans);
    }
}
