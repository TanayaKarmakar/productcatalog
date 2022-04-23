package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 23/04/22
 * @project ds-algo-2021
 */
public class LongestSubstringAtMostKDistinctCharactersLeetcode340 {
    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 1;

        while(r < n) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while(l <= r && map.size() > k) {
                if(r - l > maxLen) {
                    maxLen = (r - l);
                }
                char ch1 = s.charAt(l);
                int val = map.get(ch1);
                map.put(ch1, val - 1);
                if(map.get(ch1) == 0)
                    map.remove(ch1);
                l++;
            }
            r++;
        }
        if(map.size() <= k)
            maxLen = Integer.max(maxLen, (r - l));
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "eceba";
        int k = 2;

        int ans = lengthOfLongestSubstringKDistinct(str, k);

        System.out.println(ans);
    }
}
