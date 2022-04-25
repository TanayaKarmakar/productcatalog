package dp;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class LongestIncreasingSubsequence {
    private static int lis(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];

        lis[0] = 1;
        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
            maxLen = Integer.max(maxLen, lis[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2,8,10};

        int ans = lis(nums);

        System.out.println(ans);
    }
}
