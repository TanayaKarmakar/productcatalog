package sorting;

/**
 * @author t0k02w6 on 27/03/22
 * @project ds-algo-2021
 */
public class FindMissingPositive {
    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            while(nums[i] > 0 && nums[i] <= n && nums[i] != (i + 1)) {
                int tmp = nums[i];
                if(nums[tmp - 1] == tmp)
                    break;
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != (i + 1))
                return (i + 1);
        }
        return n + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};

        int ans = firstMissingPositive(nums);

        System.out.println(ans);
    }
}
