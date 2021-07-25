package com.app.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author t0k02w6 on 25/07/21
 * @project ds-algo-2021
 */
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

        if(s.length() == 1)
            return map.get(s.charAt(0));

        int n = s.length();
        int res = map.get(s.charAt(n - 1));
        for(int i = n - 2; i >= 0; i--) {
            char next = s.charAt(i + 1);
            char curr = s.charAt(i);
            if(map.get(curr) < map.get(next))
                res -= map.get(curr);
            else
                res += map.get(curr);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int ans = romanToInt(s);

        System.out.println(ans);

        scanner.close();

    }
}
