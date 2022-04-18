package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 17/04/22
 * @project ds-algo-2021
 */
public class PalindromicSubstringsLeetcode647 {
    private static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int i = 0;
        while(i < n) {
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
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(countSubstrings(str));

        scanner.close();
    }
}
