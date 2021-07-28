package com.app.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 26/07/21
 * @project ds-algo-2021
 */
public class PlusOneLeetcode66 {
    private static int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();

        int carry = 0;
        int n = digits.length;

        int sum = digits[n - 1] + 1;
        if(sum > 9) {
            carry = sum / 10;
            sum = sum % 10;
        }
        result.add(sum);

        for(int i = n - 2; i >= 0; i--) {
            sum = digits[i] + carry;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }
            result.add(0, sum);
        }
        if(carry > 0)
            result.add(0, carry);

        int[] resArr = new int[result.size()];
        int i = 0;
        for(Integer el: result) {
            resArr[i++] = el;
        }
        return resArr;
    }

    public static void main(String[] args) {
        int[] nums = {8,9,9,9};

        int[] output = plusOne(nums);
        System.out.println(Arrays.toString(output));
    }
}
