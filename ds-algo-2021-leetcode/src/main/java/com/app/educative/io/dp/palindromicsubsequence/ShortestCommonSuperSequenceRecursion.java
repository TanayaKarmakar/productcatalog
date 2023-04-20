package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class ShortestCommonSuperSequenceRecursion {
  private static int scs(String s1, String s2) {
    return scsRec(s1, s2, 0, 0);
  }

  private static int scsRec(String s1, String s2, int i1, int i2) {
    if(i1 == s1.length())
      return s2.length() - i2;
    if(i2 == s2.length())
      return s1.length() - i1;
    if(s1.charAt(i1) == s2.charAt(i2))
      return 1 + scsRec(s1, s2, i1 + 1, i2 + 1);
    int option1 = scsRec(s1, s2, i1 + 1, i2);
    int option2 = scsRec(s1, s2, i1, i2 + 1);
    return 1 + Integer.min(option1, option2);
  }

  public static void main(String[] args) {
    System.out.println(scs("abcf", "bdcf"));
    System.out.println(scs("dynamic", "programming"));
  }
}
