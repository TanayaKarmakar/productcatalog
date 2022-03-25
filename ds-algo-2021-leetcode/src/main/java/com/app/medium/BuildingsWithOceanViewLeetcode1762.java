package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 25/03/22
 * @project ds-algo-2021
 */
public class BuildingsWithOceanViewLeetcode1762 {
    private static int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();

        int n = heights.length;
        int max = heights[n - 1];
        list.add((n - 1));

        for(int i = n - 2; i >= 0; i--) {
            if(heights[i] > max) {
                list.add(0, i);
                max = heights[i];
            }
        }

        int[] result = new int[list.size()];
        int i = 0;
        for(Integer el: list) {
            result[i++] = el;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
