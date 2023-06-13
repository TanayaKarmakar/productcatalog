package com.app.medium;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class PowerLeetcode50 {
  private static double myPow(double x, int n) {
    if(n == 0)
      return 1;
    double smallAns = myPow(x, n / 2);
    double ans = smallAns * smallAns;

    if(n % 2 != 0) {
      if(n < 0) {
        ans = (1 / x) * ans;
      } else {
        ans = ans * x;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(myPow(2, 10));
    System.out.println(myPow(2.10000, 3));
    System.out.println(myPow(2.00000, -2));
  }
}
