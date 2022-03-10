package dp;

import java.util.Arrays;

/**
 * @author t0k02w6 on 09/03/22
 * @project ds-algo-2021
 */
public class ClimbingStairsWithMinimumJumps {
    private static int minJumps(int[] steps) {
        int n = steps.length;
        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for(int i = n - 1; i >= 0; i--) {
            int nJumps = Integer.MAX_VALUE;
            for(int j = 1; j <= steps[i] && (i + j) < dp.length; j++) {
                nJumps = Integer.min(nJumps, dp[i + j]);
            }
            if(nJumps != Integer.MAX_VALUE)
                nJumps++;
            dp[i] = nJumps;
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        int[] steps = {3,3,0,2,2,3};

        int ans = minJumps(steps);
        System.out.println(ans);
    }
}
