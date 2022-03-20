package com.app.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class CountingBitsLeetcode338 {
    private static int[] countBits(int n) {
        if(n == 0) {
            return new int[]{0};
        }
        int[] dp = new int[n + 1];

        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(i % 2 == 0)
                dp[i] = dp[i/2];
            else
                dp[i] = dp[i - 1] + 1;
        }

        return dp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] ans = countBits(n);

        System.out.println(Arrays.toString(ans));

        scanner.close();
    }
}
