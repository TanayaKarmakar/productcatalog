package dp;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class MaximumSumIncreasingSubsequence {
    private static int maxSumIncreasingSubseq(int[] nums) {
        int n = nums.length;
        int[] maxSum = new int[n];
        int finalResult = nums[0];

        maxSum[0] = nums[0];
        for(int i = 1; i < n; i++) {
            maxSum[i] = nums[i];
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    maxSum[i] = Integer.max(maxSum[i], maxSum[j] + nums[i]);
                }
            }
            finalResult = Integer.max(finalResult, maxSum[i]);
        }
        return finalResult;
    }

    public static void main(String[] args) {
        int[] nums = {3,20,4,6,7,30};

        int ans = maxSumIncreasingSubseq(nums);

        System.out.println(ans);
    }
}
