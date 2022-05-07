package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 03/05/22
 * @project ds-algo-2021
 */
public class PaintFenceLeetcode276 {
    private static int numWays(int n, int k) {
        if(n == 1)
            return k;
        if(n == 2)
            return (k * k);
        int prevSame = k;
        int prevDiff = k * (k - 1);
        int total = 0;
        for(int i = 3; i <= n; i++) {
            total = prevSame + prevDiff;
            int currentSame = prevDiff;
            int currentDiff = total * (k - 1);
            prevSame = currentSame;
            prevDiff = currentDiff;
        }

        total = prevDiff + prevSame;
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int ans = numWays(n, k);
        System.out.println(ans);

        scanner.close();
    }
}
