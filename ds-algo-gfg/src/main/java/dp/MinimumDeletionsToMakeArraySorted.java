package dp;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class MinimumDeletionsToMakeArraySorted {
    private static int countDeletions(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        int[] lis = new int[n];
        lis[0] = 1;
        for(int i = 1; i < n; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
            maxLen = Integer.max(maxLen, lis[i]);
        }
        return (n - maxLen);
    }

    public static void main(String[] args) {
        int[] nums = {5,10,3,6,7,8};
        int ans = countDeletions(nums);

        System.out.println(ans);
    }
}
