package binarysearch;

/**
 * @author t0k02w6 on 08/05/22
 * @project ds-algo-2021
 */
public class AllocatingMininumNumberOfpages {
    private static int minPages(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int total = 0;

        for(int i = 0; i < nums.length; i++) {
            max = Integer.max(max, nums[i]);
            total += nums[i];
        }

        int low = max;
        int high = total;
        int res = 0;

        while(low <= high) {
            int mid = (low + high) >> 1;
            if(isValidDist(nums, mid, k)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    private static boolean isValidDist(int[] nums, int mid, int k) {
        int req = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > mid) {
                req++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return req <= k;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 20};
        int k = 2;
        int ans = minPages(nums, k);

        System.out.println(ans);
    }
}
