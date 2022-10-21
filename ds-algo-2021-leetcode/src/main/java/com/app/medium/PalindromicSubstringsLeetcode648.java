package com.app.medium;

/**
 * @author t0k02w6 on 25/09/22
 * @project ds-algo-2021-leetcode
 */
public class PalindromicSubstringsLeetcode648 {
    private static int countSubstrings(String s) {
        int left = 0;
        int right = 0;
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            left = i;
            right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }

            right = i;
            left = i - 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
