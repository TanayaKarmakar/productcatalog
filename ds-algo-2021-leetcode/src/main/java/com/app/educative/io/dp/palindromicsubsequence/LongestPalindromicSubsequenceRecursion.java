package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 18/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestPalindromicSubsequenceRecursion {
  private static int lps(String str) {
    return lpsRec(str, 0, str.length() - 1);
  }

  private static int lpsRec(String str, int start, int end) {
    if(start == end)
      return 1;
    if(start > end)
      return 0;
    if(str.charAt(start) == str.charAt(end))
      return 2 + lpsRec(str, start + 1, end - 1);
    int option1 = lpsRec(str, start + 1, end);
    int option2 = lpsRec(str, start, end - 1);
    return Integer.max(option1, option2);
  }

  public static void main(String[] args) {
    System.out.println(lps("abdbca"));
    System.out.println(lps("cddpd"));
    System.out.println(lps("pqr"));
  }
}
