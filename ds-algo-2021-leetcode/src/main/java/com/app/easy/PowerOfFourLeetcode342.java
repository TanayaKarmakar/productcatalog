package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class PowerOfFourLeetcode342 {
    private static boolean isPowerOfFour(int n) {
        if(n < 0)
            return false;
        int countOfZeros = 0;
        int countOfOnes = 0;

        int temp = n;
        while(temp != 0) {
            if((temp & 1) == 1) {
                countOfOnes++;
            } else {
                countOfZeros++;
            }
            temp = temp >> 1;
        }
        return (countOfOnes == 1 && countOfZeros % 2 == 0);
    }

    public static void main(String[] args) {

    }
}
