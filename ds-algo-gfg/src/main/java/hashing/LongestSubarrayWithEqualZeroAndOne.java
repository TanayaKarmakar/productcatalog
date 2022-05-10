package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 09/05/22
 * @project ds-algo-2021
 */
public class LongestSubarrayWithEqualZeroAndOne {
    private static int longestSubarray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                nums[i] = -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int preSum = 0;

        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(preSum == 0)
                maxLen = Integer.max(maxLen, i + 1);
            if(map.containsKey(preSum))
                maxLen = Integer.max(maxLen, i - map.get(preSum));
            else
                map.put(preSum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1,0,0};
        int ans = longestSubarray(nums);

        System.out.println(ans);
    }
}
