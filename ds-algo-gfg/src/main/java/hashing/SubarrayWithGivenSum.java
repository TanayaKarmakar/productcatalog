package hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 09/05/22
 * @project ds-algo-2021
 */
public class SubarrayWithGivenSum {
    private static boolean isSumPresent(int[] nums, int sum) {
        Set<Integer> set = new HashSet<>();

        int preSum = 0;
        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(preSum == sum)
                return true;
            if(set.contains(preSum - sum))
                return true;
            set.add(preSum);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {5,8,6,13,3,-1};
        int sum = 22;

        boolean ans = isSumPresent(nums, sum);

        System.out.println(ans);
    }
}
