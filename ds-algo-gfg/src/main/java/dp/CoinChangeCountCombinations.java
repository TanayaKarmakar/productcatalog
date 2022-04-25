package dp;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class CoinChangeCountCombinations {
    private static int totalCombinations(int num, int[] coins) {
        int[] dp = new int[num + 1];

        dp[0] = 1;
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= num; j++) {
                if(j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[num];
    }

    public static void main(String[] args) {
        int n = 4;
        int[] coins = {1,2,3};

        int ans = totalCombinations(n, coins);

        System.out.println(ans);

        n = 10;
        coins = new int[] {2,5,3,6};

        ans = totalCombinations(n, coins);

        System.out.println(ans);
    }
}
