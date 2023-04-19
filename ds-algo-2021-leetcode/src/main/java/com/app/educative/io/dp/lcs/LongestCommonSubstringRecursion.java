package com.app.educative.io.dp.lcs;

/**
 * @author t0k02w6 on 19/04/23
 * @project ds-algo-2021-leetcode
 */
public class LongestCommonSubstringRecursion {
  private static int findLcsLength(String s1, String s2) {
    return lcsRec(s1, s2, 0, 0, 0);
  }

  private static int lcsRec(String s1, String s2, int i, int j, int count) {
    if(i >= s1.length() || j >= s2.length())
      return count;
    if(s1.charAt(i) == s2.charAt(j))
      return lcsRec(s1, s2, i + 1, j + 1, count + 1);

    int c1 = lcsRec(s1, s2, i + 1, j, 0);
    int c2 = lcsRec(s1, s2, i, j + 1, 0);
    return Integer.max(count, Integer.max(c1, c2));
  }

  public static void main(String[] args) {
    System.out.println(findLcsLength("abdca", "cbda"));
    System.out.println(findLcsLength("passport", "ppsspt"));
  }
}
