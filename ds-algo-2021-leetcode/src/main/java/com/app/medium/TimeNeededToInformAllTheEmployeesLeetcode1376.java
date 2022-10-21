package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class TimeNeededToInformAllTheEmployeesLeetcode1376 {
  private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
    Map<Integer, List<Integer>> orgChart = new HashMap<>();
    for(int i = 0; i < manager.length; i++) {
      int managerId = manager[i];
      if(managerId == -1)
        continue;
      if(!orgChart.containsKey(managerId))
        orgChart.put(managerId, new ArrayList<>());
      orgChart.get(managerId).add(i);
    }

    int totalTime = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(headID);

    while(!q.isEmpty()) {
      int size = q.size();
      int maxTime = 0;
      for(int i = 0; i < size; i++) {
        Integer el = q.poll();
        maxTime = Integer.max(maxTime, informTime[el]);
        List<Integer> reportees = orgChart.getOrDefault(el, new ArrayList<>());
        if(!reportees.isEmpty()) {
          for(Integer reportee: reportees) {
            q.add(reportee);
          }
        }
      }
      totalTime += maxTime;
    }
    return totalTime;
  }


  public static void main(String[] args) {

  }
}
