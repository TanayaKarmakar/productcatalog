package sorting;

import java.util.Arrays;

/**
 * @author t0k02w6 on 05/05/22
 * @project ds-algo-2021
 */
public class ChocolateDistributionProblem {
    private static int minDiff(int[] nums, int m) {
        if(m > nums.length)
            return Integer.MAX_VALUE;
        Arrays.sort(nums);
        int left = 0;
        int right = m - 1;
        int minDiff = Integer.MAX_VALUE;
        while(right < nums.length) {
            minDiff = Integer.min(minDiff, nums[right] - nums[left]);
            left++;
            right++;
        }
        return minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {7,3,2,4,9,12,56};
        int m = 3;
        int ans = minDiff(nums, m);

        System.out.println(ans);
    }
}
