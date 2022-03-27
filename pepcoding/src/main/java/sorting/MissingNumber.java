package sorting;

/**
 * @author t0k02w6 on 27/03/22
 * @project ds-algo-2021
 */

//missing number leetcode 268
public class MissingNumber {
    private static int missingNumber(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            while(nums[i] != i && nums[i] >= 0 && nums[i] < n) {
                int tmp = nums[i]; //0
                int tmp1 = nums[tmp]; //3
                nums[tmp] = tmp;
                nums[i] = tmp1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] != i)
                return i;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};

        int ans = missingNumber(nums);

        System.out.println(ans);
    }
}
