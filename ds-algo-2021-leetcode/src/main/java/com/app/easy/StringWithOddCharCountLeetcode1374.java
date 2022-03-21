package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class StringWithOddCharCountLeetcode1374 {
    private static String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++) {
            sb.append('a');
        }
        if(n % 2 != 0)
            sb.append('a');
        else
            sb.append('b');
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
