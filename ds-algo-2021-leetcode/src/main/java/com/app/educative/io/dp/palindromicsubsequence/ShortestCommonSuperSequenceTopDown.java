package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class ShortestCommonSuperSequenceTopDown {
  private static int scs(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    Integer[][] dp = new Integer[m][n];
    return scsTopDown(s1, s2, dp, 0, 0);
  }

  private static int scsTopDown(String s1, String s2, Integer[][] dp, int i1, int i2) {
    if(i1 == s1.length())
      return s2.length() - i2;
    if(i2 == s2.length())
      return s1.length() - i1;
    if(dp[i1][i2] == null) {
      if(s1.charAt(i1) == s2.charAt(i2)) {
        dp[i1][i2] = 1 + scsTopDown(s1, s2, dp, i1 + 1, i2 + 1);
      } else {
        int option1 = scsTopDown(s1, s2, dp, i1 + 1, i2);
        int option2 = scsTopDown(s1, s2, dp, i1, i2 + 1);
        dp[i1][i2] = 1 + Integer.min(option1, option2);
      }
    }
    return dp[i1][i2];
  }

  public static void main(String[] args) {
    System.out.println(scs("abcf", "bdcf"));
    System.out.println(scs("dynamic", "programming"));
  }
}
