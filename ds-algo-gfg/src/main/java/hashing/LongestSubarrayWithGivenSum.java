package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 09/05/22
 * @project ds-algo-2021
 */
public class LongestSubarrayWithGivenSum {
    private static int longestSubarray(int[] nums, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        int preSum = 0;
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if(preSum == sum)
                return (i + 1);
            if(map.containsKey(preSum - sum))
                maxLen = Integer.max(maxLen, i - map.get(preSum - sum));
            map.put(preSum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {5,8,-4,-4,9,-2,2};
        int sum = 0;
        int ans = longestSubarray(nums, sum);

        System.out.println(ans);

        nums = new int[] {3,1,0,1,8,9,-2,2};
        sum = 5;

        ans = longestSubarray(nums, sum);
        System.out.println(ans);
    }
}
