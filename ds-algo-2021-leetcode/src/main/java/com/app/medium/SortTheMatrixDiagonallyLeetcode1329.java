package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 03/07/23
 * @project ds-algo-2021-leetcode
 */
public class SortTheMatrixDiagonallyLeetcode1329 {
  private static int[][] diagonalSort(int[][] mat) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int m = mat.length;
    int n = mat[0].length;
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int key = (i - j);
        if(!map.containsKey(key))
          map.put(key, new ArrayList<>());
        map.get(key).add(mat[i][j]);
      }
    }

    for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
      Collections.sort(entry.getValue());
    }

    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int key = (i - j);
        int value = map.get(key).remove(0);
        mat[i][j] = value;
      }
    }
    return mat;
  }

  public static void main(String[] args) {

  }
}
