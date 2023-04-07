package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 06/04/23
 * @project ds-algo-2021-leetcode
 */
public class TimeNeededToInformEmployeesLeetcode1376 {
  private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    for(int i = 0; i < manager.length; i++) {
      if(manager[i] != -1) {
        if(!adjList.containsKey(manager[i])) {
          adjList.put(manager[i], new ArrayList<>());
        }
        adjList.get(manager[i]).add(i);
      }
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(headID);

    int totalTime = 0;
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int value = q.poll();
        List<Integer> subOrds = adjList.getOrDefault(value, new ArrayList<>());
        for(Integer el: subOrds) {
          q.add(el);
        }
        totalTime += informTime[value];
      }
    }

    return totalTime;
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
