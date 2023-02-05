package com.app.medium;

/**
 * @author t0k02w6 on 27/01/23
 * @project ds-algo-2021
 */
public class ReverseIntegerLeetcode07 {
  private static int reverse(int x) {
    long result = 0;
    boolean isNeg = false;
    if(x < 0) {
      isNeg = true;
    }

    int tmp = Math.abs(x);
    while(tmp != 0) {
      int r = tmp % 10;
      result = result * 10 + r;
      if(result >= Integer.MAX_VALUE) {
        return 0;
      }

      tmp = tmp / 10;
    }

    if(isNeg) {
      result = -result;
    }
    if(result >= Integer.MAX_VALUE)
      return 0;
    return (int)result;
  }

  public static void main(String[] args) {

  }
}
