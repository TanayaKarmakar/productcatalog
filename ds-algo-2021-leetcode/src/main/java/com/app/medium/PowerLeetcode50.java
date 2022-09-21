package com.app.medium;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class PowerLeetcode50 {
    private static double myPow(double x, int n) {
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        double smallValue = myPow(x, n / 2);
        if(n % 2 == 0) {
            return smallValue * smallValue;
        } else {
            if(n > 0) {
                return x * smallValue * smallValue;
            } else {
                return (1/x) * smallValue * smallValue;
            }
        }

    }

    public static void main(String[] args) {

    }
}
