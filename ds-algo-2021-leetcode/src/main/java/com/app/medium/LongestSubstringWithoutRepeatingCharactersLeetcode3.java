package com.app.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class LongestSubstringWithoutRepeatingCharactersLeetcode3 {
    private static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;

        int n = s.length();

        int ans = 1;

        while(right < n) {
            while(right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }

            ans = Integer.max(ans, (right - left));
            set.remove(s.charAt(left));
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        int ans = lengthOfLongestSubstring(s);

        System.out.println(ans);
    }
}
