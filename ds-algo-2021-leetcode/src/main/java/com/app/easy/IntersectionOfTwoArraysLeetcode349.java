package com.app.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author t0k02w6 on 17/03/22
 * @project ds-algo-2021
 */
public class IntersectionOfTwoArraysLeetcode349 {
    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        int len = Integer.min(nums1.length, nums2.length);
        int[] finalArray = new int[len];
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        int k = 0;
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                finalArray[k++] = nums2[i];
                set.remove(nums2[i]);
            }
        }
        return Arrays.copyOfRange(finalArray, 0, k);
    }

    public static void main(String[] args) {

    }
}
