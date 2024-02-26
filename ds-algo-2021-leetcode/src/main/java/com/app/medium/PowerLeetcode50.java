package com.app.medium;

public class PowerLeetcode50 {
    private static double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return x;
        double value = myPow(x, n / 2);
        if(n % 2 == 0)
            return value * value;
        else {
            if(n < 0) {
                x = 1/x;
            }
            return x * value * value;
        }
    }



    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
        System.out.println(myPow(2, -2));
    }
}
