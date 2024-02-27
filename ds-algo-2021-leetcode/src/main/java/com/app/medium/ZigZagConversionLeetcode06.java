package com.app.medium;

import java.util.*;

public class ZigZagConversionLeetcode06 {
    private static String convert(String s, int numRows) {
        TreeMap<Integer, String> map = new TreeMap<>();

        boolean reverse = false;
        int level = 0;

        for(int i = 0; i < s.length(); i++) {
            if(level == 0) {
                reverse = false;
            } else if(level == numRows - 1){
                reverse = true;
            }

            String str = map.getOrDefault(level, "") + s.charAt(i) + "";
            map.put(level, str);

            if(reverse)
                level--;
            else
                level++;
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            sb.append(entry.getValue());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
        System.out.println(convert("A", 2));
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
