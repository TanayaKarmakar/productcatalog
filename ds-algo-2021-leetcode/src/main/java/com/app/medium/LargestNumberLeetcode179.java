package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class LargestNumberLeetcode179 {
  static class NumberComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      String x = o1 + "" + o2;
      String y = o2 + "" + o1;
      return y.compareTo(x);
    }
  }

  private static String largestNumber(int[] nums) {
    List<Integer> numList = new ArrayList<>();

    for(int num: nums) {
      numList.add(num);
    }

    Collections.sort(numList, new NumberComparator());
    StringBuilder sb = new StringBuilder();
    for(Integer el: numList) {
      sb.append(el + "");
    }

    int i = 0;
    while(i < sb.length() && sb.charAt(i) == '0') {
      i++;
    }

    String str = sb.substring(i);
    if(str.isEmpty()) {
      str = "0";
    }

    return str;
  }

  public static void main(String[] args) {
    System.out.println(largestNumber(new int[]{10, 2}));
    System.out.println(largestNumber(new int[]{3,30,34,5,9}));
    System.out.println(largestNumber(new int[]{0, 0}));
  }
}
