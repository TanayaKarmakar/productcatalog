package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 29/09/22
 * @project ds-algo-2021-leetcode
 */
public class SortMatrixDiagonallyLeetcode1329 {
    private static int[][] diagonalSort(int[][] mat) {
        TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int key = (i - j);
                if(!tMap.containsKey(key)) {
                    tMap.put(key, new ArrayList<>());
                }
                tMap.get(key).add(mat[i][j]);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry: tMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int key = (i - j);
                mat[i][j] = tMap.get(key).remove(0);
            }
        }
        return mat;
    }

    public static void main(String[] args) {

    }
}
