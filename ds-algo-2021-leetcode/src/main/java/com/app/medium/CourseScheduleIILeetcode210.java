package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 19/06/23
 * @project ds-algo-2021-leetcode
 */
public class CourseScheduleIILeetcode210 {
  private static int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] finalResult = new int[numCourses];

    int[] inDeg = new int[numCourses];
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    for(int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      if(!adjList.containsKey(src)) {
        adjList.put(src, new ArrayList<>());
      }
      adjList.get(src).add(dest);
      inDeg[dest]++;
    }

    int j = 0;
    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < numCourses; i++) {
      if(inDeg[i] == 0) {
        q.add(i);
        finalResult[j++] = i;
      }
    }

    while (!q.isEmpty()) {
      int remItem = q.poll();
      List<Integer> neibhbors = adjList.getOrDefault(remItem, new ArrayList<>());
      if(!neibhbors.isEmpty()) {
        for(Integer nei: neibhbors) {
          inDeg[nei]--;
          if(inDeg[nei] == 0) {
            q.add(nei);
            finalResult[j++] = nei;
          }
        }
      }
    }

    return j == numCourses ? finalResult: new int[]{};
  }
}
