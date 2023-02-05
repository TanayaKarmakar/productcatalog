package com.app.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 31/01/23
 * @project ds-algo-2021
 */
public class PascalsTriangleLeetcode118 {
  private static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> row = new ArrayList<>();
    row.add(1);
    results.add(row);

    for(int i = 1; i < numRows; i++) {
      row = new ArrayList<>();
      for(int j = 0; j <= i; j++) {
        if(j == 0 || j == i) {
          row.add(1);
        } else {
          row.add(results.get(i - 1).get(j - 1) + results.get(i - 1).get(j));
        }
      }
      results.add(row);
    }
    return results;
  }

  public static void main(String[] args) {

  }
}
