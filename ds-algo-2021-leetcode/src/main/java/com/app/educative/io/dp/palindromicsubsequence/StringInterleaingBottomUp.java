package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 08/05/23
 * @project ds-algo-2021-leetcode
 */
public class StringInterleaingBottomUp {
  private static boolean isInterleaving(String m, String n, String p) {
    int mLen  = m.length();
    int nLen = n.length();
    boolean[][] dp = new boolean[mLen + 1][nLen + 1];

    dp[0][0] = true;
    for(int mIndx = 1; mIndx <= mLen; mIndx++) {
      if(m.charAt(mIndx - 1) == p.charAt(mIndx - 1)) {
        dp[mIndx][0] = dp[mIndx - 1][0];
      }
    }

    for(int nIndx = 1; nIndx <= nLen; nIndx++) {
      if(n.charAt(nIndx - 1) == p.charAt(nIndx - 1)) {
        dp[0][nIndx] = dp[0][nIndx - 1];
      }
    }

    for(int mIndx = 1; mIndx <= mLen; mIndx++) {
      for(int nIndx = 1; nIndx <= nLen; nIndx++) {
        if(m.charAt(mIndx - 1) == p.charAt(mIndx + nIndx - 1))
          dp[mIndx][nIndx] = dp[mIndx - 1][nIndx];

        if(n.charAt(nIndx - 1) == p.charAt(mIndx + nIndx - 1))
          dp[mIndx][nIndx] |= dp[mIndx][nIndx - 1];
      }
    }
    return dp[mLen][nLen];
  }

  public static void main(String[] args) {
    String m = "abd";
    String n = "cef";
    String p = "abcdef";

    System.out.println(isInterleaving(m, n, p));

    m = "abd";
    n = "cef";
    p = "adcbef";

    System.out.println(isInterleaving(m, n, p));
  }
}
