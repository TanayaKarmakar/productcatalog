package dp;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class BinarySearchBasedLIS {
    private static int ceilIndx(int[] tail, int start, int end, int num) {
        while(start < end) {
            int mid = (start + end) >> 1;
            if(tail[mid] >= num)
                end = mid;
            else
                start = mid + 1;
        }
        return end;
    }

    private static int lis(int[] nums) {
        int n = nums.length;
        int[] tail = new int[n];

        tail[0] = nums[0];
        int len = 1;
        for(int i = 1; i < n; i++) {
            if(tail[len - 1] < nums[i]) {
                tail[len] = nums[i];
                len++;
            } else {
                int c = ceilIndx(tail, 0, len - 1, nums[i]);
                tail[c] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {3,10,20,4,6,7};
        int ans = lis(nums);

        System.out.println(ans);
    }
}
