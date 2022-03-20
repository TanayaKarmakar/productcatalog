package com.app.easy;

import java.util.Scanner;

/**
 * @author t0k02w6 on 19/03/22
 * @project ds-algo-2021
 */
public class ArrangingCoinsLeetcode441 {
    private static int arrangeCoins(int n) {
        if(n <= 0)
            return 0;

        int i = 1;
        int row = 0;
        while(i <= n) {
            n = n - i;
            row++;
            i++;
        }
        return row;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = arrangeCoins(n);

        System.out.println(ans);

        scanner.close();
    }
}
