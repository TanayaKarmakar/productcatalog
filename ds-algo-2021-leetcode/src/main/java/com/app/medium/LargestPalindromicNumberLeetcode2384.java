package com.app.medium;

import java.util.*;

public class LargestPalindromicNumberLeetcode2384 {
    private static String largestPalindromic(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < num.length(); i++) {
            int currentNum = num.charAt(i) - '0';
            map.put(currentNum, map.getOrDefault(currentNum, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());

        Collections.sort(keys);

        if(keys.size() == 1) {
            int value = map.get(keys.get(0));
            if(keys.get(0) != 0) {
                return String.join("", keys.get(0) + "").repeat(value);
            } else {
                return "0";
            }
        }
        if(keys.size() == 2) {
            int value = map.get(keys.get(1));
            if(value == 1 && keys.get(0) == 0) {
                return keys.get(1) + "";
            }
        }

        StringBuilder left = new StringBuilder();
        StringBuilder right = new StringBuilder();
        for(int i = keys.size() - 1; i >= 0; i--) {
            int current = keys.get(i);
            int value = map.get(current);
            if(value > 1) {
                if(value % 2 == 0) {
                    map.remove(current);
                } else {
                    value--;
                    map.put(current, 1);
                }
                int half = value / 2;
                int count = 0;
                while(count < half) {
                    left.append(current);
                    right.append(current);
                    count++;
                }
            }
        }

        if(!map.isEmpty()) {
            for(int i = keys.size() - 1; i >= 0; i--) {
                if(map.containsKey(keys.get(i))) {
                    left.append(keys.get(i));
                    break;
                }
            }
        }
        String str = left.append(right.reverse()).toString();
        int start = 0;
        int end = str.length() - 1;
        while(str.charAt(start) == '0') {
            start++;
            end--;
        }
        return str.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(largestPalindromic("00001105"));
        System.out.println(largestPalindromic("444947137"));
        System.out.println(largestPalindromic("00009"));
    }
}
