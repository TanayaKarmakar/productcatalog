package com.app.hard;

public class RegularExpressionMatchingLeetcode10 {
    private static boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 1; i <= m; i++) {
            if(p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 2][0];
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char sc = s.charAt(j - 1);
                char pc = p.charAt(i - 1);
                if(sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pc == '*') {
                    dp[i][j] = dp[i - 2][j];
                    char pclc = p.charAt(i - 2);
                    if(pclc == sc || pclc == '.') {
                        dp[i][j] = dp[i][j] | dp[i][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
    }
}
