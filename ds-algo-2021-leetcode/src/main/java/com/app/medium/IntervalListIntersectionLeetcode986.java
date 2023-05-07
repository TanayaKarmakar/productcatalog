package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 27/04/23
 * @project ds-algo-2021-leetcode
 */
public class IntervalListIntersectionLeetcode986 {
  private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> list = new ArrayList<>();

    int i = 0;
    int j = 0;
    int m = firstList.length;
    int n = secondList.length;

    while(i < m && j < n) {
      int start = Integer.max(firstList[i][0], secondList[j][0]);
      int end = Integer.min(firstList[i][1], secondList[j][1]);
      if(start <= end) {
        list.add(new int[]{start, end});
      }
      if(firstList[i][1] < secondList[j][1])
        i++;
      else
        j++;
    }

    int[][] result = new int[list.size()][];
    for(i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
