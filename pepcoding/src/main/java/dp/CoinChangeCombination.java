package dp;

import java.util.Arrays;

/**
 * @author t0k02w6 on 11/03/22
 * @project ds-algo-2021
 */
public class CoinChangeCombination {
    private static int totalCombination(int[] coins, int target) {
        int[] dp = new int[target + 1];
        //Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(Arrays.toString(dp));

        return dp[target];
    }

    public static void main(String[] args) {
        int[] coins = {2,3,5};
        int target = 7;

        System.out.println(totalCombination(coins, target));
    }
}
