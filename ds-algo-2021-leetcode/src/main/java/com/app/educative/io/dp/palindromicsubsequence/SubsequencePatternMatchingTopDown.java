package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class SubsequencePatternMatchingTopDown {
  private static int findPatternOcc(String str, String pattern) {
    int m = str.length();
    int n = pattern.length();
    Integer[][] dp = new Integer[m][n];
    return findPatternOccRec(str, pattern, dp, 0, 0);
  }

  private static int findPatternOccRec(String str, String pattern, Integer[][] dp, int i1, int i2) {
    if(i2 == pattern.length()) {
      return 1;
    }
    if(i1 == str.length())
      return 0;
    if(dp[i1][i2] == null) {
      int c1 = 0;
      if(str.charAt(i1) == pattern.charAt(i2))
        c1 = findPatternOccRec(str, pattern, dp, i1 + 1, i2 + 1);
      int c2 = findPatternOccRec(str, pattern, dp, i1 + 1, i2);
      dp[i1][i2] = (c1 + c2);
    }
    return dp[i1][i2];
  }

  public static void main(String[] args) {
    System.out.println(findPatternOcc("baxmx", "ax"));
    System.out.println(findPatternOcc("tomorrow", "tor"));
  }
}
