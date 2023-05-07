package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 06/05/23
 * @project ds-algo-2021-leetcode
 */
public class ParallerCoursesLeetcode1136 {
  private static int minimumSemesters(int n, int[][] relations) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    int[] inDeg = new int[n + 1];

    for(int i = 0; i < relations.length; i++) {
      int prevCourse = relations[i][0];
      int nextCourse = relations[i][1];
      if(!adjList.containsKey(prevCourse)) {
        adjList.put(prevCourse, new ArrayList<>());
      }
      adjList.get(prevCourse).add(nextCourse);
      inDeg[nextCourse]++;
    }

    int totalCount = 0;
    int minSemCount = 0;
    Queue<Integer> q = new LinkedList<>();
    for(int i = 1; i <= n; i++) {
      if(inDeg[i] == 0) {
        q.add(i);
        totalCount++;
      }
    }

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        int currentNode = q.poll();
        List<Integer> neighbors = adjList.getOrDefault(currentNode, new ArrayList<>());
        for(Integer nei: neighbors) {
          inDeg[nei]--;
          if(inDeg[nei] == 0) {
            q.add(nei);
            totalCount++;
          }
        }
      }
      minSemCount++;
    }

    return totalCount == n ? minSemCount: -1;
  }

  public static void main(String[] args) {

  }
}
