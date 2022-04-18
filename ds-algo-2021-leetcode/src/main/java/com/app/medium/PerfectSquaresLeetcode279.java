package com.app.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 16/04/22
 * @project ds-algo-2021
 */
public class PerfectSquaresLeetcode279 {
    private static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);

        dp[0] = 0;
        for(int i = 1; i <= n; i++) {
            int min = n;
            for(int j = 1; j < i; j++) {
                if((i - j * j) >= 0)
                    min = Integer.min(min, dp[i - j * j]);
            }
            if(min != n)
                dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int ans = numSquares(n);

        System.out.println(ans);

        scanner.close();
    }
}
