package com.app.easy;


import java.util.Scanner;

/**
 * @author t0k02w6 on 30/10/21
 * @project ds-algo-2021
 */
public class ClimbingStairsLeetcode70 {
    private static int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        stairs[0] = stairs[1] = 1;

        for(int i = 2; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }

        return stairs[n];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = climbStairs(n);

        System.out.println(ans);
        scanner.close();
    }
}
