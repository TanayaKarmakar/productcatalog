package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class PalindromicPartitionMemoization {
  private static int minimumCuts(String str) {
    int n = str.length();
    Integer[][] dp = new Integer[n][n];
    return minimumCutsRec(str, dp, 0, n - 1);
  }

  private static int minimumCutsRec(String str, Integer[][] dp, int start, int end) {
    if(start >= end || isPalindrome(str, start, end))
      return 0;
    if(dp[start][end] == null) {
      int minimumCuts = end - start;
      for(int i = start; i <= end; i++) {
        if(isPalindrome(str, start, i)) {
          int currentCuts = 1 + minimumCutsRec(str, dp, i + 1, end);
          minimumCuts = Integer.min(currentCuts + 1, minimumCuts);
        }
      }
      dp[start][end] = minimumCuts;
    }
    return dp[start][end];
  }

  private static boolean isPalindrome(String str, int start, int end) {
    while(start < end) {
      if(str.charAt(start) != str.charAt(end))
        return false;
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(minimumCuts("abdbca"));
    System.out.println(minimumCuts("cddpd"));
    System.out.println(minimumCuts("pqr"));
    System.out.println(minimumCuts("pp"));
  }
}
