package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class SubsequencePatternMatchingBottomUp {
  private static int findPatternOcc(String str, String pattern) {
    int m = str.length();
    int n = pattern.length();

    int[][] dp = new int[m + 1][n + 1];

    for(int i = 0; i <= m; i++) {
      dp[i][0] = 1;
    }

    for(int i = 1; i <= m; i++) {
      for(int j = 1; j <= n; j++) {
        if(str.charAt(i - 1) == pattern.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1];
        dp[i][j] += dp[i - 1][j];
      }
    }
    return dp[m][n];
  }

  public static void main(String[] args) {
    System.out.println(findPatternOcc("baxmx", "ax"));
    System.out.println(findPatternOcc("tomorrow", "tor"));
  }
}
