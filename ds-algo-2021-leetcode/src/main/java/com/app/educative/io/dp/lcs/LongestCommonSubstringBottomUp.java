package com.app.educative.io.dp.lcs;

/**
 * @author t0k02w6 on 19/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestCommonSubstringBottomUp {
  private static int findLcsLength(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();

    int[][] dp = new int[m + 1][n + 1];

    int maxLen = 0;
    for(int i = 1; i <= m; i++) {
      for(int j = 1; j <= n; j++) {
        if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          maxLen = Integer.max(maxLen, dp[i][j]);
        }
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    System.out.println(findLcsLength("abdca", "cbda"));
    System.out.println(findLcsLength("passport", "ppsspt"));
  }
}
