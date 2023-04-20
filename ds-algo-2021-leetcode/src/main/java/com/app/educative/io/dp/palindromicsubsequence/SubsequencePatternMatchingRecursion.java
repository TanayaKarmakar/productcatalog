package com.app.educative.io.dp.palindromicsubsequence;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class SubsequencePatternMatchingRecursion {
  private static int findPatternOcc(String str, String pattern) {
    return findPatternOccRec(str, pattern, 0, 0);
  }

  private static int findPatternOccRec(String str, String pattern, int i1, int i2) {
    if(i2 ==pattern.length())
      return 1;
    if(i1 == str.length())
      return 0;
    int c1 = 0;
    if(str.charAt(i1) == pattern.charAt(i2))
      c1 = findPatternOccRec(str, pattern, i1 + 1, i2 + 1);
    int c2 = findPatternOccRec(str, pattern, i1 + 1, i2);
    return c1 + c2;
  }

  public static void main(String[] args) {
    System.out.println(findPatternOcc("baxmx", "ax"));
    System.out.println(findPatternOcc("tomorrow", "tor"));
  }
}
