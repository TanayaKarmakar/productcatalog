package com.app.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class HappyNumberLeetcode202 {
    private static int extractNumber(int n) {
        int val = 0;
        while(n != 0) {
            int r = (n % 10);
            val += (r * r);
            n = n / 10;
        }
        return val;
    }

    private static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        int temp = n;
        while(true) {
            int val = extractNumber(temp);

            if(val == 1)
                return true;
            if(set.contains(val))
                return false;
            set.add(val);
            temp = val;
        }

    }


    public static void main(String[] args) {

    }
}
