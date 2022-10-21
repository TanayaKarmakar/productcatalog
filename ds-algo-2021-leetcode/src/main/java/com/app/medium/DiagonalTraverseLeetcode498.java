package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 25/09/22
 * @project ds-algo-2021-leetcode
 */
public class DiagonalTraverseLeetcode498 {
    private static int[] findDiagonalOrder(int[][] mat) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int current = (i + j);
                if(!map.containsKey(current)) {
                    map.put(current, new ArrayList<>());
                }
                map.get(current).add(mat[i][j]);
            }
        }

        int total = m * n;
        int[] result = new int[total];
        boolean reverse = true;
        int k = 0;
        for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if(reverse) {
                Collections.reverse(entry.getValue());
            }
            for(Integer el: entry.getValue()) {
                result[k++] = el;
            }
            reverse = !reverse;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
