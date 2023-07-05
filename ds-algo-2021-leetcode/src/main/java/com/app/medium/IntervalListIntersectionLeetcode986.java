package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author t0k02w6 on 15/06/23
 * @project ds-algo-2021-leetcode
 */
public class IntervalListIntersectionLeetcode986 {
  private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    List<int[]> result = new ArrayList<>();
    int m = firstList.length;
    int n = secondList.length;

    int i = 0;
    int j = 0;
    while(i < m && j < n) {
      int[] firstListContent = firstList[i];
      int[] secondListContent = secondList[j];
      int start = Integer.max(firstListContent[0], secondListContent[0]);
      int end = Integer.min(firstListContent[1], secondListContent[1]);
      if(start <= end)
        result.add(new int[]{start, end});
      if(firstListContent[1] < secondListContent[1])
        i++;
      else
        j++;
    }
    int[][] finalResult = new int[result.size()][];
    int k = 0;
    for(int[] current: result) {
      finalResult[k++] = current;
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
