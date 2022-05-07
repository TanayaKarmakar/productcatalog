package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/05/22
 * @project ds-algo-2021
 */
public class MinimumDifference {
    private static int minDiff(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Integer.min(minDiff, nums[i] - nums[i - 1]);
        }

        return minDiff == Integer.MAX_VALUE ? 0: minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,12,5,18};

        int ans = minDiff(nums);

        System.out.println(ans);
    }
}
