package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class TimeNeededToInformAllTheEmployeesLeetcode1376 {
  private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    for(int i = 0; i < manager.length; i++) {
      if(manager[i] == -1)
        continue;
      if(!adjList.containsKey(manager[i]))
        adjList.put(manager[i], new ArrayList<>());
      adjList.get(manager[i]).add(i);
    }

    int maxTime = 0;
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{headID, 0});

    while(!q.isEmpty()) {
      int[] currentItem = q.poll();

      List<Integer> reportees = adjList.getOrDefault(currentItem[0], new ArrayList<>());
      for(Integer nei: reportees) {
        int currentTime = currentItem[1] + informTime[currentItem[0]];
        q.add(new int[]{nei, currentTime});
        maxTime = Integer.max(maxTime, currentTime);
      }
    }

    return maxTime;
  }

  public static void main(String[] args) {
    int n = 6;
    int headId = 2;
    int[] manager = {2,2,-1,2,2,2};
    int[] informTime = {0,0,1,0,0,0};

    int ans = numOfMinutes(n, headId, manager, informTime);

    System.out.println(ans);
  }
}
