package com.app.medium;

public class LongestPalindromicSubstringLeetcode05 {
    private static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = 1;
        int start = 0;
        int end = 0;

        int i = 0;
        while(i < n) {
            left = i;
            right = i;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }


            left = i - 1;
            right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    start = left;
                    end = right;
                }
                left--;
                right++;
            }
            i++;
        }

        if(start == -1)
            return "";
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
