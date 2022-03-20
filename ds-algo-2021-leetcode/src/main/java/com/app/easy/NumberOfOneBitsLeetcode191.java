package com.app.easy;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class NumberOfOneBitsLeetcode191 {
    private static int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
