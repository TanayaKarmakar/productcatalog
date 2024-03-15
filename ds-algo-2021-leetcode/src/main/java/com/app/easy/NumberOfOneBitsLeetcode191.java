package com.app.easy;

public class NumberOfOneBitsLeetcode191 {
    private static int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = (n & (n - 1));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(4));
        System.out.println(hammingWeight(6));
        System.out.println(hammingWeight(7));
    }
}
