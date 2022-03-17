package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 16/03/22
 * @project ds-algo-2021
 */
public class AddStringsLeetcode415 {
    private static String addStrings(String num1, String num2) {
        if(num1.length() < num2.length())
            return addStrings(num2, num1);
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        char[] result = new char[num1Arr.length + 1];

        int m = num1Arr.length;
        int n = num2Arr.length;
        int i = m - 1; int j = n - 1;
        int sum = 0;
        int carry = 0;
        while(j >= 0) {
            sum = (num1Arr[i] - '0') + (num2Arr[j] - '0') + carry;

            carry = sum / 10;
            sum = sum % 10;
            result[i + 1] = (char)(sum + '0');
            i--;
            j--;
        }

        while(i >= 0) {
            sum = (num1Arr[i] - '0') + carry;
            carry = sum / 10;
            sum = sum % 10;
            result[i + 1] = (char)(sum + '0');
            i--;
        }
        if(carry != 0) {
            result[0] = (char)(carry + '0');
        } else {
            i = 0;
            while(i < result.length - 1 && (result[i] == '0' || !Character.isDigit(result[i]))) {
                i++;
            }
            result = Arrays.copyOfRange(result, i, result.length);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        System.out.println(addStrings("00", "0000"));
        System.out.println(addStrings("123", "11"));
    }
}
