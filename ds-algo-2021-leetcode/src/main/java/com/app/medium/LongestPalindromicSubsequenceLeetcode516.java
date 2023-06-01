package com.app.medium;

/**
 * @author t0k02w6 on 23/05/23
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubsequenceLeetcode516 {
  private static int longestPalindromeSubseq(String s) {
    int n = s.length();
    Integer[][] dp = new Integer[n][n];
    for(int i = 0; i < n; i++) {
      dp[i][i] = 1;
    }
    lpsRec(s, 0, n - 1, dp);
    return dp[0][n - 1];
  }

  private static int lpsRec(String s, int start, int end, Integer[][] dp) {
    if(start > end)
      return 0;
    if(dp[start][end] == null) {
      if(s.charAt(start) == s.charAt(end)) {
        dp[start][end] = 2 + lpsRec(s, start + 1, end - 1, dp);
      } else {
        int option1 = lpsRec(s, start + 1, end, dp);
        int option2 = lpsRec(s, start, end - 1, dp);
        dp[start][end] = Integer.max(option1, option2);
      }
    }
    return dp[start][end];
  }


  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("bbbab"));
    System.out.println(longestPalindromeSubseq("cbbd"));
  }
}
