package hashing;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 08/05/22
 * @project ds-algo-2021
 */
public class SubarrayWithZeroSum {
    private static boolean isExist(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int preSum = 0;
        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(preSum == 0)
                return true;
            if(!set.isEmpty() && set.contains(preSum))
                return true;
            set.add(preSum);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
