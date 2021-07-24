package com.app.easy;

import java.util.Scanner;

/**
 * @author t0k02w6 on 24/07/21
 * @project ds-algo-2021
 */
public class PalindromeNumberLeetcode09 {
    public static boolean isPalindromeApproach2(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0))
            return false;
        int revNumber = 0;

        while(x > revNumber) {
            revNumber = revNumber * 10 + (x % 10);
            x = x / 10;
        }

        return (x == revNumber) || (x == revNumber / 10);
    }


    public static boolean isPalindrome(int x) {
        if(x < 0 || x == Integer.MAX_VALUE)
            return false;
        String str = String.valueOf(x);
        int start = 0;
        int end = str.length() - 1;
        while(start < end) {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        System.out.println(isPalindrome(x));

        System.out.println(isPalindromeApproach2(x));
    }
}
