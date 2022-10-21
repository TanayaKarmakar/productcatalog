package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class IntervalIntersectionLeetcode986 {
  private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    if(firstList.length == 0 || secondList.length == 0)
      return new int[][]{};
    List<int[]> result = new ArrayList<>();
    int m = firstList.length;
    int n = secondList.length;
    int mIndx = 0;
    int nIndx = 0;
    while(mIndx < m && nIndx < n) {
      int start = Integer.max(firstList[mIndx][0], secondList[nIndx][0]);
      int end = Integer.min(firstList[mIndx][1], secondList[nIndx][1]);
      if(start <= end) {
        result.add(new int[]{start, end});
      }
      if(firstList[mIndx][1] < secondList[nIndx][1])
        mIndx++;
      else
        nIndx++;
    }
    int[][] finalResult = new int[result.size()][2];
    int j = 0;
    for(int[] current: result) {
      finalResult[j++] = current;
    }
    return finalResult;
  }

  public static void main(String[] args) {
    int[][] firstList = {{0,2},{5,10},{13,23},{24,25}};
    int[][] secondList = {{1,5},{8,12},{15,24},{25,26}};

    int[][] result = intervalIntersection(firstList, secondList);

    for(int i = 0; i < result.length; i++) {
      System.out.println(Arrays.toString(result[i]));
    }
  }
}
