package com.app.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class LongestPalindromeLeetcode409 {
    private static int longestPalindrome(String s) {
        Map<Character, Integer> charMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            charMap.put(ch, charMap.getOrDefault(ch, 0) + 1);
        }

        int len = 0;
        int oddCount = 0;
        for(Map.Entry<Character, Integer> entry: charMap.entrySet()) {
            if(entry.getValue() % 2 == 0) {
                len += entry.getValue();
            } else {
                if(oddCount == 0) {
                    oddCount++;
                    len += entry.getValue();
                } else {
                    len += entry.getValue() - 1;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {

    }
}
