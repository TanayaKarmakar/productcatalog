package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 06/02/23
 * @project ds-algo-2021
 */
public class HappyNumberLeetcode202 {
  private static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    int temp = n;

    while(true) {
      int newNum = 0;
      while(temp != 0) {
        int r = temp % 10;
        newNum = newNum + (r * r);
        temp = temp / 10;
      }

      if(newNum == 1)
        return true;
      if(set.contains(newNum))
        return false;
      temp = newNum;
      set.add(temp);
    }
  }

  public static void main(String[] args) {

  }
}
