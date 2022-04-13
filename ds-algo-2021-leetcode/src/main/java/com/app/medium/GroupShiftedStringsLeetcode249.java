package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */


public class GroupShiftedStringsLeetcode249 {
    private static String getHash(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            int val1 = str.charAt(i) - '0';
            int val2 = str.charAt(0) - '0';
            int result = (val1 - val2 + 26) % 26;
            sb.append(result).append(" ");
        }
        return sb.toString();
    }

    private static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strings) {
            String key = getHash(str);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        List<List<String>> values = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            List<String> curr = entry.getValue();
            values.add(curr);
        }
        return values;
    }



    public static void main(String[] args) {

    }
}
