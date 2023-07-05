package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 25/06/23
 * @project ds-algo-2021-leetcode
 */
public class DiagonalTraverseLeetcode498 {
  private static int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        int key = (i + j);
        if(!map.containsKey(key))
          map.put(key, new ArrayList<>());
        map.get(key).add(mat[i][j]);
      }
    }

    List<Integer> result = new ArrayList<>();
    int firstEntry = map.firstKey();
    int lastEntry = map.lastKey();
    boolean rev = true;
    for(int i = firstEntry; i <= lastEntry; i++) {
      List<Integer> values = map.get(i);
      if(rev) {
        Collections.reverse(values);
      }
      result.addAll(values);
      rev = !rev;
    }
    int[] finalResult = new int[result.size()];
    for(int i = 0; i < result.size(); i++) {
      finalResult[i] = result.get(i);
    }
    return finalResult;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
    int[] finalResult = findDiagonalOrder(grid);

    System.out.println(Arrays.toString(finalResult));
  }
}
