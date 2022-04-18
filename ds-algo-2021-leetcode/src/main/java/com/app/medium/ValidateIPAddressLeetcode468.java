package com.app.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 17/04/22
 * @project ds-algo-2021
 */
public class ValidateIPAddressLeetcode468 {
    private static boolean isDigit(String str) {
        try {
            int val = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private static boolean isIPv4(String str) {
        str = str.trim();
        String[] arr = str.split("\\.");
        if(arr.length != 4)
            return false;
        if(str.charAt(str.length() - 1) == '.')
            return false;
        for(int i = 0; i < arr.length; i++) {
            String currentFragment = arr[i];
            if(!isDigit(currentFragment))
                return false;
            if(currentFragment.length() > 1 && currentFragment.charAt(0) == '0')
                return false;
            Integer val = Integer.parseInt(currentFragment);
            if(val > 255)
                return false;
        }
        return true;
    }

    private static boolean isIPv6(String str) {
        str = str.trim();
        String[] arr = str.split("\\:");
        if(arr.length != 8)
            return false;
        if(str.charAt(str.length() - 1) == ':')
            return false;
        Set<Character> charSet = new HashSet<>();
        for(char i = '0'; i <= '9'; i++) {
            charSet.add(i);
        }
        for(char i = 'A'; i <= 'F'; i++) {
            charSet.add(i);
        }

        for(char i = 'a'; i <= 'f'; i++) {
            charSet.add(i);
        }
        for(String currentFragment: arr) {
            if(currentFragment.length() > 4 || currentFragment.length() < 1)
                return false;
            for(int i = 0; i < currentFragment.length(); i++) {
                char ch = currentFragment.charAt(i);
                if(!charSet.contains(ch))
                    return false;
            }
        }
        return true;
    }

    private static String validIPAddress(String queryIP) {
        if(isIPv4(queryIP))
            return "IPv4";
        else if(isIPv6(queryIP))
            return "IPv6";
        return "Neither";
    }

    public static void main(String[] args) {
        String str = "2001:0db8:85a3:0:0:8A2E:0370:7334:";

        String ans = validIPAddress(str);

        System.out.println(ans);
    }
}
