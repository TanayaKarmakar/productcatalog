package com.app.easy;

public class SqrtLeetcode69 {
    private static int mySqrt(int x) {
        if(x <= 1)
            return x;
        long start = 1;
        long end = x;
        long finalAns = 0;

        while(start <= end) {
            long mid = (start + end) >> 1;
            if(mid * mid == x)
                return (int)mid;
            else if(mid * mid > x)
                end = mid - 1;
            else {
                finalAns = mid;
                start = mid + 1;
            }
        }
        return  (int)finalAns;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
    }
}
