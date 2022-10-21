package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 29/09/22
 * @project ds-algo-2021-leetcode
 */
public class GroupShiftedStringsLeetcode249 {
    private static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++) {
            String key = getHash(strings[i]);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(strings[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static String getHash(String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            int val1 = string.charAt(0) - '0';
            int val2 = string.charAt(1) - '0';
            int res = (val2 - val1 + 26) % 26;
            sb.append(res + "").append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
