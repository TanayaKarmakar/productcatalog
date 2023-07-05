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
public class ParallelCoursesLeetcode1136 {
  private static int minimumSemesters(int n, int[][] relations) {
    int[] inDeg = new int[n + 1];

    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for(int i = 0; i < relations.length; i++) {
      int src = relations[i][0];
      int dest = relations[i][1];
      if(!adjList.containsKey(src))
        adjList.put(src, new ArrayList<>());
      adjList.get(src).add(dest);
      inDeg[dest]++;
    }


    int j = 0;
    Queue<Integer> q = new LinkedList<>();
    for(int i = 1; i < inDeg.length; i++) {
      if(inDeg[i] == 0) {
        q.add(i);
        j++;
      }
    }

    if(q.isEmpty())
      return -1;
    int count = 1;
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int el = q.poll();
        List<Integer> neighbors = adjList.getOrDefault(el, new ArrayList<>());
        for(Integer nei: neighbors) {
          inDeg[nei]--;
          if(inDeg[nei] == 0) {
            q.add(nei);
            j++;
          }
        }
      }
      count++;
    }
    return j == n ? count: -1;
  }

  public static void main(String[] args) {

  }
}
