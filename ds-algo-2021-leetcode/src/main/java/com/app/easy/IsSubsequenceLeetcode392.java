package com.app.easy;

import java.util.Scanner;

/**
 * @author t0k02w6 on 31/10/21
 * @project ds-algo-2021
 */
public class IsSubsequenceLeetcode392 {
    private static boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = t.length();

        while(i < n) {
            if(j == m)
                return true;
            if(s.charAt(j) == t.charAt(i))
                j++;
            i++;
        }
        return (j == m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();

        System.out.println(isSubsequence(s, t));
        scanner.close();
    }
}
