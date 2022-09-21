package com.app.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class LongestSubstringWithoutRepeatingCharactersLeetcode03 {
    private static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int maxlen = 0;
        int i = 0;
        int left = 0;
        int right = 0;
        while(right < n) {
            char ch = s.charAt(right);
            while(right < n && !map.containsKey(ch)) {
                map.put(ch, right);
                right++;
            }
            maxlen = Integer.max(maxlen, right - left + 1);
            left = right;
            right++;
        }
        //maxlen = Integer.max(maxlen, i - left + 1);
        return maxlen;
    }
    public static void main(String[] args) {

    }
}
