package com.app.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersLeetcode03 {
    private static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;

        int n = s.length();
        while(right < n) {
            while(right < n && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Integer.max(max, (right - left));
            set.remove(s.charAt(left));
            left++;
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
