package com.app.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author t0k02w6 on 20/06/23
 * @project ds-algo-2021-leetcode
 */
public class PartitionLabelsLeetcode763 {
  private static List<Integer> partitionLabels(String s) {
    List<Integer> result = new ArrayList<>();
    int[] lastIndx = new int[26];

    for(int i = 0; i < s.length(); i++) {
      lastIndx[s.charAt(i) - 'a'] = (i + 1);
    }

    int n = s.length();
    int start = 0;
    int finish = 1;
    while(finish <= n) {
      for(int i = start; i < finish; i++) {
        char ch = s.charAt(i);
        finish = Integer.max(finish, lastIndx[ch - 'a']);
      }
      result.add((finish - start));
      start = finish;
      finish++;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
  }
}
