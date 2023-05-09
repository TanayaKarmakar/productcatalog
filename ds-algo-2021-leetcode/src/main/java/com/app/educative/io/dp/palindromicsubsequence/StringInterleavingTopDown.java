package com.app.educative.io.dp.palindromicsubsequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 08/05/23
 * @project ds-algo-2021-leetcode
 */
public class StringInterleavingTopDown {
  private static boolean isInterleaving(String m, String n, String p) {
    Map<String, Boolean> dp = new HashMap<>();
    return isInterleavingRec(m, n, p, 0, 0, 0, dp);
  }

  private static boolean isInterleavingRec(String m, String n, String p, int mIndx, int nIndx, int pIndx, Map<String, Boolean> dp) {
    if(mIndx == m.length() && nIndx == n.length() && pIndx == p.length())
      return true;
    if(pIndx == p.length())
      return false;
    String key = mIndx + "|" + nIndx + "|" + pIndx;
    if(!dp.containsKey(key)) {
      boolean b1 = false;
      boolean b2 = false;
      if(mIndx < m.length() && m.charAt(mIndx) == p.charAt(pIndx)) {
        b1 = isInterleavingRec(m, n, p, mIndx + 1, nIndx, pIndx + 1, dp);
      }
      if(nIndx < n.length() && n.charAt(nIndx) == p.charAt(pIndx)) {
        b2 = isInterleavingRec(m, n, p, mIndx, nIndx + 1, pIndx + 1, dp);
      }
      dp.put(key, (b1 || b2));
    }
    return dp.get(key);
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
