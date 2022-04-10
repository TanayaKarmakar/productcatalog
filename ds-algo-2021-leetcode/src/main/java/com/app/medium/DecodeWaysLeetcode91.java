package com.app.medium;

import java.util.Scanner;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class DecodeWaysLeetcode91 {
    private static int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0')
            return 0;
        if(s.length() == 1)
            return 1;
        int prevCount = 1;
        int prevPrevCount = 1;

        for(int i = 1; i < s.length(); i++) {
            int count = 0;
            int singleDigit = s.charAt(i) - '0';
            if(singleDigit > 0)
                count += prevCount;

            int doubleDigit = (s.charAt(i - 1) - '0') * 10 + singleDigit;
            if(doubleDigit >= 10 && doubleDigit <= 26)
                count += prevPrevCount;

            prevPrevCount = prevCount;
            prevCount = count;
        }

        return prevCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int ans = numDecodings(input);

        System.out.println(ans);

        scanner.close();
    }
}
