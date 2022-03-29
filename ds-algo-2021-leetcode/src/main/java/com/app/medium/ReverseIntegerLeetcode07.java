package com.app.medium;

/**
 * @author t0k02w6 on 28/03/22
 * @project ds-algo-2021
 */
public class ReverseIntegerLeetcode07 {
    private static int reverse(int x) {
        if(x == 0 || x == Integer.MIN_VALUE)
            return 0;
        boolean isNeg = false;
        if(x < 0) {
            isNeg = true;
            x = Math.abs(x);
        }


        long res = 0;
        while(x != 0) {
            res = res * 10 + (x % 10);
            x = x / 10;
            if(res >= Integer.MAX_VALUE)
                return 0;
        }

        if(isNeg)
            res = -res;
        if(res >= Integer.MAX_VALUE)
            return 0;
        return (int)res;
    }

    public static void main(String[] args) {
        int x = 123;
        int ans = reverse(x);

        System.out.println(ans);
    }
}
