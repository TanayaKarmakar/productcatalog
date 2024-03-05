package com.app.medium;

import java.util.Arrays;

public class CountPrimesLeetcode204 {
    private static int countPrimes(int n) {
        if(n <= 1)
            return 1;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for(int i = 2; i * i < n; i++) {
            int j = i;
            while(i * j < n) {
                isPrime[i * j] = false;
                j++;
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
            if(isPrime[i])
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

    }
}
