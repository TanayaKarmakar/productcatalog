package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubsequenceTopDown {
  private static int lps(String str) {
    int n = str.length();
    Integer[][] dp = new Integer[n][n];
    return lpsRec(str, dp, 0, str.length() - 1);
  }

  private static int lpsRec(String str, Integer[][] dp, int start, int end) {
    if(start == end)
      return 1;
    if(start > end)
      return 0;
    if(dp[start][end] == null) {
      if(str.charAt(start) == str.charAt(end)) {
        dp[start][end] = 2 + lpsRec(str, dp, start + 1, end - 1);
      } else {
        int option1 = lpsRec(str, dp, start + 1, end);
        int option2 = lpsRec(str, dp, start, end - 1);
        dp[start][end] = Integer.max(option1, option2);
      }
    }
    return dp[start][end];
  }


  public static void main(String[] args) {
    System.out.println(lps("abdbca"));
    System.out.println(lps("cddpd"));
    System.out.println(lps("pqr"));
  }
}
