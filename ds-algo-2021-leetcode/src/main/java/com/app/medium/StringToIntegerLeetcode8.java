package com.app.medium;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class StringToIntegerLeetcode8 {
    private static int myAtoi(String s) {
        String ss = s.trim().split("\\s+")[0];
        if(ss.isEmpty())
            return 0;
        boolean isNeg = false;

        if(ss.charAt(0) == '+' || ss.charAt(0) == '-') {
            if(ss.charAt(0) == '-') {
                isNeg = true;
            }
            ss = ss.substring(1);
        }

        if(ss.isEmpty() || !Character.isDigit(ss.charAt(0)))
            return 0;
        long result = 0;
        for(char ch: ss.toCharArray()) {
            if(Character.isDigit(ch)) {
                result = result * 10 + (ch - '0');
                if(result >= Integer.MAX_VALUE)
                    break;
            } else
                break;

        }

        if(isNeg)
            result = -result;
        if(result >= Integer.MAX_VALUE)
            result = Integer.MAX_VALUE;
        if(result < Integer.MIN_VALUE)
            result = Integer.MIN_VALUE;
        return (int) result;
    }

    public static void main(String[] args) {

    }
}
