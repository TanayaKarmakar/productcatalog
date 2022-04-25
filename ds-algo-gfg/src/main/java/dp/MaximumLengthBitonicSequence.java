package dp;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class MaximumLengthBitonicSequence {
    private static int longestBitonic(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];

        lis[0] = nums[0];
        for(int i = 1; i < n; i++) {
            lis[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i])
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
            }
        }

        int[] lds = new int[n];
        lds[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for(int j = i + 1; j < n; j++) {
                if(nums[j] < nums[i])
                    lds[i] = Integer.max(lds[i], lds[j] + 1);
            }
        }

        int maxLen = 1;
        for(int i = 0; i < n; i++) {
            maxLen = Integer.max(lis[i] + lds[i] - 1, maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,11,2,10,4,5,2,1};
        int ans = longestBitonic(nums);

        System.out.println(ans);
    }
}
