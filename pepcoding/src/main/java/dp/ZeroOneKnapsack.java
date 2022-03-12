package dp;

/**
 * @author t0k02w6 on 11/03/22
 * @project ds-algo-2021
 */
public class ZeroOneKnapsack {
    private static int maxWeight(int[] weights, int[] profits, int targetWeight) {
        int[][] dp = new int[weights.length + 1][targetWeight + 1];

        for(int i = 1; i <= weights.length; i++) {
            for(int j = 1; j <= targetWeight; j++) {
                int option1 = dp[i - 1][j];
                int option2 = 0;
                if(j >= weights[i - 1]) {
                    option2 = profits[i - 1] + dp[i - 1][j - weights[i - 1]];
                }
                dp[i][j] = Integer.max(option1, option2);
            }
        }
        return dp[weights.length][targetWeight];
    }

    public static void main(String[] args) {
        int[] weights = {2,5,1,3,4};
        int[] profits = {15,14,10,45,30};
        int targetWeight = 7;

        int ans = maxWeight(weights, profits, targetWeight);
        System.out.println(ans);
    }
}
