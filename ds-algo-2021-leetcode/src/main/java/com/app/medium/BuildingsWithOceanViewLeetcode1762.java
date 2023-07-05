package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 28/06/23
 * @project ds-algo-2021-leetcode
 */
public class BuildingsWithOceanViewLeetcode1762 {
  private static int[] findBuildings(int[] heights) {
    List<Integer> oceanViewAvail = new ArrayList<>();
    int n = heights.length;
    oceanViewAvail.add((n - 1));
    int max = heights[n - 1];

    for(int i = n - 2; i >= 0; i--) {
      if(heights[i] > max) {
        oceanViewAvail.add(0, i);
        max = heights[i];
      }
    }

    int []finalResult = new int[oceanViewAvail.size()];
    for(int i = 0; i < oceanViewAvail.size(); i++) {
      finalResult[i] = oceanViewAvail.get(i);
    }
    return finalResult;
  }

  public static void main(String[] args) {
    int[] heights = {4,2,3,1};
    int[] result = findBuildings(heights);

    System.out.println(Arrays.toString(result));
  }
}
