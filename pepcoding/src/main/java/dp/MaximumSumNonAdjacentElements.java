package dp;

/**
 * @author t0k02w6 on 13/03/22
 * @project ds-algo-2021
 */
public class MaximumSumNonAdjacentElements {
    private static int maxSum(int[] nums) {
        int n = nums.length;
        int[] include = new int[n];
        int[] exclude = new int[n];

        include[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            include[i] = exclude[i - 1] + nums[i];
            exclude[i] = Integer.max(exclude[i - 1], include[i - 1]);
        }

        return Integer.max(include[n - 1], exclude[n - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {5,10,10,100,5};
        int maxSum = maxSum(nums);

        System.out.println(maxSum);
    }
}
