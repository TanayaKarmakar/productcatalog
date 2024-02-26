package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildingsWithOceanViewLeetcode1762 {
    private static int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int n = heights.length;
        int max = heights[n - 1];
        list.add(n - 1);

        for(int i = n - 2; i >= 0; i--) {
            if(heights[i] > max) {
                max = heights[i];
                list.add(0, i);
            }
        }

        int size = list.size();
        int[] result = new int[size];
        for(int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] heights = {4,2,3,1};

        int[] ans = findBuildings(heights);

        System.out.println(Arrays.toString(ans));
    }
}
