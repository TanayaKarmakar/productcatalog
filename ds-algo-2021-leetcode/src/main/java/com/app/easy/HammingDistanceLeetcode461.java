package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class HammingDistanceLeetcode461 {
    private static int hammingDistance(int x, int y) {
        if(x < y)
            return hammingDistance(y, x);

        int ans = 0;
        while(x != 0 && y != 0) {
            if((x & 1) != (y & 1)) {
                ans++;
            }
            x = x >> 1;
            y = y >> 1;
        }

        while(x != 0) {
            if((x & 1) == 1) {
                ans++;
            }
            x = x >> 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
