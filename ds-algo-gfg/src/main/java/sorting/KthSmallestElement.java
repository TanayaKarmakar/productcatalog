package sorting;

/**
 * @author t0k02w6 on 05/05/22
 * @project ds-algo-2021
 */
public class KthSmallestElement {
    private static int kThSmallest(int[] nums, int k) {
        int n = nums.length;
        if(n < k)
            return -1;
        int l = 0;
        int r = n - 1;

        while(l <= r) {
            int p = partition(nums, l, r);
            if(p == k - 1)
                return nums[p];
            else if(p > k - 1)
                r = p - 1;
            else
                l = p + 1;
        }
        return -1;
    }

    private static int partition(int[] nums, int l, int r) {
        int i = l - 1;
        int pivot = nums[r];

        for(int j = l; j < r; j++) {
            if(nums[j] < pivot) {
                i++;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        int tmp = nums[i + 1];
        nums[i + 1] = nums[r];
        nums[r] = tmp;

        return (i + 1);
    }

    public static void main(String[] args) {
        int[] nums = {10,4,5,8,11,6,26};
        int k = 5;

        int ans = kThSmallest(nums, k);

        System.out.println(ans);
    }
}
