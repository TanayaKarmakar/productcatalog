package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 27/07/21
 * @project ds-algo-2021
 */
public class LongestPalindromicSubstringLeetcode05 {
    private static String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;
        int n = s.length();

        int i = 0;
        int maxLen = 0;
        int start = -1;
        while(i < n) {
            int left = i;
            int right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(maxLen < (right - left + 1)) {
                    start = left;
                    maxLen = (right - left + 1);
                }
                left--;
                right++;
            }

            left = i - 1;
            right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if(maxLen < (right - left + 1)) {
                    start = left;
                    maxLen = (right - left + 1);
                }
                left--;
                right++;
            }
            i++;
        }

        return s.substring(start, start + maxLen);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        System.out.println(longestPalindrome(str));

        scanner.close();
    }
}
