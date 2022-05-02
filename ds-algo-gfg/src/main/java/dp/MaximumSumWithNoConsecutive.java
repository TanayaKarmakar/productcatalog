package dp;

/**
 * @author t0k02w6 on 30/04/22
 * @project ds-algo-2021
 */
public class MaximumSumWithNoConsecutive {
    private static int maxSumSpaceOptimized(int[] nums) {
        int n = nums.length;
        int prevPrev = nums[0];
        int prev = Integer.max(nums[0], nums[1]);

        int result = prev;
        for(int i = 2; i < n; i++) {
            result = Integer.max(prev, prevPrev + nums[i]);
            prevPrev = prev;
            prev = result;
        }
        return result;
    }

    private static int maxSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Integer.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {1, 10, 2};
        int ans = maxSum(nums);

        System.out.println(ans);

        ans = maxSumSpaceOptimized(nums);
        System.out.println(ans);
    }
}
