package com.app.medium;

/**
 * @author t0k02w6 on 06/10/21
 * @project ds-algo-2021
 */
public class LongestPalindromicSubstringLeetcode05 {
    private static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int n = s.length();
        int start = 0;
        int maxlen = 0;
        for(int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if((right - left + 1) > maxlen) {
                    start = left;
                    maxlen = (right - left) + 1;
                }
                left--;
                right++;
            }

            left = i - 1;
            right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if((right - left + 1) > maxlen) {
                    start = left;
                    maxlen = (right - left) + 1;
                }
                left--;
                right++;
            }

        }
        return s.substring(start, start + maxlen);
    }

    public static void main(String[] args) {
        String str = "a";

        String ans = longestPalindrome(str);

        System.out.println(ans);
    }
}
