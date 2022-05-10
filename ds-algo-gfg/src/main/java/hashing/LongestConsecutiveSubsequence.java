package hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 09/05/22
 * @project ds-algo-2021
 */
public class LongestConsecutiveSubsequence {
    private static int longestSubseq(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], false);
        }

        int maxLen = 1;
        int i = 0;
        while(i < nums.length) {
            int k = nums[i];
            int currentLen = 0;
            while(map.containsKey(k) && !map.get(k)) {
                currentLen++;
                map.put(k, true);
                k++;
            }

            k = nums[i];
            k--;
            while(map.containsKey(k) && !map.get(k)) {
                currentLen++;
                map.put(k, true);
                k--;
            }

            maxLen = Integer.max(maxLen, currentLen);
            i++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,9,3,4,2,20};
        int ans = longestSubseq(nums);

        System.out.println(ans  );
    }
}
