package dp;

import java.util.Arrays;

/**
 * @author t0k02w6 on 26/04/22
 * @project ds-algo-2021
 */
public class MinimumNumberOfJumps {
    private static int minJumps(int[] jumps) {
        int n = jumps.length;
        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            int res = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(jumps[j] + j >= i) {
                    res = Integer.min(res, dp[j]);
                }
            }
            if(res != Integer.MAX_VALUE)
                dp[i] = res + 1;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] jumps = {3,4,2,1,2,1};

        int ans = minJumps(jumps);

        System.out.println(ans);
    }
}
