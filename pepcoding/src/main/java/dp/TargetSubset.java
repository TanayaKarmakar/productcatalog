package dp;

/**
 * @author t0k02w6 on 10/03/22
 * @project ds-algo-2021
 */
public class TargetSubset {
    private static boolean targetSubset(int[] nums, int targetSum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][targetSum + 1];

        for(int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= targetSum; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][targetSum];
    }

    public static void main(String[] args) {
        int[] nums = {4,2,7,1,3};
        int targetSum = 100;

        boolean ans = targetSubset(nums, targetSum);
        System.out.println(ans);
    }
}
