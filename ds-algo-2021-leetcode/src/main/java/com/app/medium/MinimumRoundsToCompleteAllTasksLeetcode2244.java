package com.app.medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 31/05/23
 * @project ds-algo-2021-leetcode
 */
public class MinimumRoundsToCompleteAllTasksLeetcode2244 {
  private static int minimumRounds(int[] tasks) {
    TreeMap<Integer, Integer> difficultyMap = new TreeMap<>();

    for(int i = 0; i < tasks.length; i++) {
      difficultyMap.put(tasks[i], difficultyMap.getOrDefault(tasks[i], 0) + 1);
    }

    int count = 0;
    while(!difficultyMap.isEmpty()) {
      Map.Entry<Integer, Integer> entry = difficultyMap.firstEntry();
      if(entry.getValue() < 2)
        return -1;
      if(entry.getValue() == 2 || entry.getValue() == 3) {
        count++;
        difficultyMap.remove(entry.getKey());
      } else {
        int value = entry.getValue() - 3;
        if(value < 2) {
          value = entry.getValue() - 2;
        }
        difficultyMap.put(entry.getKey(), value);
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,3,3,2,4,4,4,4,4};
    int ans = minimumRounds(nums);

    System.out.println(ans);

    nums = new int[]{2,3,3};
    ans = minimumRounds(nums);

    System.out.println(ans);
  }
}
