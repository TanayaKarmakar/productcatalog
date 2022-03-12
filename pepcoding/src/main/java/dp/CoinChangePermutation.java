package dp;

/**
 * @author t0k02w6 on 11/03/22
 * @project ds-algo-2021
 */
public class CoinChangePermutation {
    private static int numPermute(int[] coins, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for(int j = 1; j <= target; j++) {
            for(int i = 0; i < coins.length; i++) {
                if(j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,5};

        int ans = numPermute(nums, target);
        System.out.println(ans);
    }
}
