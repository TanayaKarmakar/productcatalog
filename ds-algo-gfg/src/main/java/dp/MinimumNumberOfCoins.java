package dp;

import java.util.Arrays;

/**
 * @author t0k02w6 on 26/04/22
 * @project ds-algo-2021
 */
public class MinimumNumberOfCoins {
    private static int minCoins(int[] coins, int num) {
        int []dp = new int[num + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int j = 1; j <= num; j++) {
            int val = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++) {
                if(j >= coins[i]) {
                    val = Integer.min(val, dp[j - coins[i]]);
                }
            }
            if(val != Integer.MAX_VALUE)
                dp[j] = val + 1;
        }
        return dp[num];
    }

    public static void main(String[] args) {
        int[] nums = {9,6,5,1};
        int val = 11;

        int ans = minCoins(nums, val);
        System.out.println(ans);

        nums = new int[] {25,10,5};
        val = 30;
        ans = minCoins(nums, val);
        System.out.println(ans);
    }
}
