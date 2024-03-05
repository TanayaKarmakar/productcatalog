package com.app.easy;

public class PowerOfFourLeetcode342 {
    private static boolean isPowerOfFour(int n) {
        int temp = n;
        int numZeros = 0;
        int numOnes = 0;
        while(temp != 0) {
            if((temp & 1) == 0) {
                numZeros++;
            } else {
                numOnes++;
                if(numOnes > 1)
                    return false;
            }
            temp = temp >> 1;
        }
        return numZeros % 2 == 0 && numOnes == 1;
    }

    public static void main(String[] args) {

    }
}
