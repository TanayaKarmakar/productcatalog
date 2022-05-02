package dp;

/**
 * @author t0k02w6 on 02/05/22
 * @project ds-algo-2021
 */
public class CountOfSubsetSumProblem {
    private static int count(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= sum; j++) {
                int count = dp[i - 1][j];
                if(j >= nums[i - 1])
                    count += dp[i - 1][j - nums[i - 1]];
                dp[i][j] = count;
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,3,6};
        int sum = 8;

        int ans = count(nums, sum);

        System.out.println(ans);
    }
}
