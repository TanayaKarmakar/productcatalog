package dp;

/**
 * @author t0k02w6 on 12/03/22
 * @project ds-algo-2021
 */
public class UnboundedKnapsack {
    private static int maxWeight(int[] weights, int[] profits, int targetWt) {
        int[] dp = new int[targetWt + 1];

        for(int j = 1; j <= targetWt; j++) {
            for(int i = 0; i < weights.length; i++) {
                if(j >= weights[i]) {
                    dp[j] = Integer.max(dp[j], profits[i] + dp[j - weights[i]]);
                }
            }
        }
        return dp[targetWt];
    }

    public static void main(String[] args) {
        int[] weights = {2,5,1,3,4};
        int[] profits = {15,14,10,45,30};
        int targetWeight = 7;

        int ans = maxWeight(weights, profits, targetWeight);
        System.out.println(ans);
    }
}
