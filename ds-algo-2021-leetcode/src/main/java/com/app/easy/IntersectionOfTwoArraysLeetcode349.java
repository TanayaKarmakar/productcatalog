package com.app.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysLeetcode349 {
    private static int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();

        for(int el: nums1) {
            map.put(el, false);
        }

        for(int el: nums2) {
            if(map.containsKey(el) && !map.get(el)) {
                intersection.add(el);
                map.put(el, true);
            }
        }

        int[] result = new int[intersection.size()];
        for(int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
