package com.app.educative.io.dp.fibonacci;

public class FibonacciNumber {
    private static int findNthFibonacci(int n) {
        int[] fib = new int[n + 1];
        fib[1] = 1;

        for(int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    public static void main(String[] args) {

    }
}
