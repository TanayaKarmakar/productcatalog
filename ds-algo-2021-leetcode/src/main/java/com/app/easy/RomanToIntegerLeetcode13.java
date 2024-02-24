package com.app.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegerLeetcode13 {
    private static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        int sum = 0;
        int n = s.length();
        int i = n - 1;
        sum = map.get(s.charAt(i));
        i--;
        while(i >= 0) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
            i--;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}
