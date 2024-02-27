package com.app.medium;

import java.util.*;

public class LargestNumberLeetcode179 {
    static class NumberComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            String x = String.valueOf(o1);
            String y = String.valueOf(o2);
            return (y + x).compareTo(x + y);
        }
    }

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

        int i = 0;
        while(i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        sb = new StringBuilder(sb.substring(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{10,2}));
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    }
}
