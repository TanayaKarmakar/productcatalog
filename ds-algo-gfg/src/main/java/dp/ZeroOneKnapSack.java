package dp;

/**
 * @author t0k02w6 on 26/04/22
 * @project ds-algo-2021
 */
public class ZeroOneKnapSack {
    private static int maxCapacity(int[] weights, int[] profits, int maxWeight) {
        int n = weights.length;
        int[][] dp = new int[n + 1][maxWeight + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= maxWeight; j++) {
                int option1 = dp[i - 1][j];
                int option2 = 0;
                if(j >= weights[i - 1]) {
                    option2 = profits[i - 1] + dp[i - 1][j - weights[i - 1]];
                }
                dp[i][j] = Integer.max(option1, option2);
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {
        int[] weights = {5,4,6,3};
        int[] profits = {10,40,30,50};
        int maxWeight = 10;

        int ans = maxCapacity(weights, profits, maxWeight);
        System.out.println(ans);
    }
}
