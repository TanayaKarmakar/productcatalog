package com.app.easy;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class PowerOfTwoLeetcode231 {
    private static boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        if(n == 1)
            return true;
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

    }
}
