package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 22/04/23
 * @project ds-algo-2021-leetcode
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
        int num = tMap.get(diff).remove(0);
        mat[i][j] = num;
      }
    }
    return mat;
  }

  public static void main(String[] args) {
    int[][] mat = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};

    mat = diagonalSort(mat);

    for(int i = 0; i < mat.length; i++) {
      System.out.println(Arrays.toString(mat[i]));
    }
  }
}
