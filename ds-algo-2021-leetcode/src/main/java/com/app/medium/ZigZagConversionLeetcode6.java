package com.app.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class ZigZagConversionLeetcode6 {
    private static String convert(String s, int numRows) {
        TreeMap<Integer, String> map = new TreeMap<>();
        int level = 0;
        boolean reverse = false;
        for(int i = 0; i < s.length(); i++) {
            if(level == 0) {
                reverse = false;
            } else if(level == numRows - 1) {
                reverse = true;
            }
            if(!map.containsKey(level)) {
                map.put(level, "");
            }
            String ss = map.get(level) + s.charAt(i);
            map.put(level, ss);
            if(reverse) {
                level--;
            } else {
                level++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, String> entry: map.entrySet()) {
            sb.append(entry.getValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";

        String ans = convert(str, 3);

        System.out.println(ans);
    }
}
