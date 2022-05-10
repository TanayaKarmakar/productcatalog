package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 09/05/22
 * @project ds-algo-2021
 */
public class LongestCommonSpanWithSameSumBinaryArray {
    private static int maxLen(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];

        for(int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
        }
        int preSum = 0;
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            preSum += diff[i];
            if(preSum == 0)
                maxLen = Integer.max(maxLen, (i + 1));
            if(map.containsKey(preSum))
                maxLen = Integer.max(maxLen, i - map.get(preSum));
            else
                map.put(preSum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 0, 0, 0, 0};
        int[] nums2 = {1, 0, 1, 0, 0, 1};

        int ans = maxLen(nums1, nums2);

        System.out.println(ans);
    }
}
