package com.app.medium;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author t0k02w6 on 13/04/22
 * @project ds-algo-2021
 */
public class CountPrimesLeetcode204 {
    private static int countPrimes(int n) {
        if(n <= 1)
            return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i = 2; i * i < n; i++) {
            if(isPrime[i]) {
                int j = i;
                while((i * j) < n) {
                    if(isPrime[i * j]) {
                        isPrime[i * j] = false;
                    }
                    j++;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int ans = countPrimes(n);

        System.out.println(ans);
        scanner.close();
    }
}
