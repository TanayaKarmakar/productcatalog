package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */
public class PowerLeetcode50 {
    private static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        double smallValue = myPow(x, n / 2);
        if(n % 2 != 0) {
            if(n < 0)
                return (1 / x) * smallValue * smallValue;
            else
                return x * smallValue * smallValue;
        } else {
            return smallValue * smallValue;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextDouble();
        int n = scanner.nextInt();

        double ans = myPow(x, n);

        System.out.println(ans);
    }
}
