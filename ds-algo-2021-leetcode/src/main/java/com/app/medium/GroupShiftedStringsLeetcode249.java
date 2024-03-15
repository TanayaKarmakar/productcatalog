package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStringsLeetcode249 {
    private static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> rseult = new ArrayList<>();

        for(String currentString: strings) {
            String key = generateKey(currentString);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(currentString);
        }

        for(Map.Entry<String, List<String>> entry: map.entrySet()) {
            rseult.add(entry.getValue());
        }
        return rseult;
    }

    private static String generateKey(String currentString) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < currentString.length(); i++) {
            int val1 = currentString.charAt(0) - '0';
            int val2 = currentString.charAt(i) - '0';
            int res = (val1 - val2 + 26) % 26;
            sb.append(res).append(" ");
        }
        return sb.toString();
    }


    public static void main(String[] args) {

    }
}
