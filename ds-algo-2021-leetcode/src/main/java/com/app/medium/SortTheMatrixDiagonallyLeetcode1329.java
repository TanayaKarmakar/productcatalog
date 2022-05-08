package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 07/05/22
 * @project ds-algo-2021
 */
public class SortTheMatrixDiagonallyLeetcode1329 {
    private static int[][] diagonalSort(int[][] mat) {
        TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();

        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int diff = (i - j);
                if(!tMap.containsKey(diff)) {
                    tMap.put(diff, new ArrayList<>());
                }
                tMap.get(diff).add(mat[i][j]);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry: tMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int diff = (i - j);
                mat[i][j] = tMap.get(diff).remove(0);
            }
        }

        return mat;
    }

    public static void main(String[] args) {

    }
}
