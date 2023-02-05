package com.app.medium;

/**
 * @author t0k02w6 on 02/02/23
 * @project ds-algo-2021
 */
public class PowerLeetcode50 {
  private static double myPow(double x, int n) {
    if(n == 0)
      return 1;
    if(n == 1)
      return x;
    double ans = myPow(x, n / 2);
    if(n % 2 == 0) {
      return (ans * ans);
    }
    else {
      if(n > 0)
        return x * (ans * ans);
      return (1/ x) * (ans * ans);
    }
  }

  public static void main(String[] args) {

  }
}
