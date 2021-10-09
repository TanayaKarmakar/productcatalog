package com.app.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author t0k02w6 on 26/07/21
 * @project ds-algo-2021
 */
public class LongestSubstringWithoutRepeatingCharsLeetcode03 {
    private static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();
        Map<Character, Integer> map = new HashMap<>();

        int maxLen = 0;

        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                j = Integer.max(map.get(ch), j);
            }
            maxLen = Integer.max(maxLen, (i - j) + 1);
            map.put(ch, i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        System.out.println(lengthOfLongestSubstring(str));

        scanner.close();
    }
}
