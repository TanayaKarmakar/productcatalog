package com.app.medium;

/**
 * @author t0k02w6 on 22/03/22
 * @project ds-algo-2021
 */
public class LongestPalindromicSubstringLeetcode5 {
    private static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int n = s.length();
        int i = 0;

        int maxLen = 0;

        String str = "";
        while(i < n) {
            int left = i;
            int right = i;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(maxLen < (right - left + 1)) {
                    maxLen = (right -left + 1);
                    str = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            left = i - 1;
            right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(maxLen < (right - left + 1)) {
                    maxLen = (right -left + 1);
                    str = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            i++;
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "babad";

        System.out.println(longestPalindrome(str));

        str = "cbbd";

        System.out.println(longestPalindrome(str));
    }
}
