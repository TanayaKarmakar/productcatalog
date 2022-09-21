package com.app.medium;

/**
 * @author t0k02w6 on 17/09/22
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubstring05 {
    private static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        String result = "";
        int maxLen = 1;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 >= maxLen) {
                    maxLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }

            right = i;
            left = i - 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 >= maxLen) {
                    maxLen = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "a";
        String ans = longestPalindrome(str);

        System.out.println(ans);

//        str = "cbbd";
//        ans = longestPalindrome(str);
//        System.out.println(ans);

    }
}
