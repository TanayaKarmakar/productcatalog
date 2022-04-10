package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 10/04/22
 * @project ds-algo-2021
 */
public class LargestNumberLeetcode179 {
    private static String largestNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int n: nums) {
            list.add(n);
        }

        Collections.sort(list, (n1, n2) -> {
            String ss1 = n1 + "" + n2;
            String ss2 = n2 + "" + n1;
            return ss2.compareTo(ss1);
        });

        StringBuilder sb = new StringBuilder();
        for(Integer el: list) {
            sb.append(el);
        }

        int i = 0;
        while(i < sb.length() - 1 && sb.charAt(i) == '0')
            i++;
        StringBuilder sb1 = new StringBuilder();
        sb1.append(sb.substring(i));

        return sb1.toString();
    }

    public static void main(String[] args) {

    }
}
