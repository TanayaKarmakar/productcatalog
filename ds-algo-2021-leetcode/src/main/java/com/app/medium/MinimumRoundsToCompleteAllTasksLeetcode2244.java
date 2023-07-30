package com.app.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 05/07/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumRoundsToCompleteAllTasksLeetcode2244 {
  private static int minimumRounds(int[] tasks) {
    TreeMap<Integer, Integer> tMap = new TreeMap<>();
    for(int task: tasks) {
      tMap.put(task, tMap.getOrDefault(task, 0) + 1);
    }

    int count = 0;
    while(tMap.size() > 0) {
      Map.Entry<Integer, Integer> firstEntry = tMap.firstEntry();
      if(firstEntry.getValue() == 2 || firstEntry.getValue() == 3) {
        tMap.remove(firstEntry.getKey());
      } else {
        if(firstEntry.getValue() < 2)
          return -1;
        int value = firstEntry.getValue() - 3;
        if(value < 2)
          value = firstEntry.getValue() - 2;
        tMap.put(firstEntry.getKey(), value);
      }
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    int[] tasks = {2,2,3,3,2,4,4,4,4,4};
    int ans = minimumRounds(tasks);

    System.out.println(ans);
  }
}
