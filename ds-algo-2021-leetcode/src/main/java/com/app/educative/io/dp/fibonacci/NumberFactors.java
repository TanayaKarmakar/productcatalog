package com.app.educative.io.dp.fibonacci;

public class NumberFactors {
    private static int totalWays(int n) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 1;
        int n3 = 2;

        for(int i = 4; i <= n; i++) {
            int sum = n0 + n1 + n3;
            n0 = n1;
            n1 = n2;
            n2 = n3;
            n3 = sum;
        }

        return n3;
    }

    public static void main(String[] args) {
        System.out.println(totalWays(4));
        System.out.println(totalWays(5));
    }
}
