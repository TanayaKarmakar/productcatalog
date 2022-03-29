package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 26/03/22
 * @project ds-algo-2021
 */
public class StringCompressionLeetcode443 {
    private static int compress(char[] chars) {
        if(chars.length <= 1)
            return chars.length;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for(char ch: chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            sb.append(entry.getKey());
            sb.append(entry.getValue());
        }
        if(sb.length() < chars.length) {
            chars = new char[sb.length()];
            for(int i = 0; i < sb.length(); i++) {
                chars[i] = sb.charAt(i);
            }
        }

        System.out.println(chars);

        return chars.length;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};

        int len = compress(chars);

        System.out.println(len);
    }
}
