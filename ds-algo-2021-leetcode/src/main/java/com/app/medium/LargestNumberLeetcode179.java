package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
class NumberComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        String x = String.valueOf(o1);
        String y = String.valueOf(o2);
        return (y + x).compareTo(x + y);
    }
}

public class LargestNumberLeetcode179 {
    private static String largestNumber(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for(int num: nums) {
            numList.add(num);
        }

        Collections.sort(numList, new NumberComparator());

        StringBuilder sb = new StringBuilder();
        for(Integer el: numList) {
            sb.append(el);
        }
        String str = sb.toString();
        int i = 0;
        while(i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        str = str.substring(i);
        if(str.isEmpty()) {
            str = "0";
        }
        return str;
    }

    public static void main(String[] args) {

    }
}
