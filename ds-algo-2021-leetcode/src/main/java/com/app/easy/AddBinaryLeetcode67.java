package com.app.easy;

import java.util.Arrays;

/**
 * @author t0k02w6 on 18/03/22
 * @project ds-algo-2021
 */
public class AddBinaryLeetcode67 {
    private static String addBinary(String a, String b) {
        if(a.length() < b.length())
            return addBinary(b,a);
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();

        char[] finalArray = new char[aArr.length + 1];

        int m = a.length() - 1;
        int n = b.length() - 1;
        int i = m;
        int j = n;
        int k = finalArray.length - 1;

        int carry = 0;
        while(i >= 0 && j >= 0) {
            int num1 = aArr[i] - '0';
            int num2 = bArr[j] - '0';
            int sum = 0;
            if(num1 == 0 && num2 == 0) {
                sum += carry;
                carry = 0;
            } else if(num1 == 1 && num2 == 1) {
                if(carry != 0) {
                    sum = 1;
                }
                carry = 1;
            } else {
                if(carry == 0) {
                    sum = 1;
                }
            }
            finalArray[k--] = (char)(sum + '0');
            i--;
            j--;
        }

        while(i >= 0) {
            int num1 = aArr[i] - '0';
            int sum = 0;
            if(num1 == 1) {
                if(carry == 0) {
                    sum = 1;
                }
            } else {
                if(carry != 0) {
                    sum = 1;
                    carry = 0;
                }
            }
            finalArray[k--] = (char)(sum + '0');
            i--;
        }
        if(carry != 0) {
            finalArray[0] = (char)(carry + '0');
            return new String(finalArray);
        }
        else {
            i = 0;
            while(i < finalArray.length - 1  && finalArray[i] != '1')
                i++;
            return new String(Arrays.copyOfRange(finalArray, i, finalArray.length));
        }
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
