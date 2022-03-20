package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 20/03/22
 * @project ds-algo-2021
 */
public class PlusOneLeetcode66 {
    private static int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] result = new int[n + 1];
        int sum = digits[n - 1] + 1;
        int carry = sum / 10;
        sum = sum % 10;

        result[n] = sum;

        for(int i = n - 2; i >= 0; i--) {
            sum = digits[i] + carry;
            carry = sum / 10;
            sum = sum % 10;
            result[i + 1] = sum;
        }
        if(carry != 0) {
            result[0] = carry;
        } else {
            int i = 0;
            while(i < result.length - 1 && result[i] == 0) {
                i++;
            }
            result = Arrays.copyOfRange(result, i, result.length);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
