package com.app.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 30/10/21
 * @project ds-algo-2021
 */
public class CountingBitsLeetcode338 {
    private static int[] countBits(int n) {
        int[] counts = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 0)
                counts[i] = counts[i / 2];
            else
                counts[i] = counts[i - 1] + 1;
        }
        return counts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] counts = countBits(n);

        System.out.println(Arrays.toString(counts));
    }
}
