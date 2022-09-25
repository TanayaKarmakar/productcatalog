package com.app.medium;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class DecodeWaysLeetcode91 {
    private static int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
        if(s.length() == 1)
            return 1;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0: 1;


        for(int i = 2; i <= n; i++) {
            dp[i] = 0;
            char ch = s.charAt(i - 1);
            char prev = s.charAt(i - 2);
            if(ch != '0') {
                dp[i] = dp[i - 1];
            }
            if(prev == '1' || prev == '2' && ch <= '6') {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11106"));
    }
}
