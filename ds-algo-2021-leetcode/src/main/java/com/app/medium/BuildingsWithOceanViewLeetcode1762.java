package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 21/04/23
 * @project ds-algo-2021-leetcode
 */
public class BuildingsWithOceanViewLeetcode1762 {
  private static int[] findBuildings(int[] heights) {
    List<Integer> oceanViewAvail = new ArrayList<>();
    int n = heights.length;
    int maxNumber = heights[n - 1];
    oceanViewAvail.add((n - 1));

    for(int i = n - 2; i >= 0; i--) {
      if(heights[i] > maxNumber) {
        maxNumber = heights[i];
        oceanViewAvail.add(0, i);
      }
    }

    int size = oceanViewAvail.size();
    int[] result = new int[size];
    int j = 0;
    for(Integer el: oceanViewAvail) {
      result[j++] = el;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(findBuildings(new int[]{4,2,3,1})));
    System.out.println(Arrays.toString(findBuildings(new int[]{4,3,2,1})));
  }
}
