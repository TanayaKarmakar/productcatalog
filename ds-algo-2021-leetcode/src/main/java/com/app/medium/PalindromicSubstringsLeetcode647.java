package com.app.medium;

public class PalindromicSubstringsLeetcode647 {
    private static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for(int i = 0; i < n; i++) {
            int left = i;
            int right = i;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }

            left = i - 1;
            right = i;

            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }
}
