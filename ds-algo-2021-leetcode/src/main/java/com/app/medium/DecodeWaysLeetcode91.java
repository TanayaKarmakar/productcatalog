package com.app.medium;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class DecodeWaysLeetcode91 {
  private static int numDecodings(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0: 1;

    for(int i = 2; i <= n; i++) {
      if(s.charAt(i - 1) != '0') {
        dp[i] = dp[i - 1];
      }
      int prev = s.charAt(i - 2) - '0';
      int curr = s.charAt(i - 1) - '0';
      int num = prev * 10 + curr;
      if(num >= 1 && num <= 26 && s.charAt(i - 2) != '0') {
        dp[i] += dp[i - 2];
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    System.out.println(numDecodings("226"));
    System.out.println(numDecodings("12"));
  }
}
