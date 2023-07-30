package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class NumbersWithConsecutiveDifferenceLeetcode967 {
  private static int[] numsSameConsecDiff(int n, int k) {
    Queue<String> q = new LinkedList<>();

    for(int i = 1; i <= 9; i++) {
      q.add(i + "");
    }

    int j = 2;
    List<Integer> intermediateList = new ArrayList<>();
    while(!q.isEmpty() && j <= n) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        String item = q.poll();

        int lastItem = item.charAt(item.length() - 1) - '0';
        if(lastItem - k >= 0 && lastItem - k <= 9) {
          char ch = (char)((lastItem - k) + '0');
          q.add(item + ch);
        }

        if(k != 0) {
          if(lastItem + k >= 0 && lastItem + k <= 9) {
            char ch = (char) ((lastItem + k) + '0');
            q.add(item + ch);
          }
        }
      }
      j++;
    }

    int[] result = new int[q.size()];
    int i = 0;
    while(!q.isEmpty()) {
      result[i++] = Integer.parseInt(q.poll());
    }
    return result;
  }

  public static void main(String[] args) {
    int[] result = numsSameConsecDiff(3, 7);

    System.out.println(Arrays.toString(result));
  }
}
