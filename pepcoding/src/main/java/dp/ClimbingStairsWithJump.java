package dp;

/**
 * @author t0k02w6 on 08/03/22
 * @project ds-algo-2021
 */
public class ClimbingStairsWithJump {
    private static int jumps(int[] steps) {
        int n = steps.length;
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = 1; j <= steps[i] && (i + j) < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] steps = {3,3,0,2,2,3};

        int ans = jumps(steps);
        System.out.println(ans);
    }
}
