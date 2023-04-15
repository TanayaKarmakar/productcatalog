package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 15/04/23
 * @project ds-algo-2021-leetcode
 */
public class CourseScheduleIILeetcode210 {
  private static int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    int[] inDeg = new int[numCourses];

    for(int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int source = prerequisites[i][1];

      if(!adjList.containsKey(source)) {
        adjList.put(source, new ArrayList<>());
      }
      adjList.get(source).add(dest);
      inDeg[dest] = inDeg[dest] + 1;
    }

    int[] result = new int[numCourses];
    int j = 0;

    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < inDeg.length; i++) {
      if(inDeg[i] == 0) {
        q.add(i);
        result[j++] = i;
      }
    }

    while(!q.isEmpty()) {
      int node = q.poll();
      List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());

      for(Integer nei: neighbors) {
        inDeg[nei] = inDeg[nei] - 1;
        if(inDeg[nei] == 0) {
          q.add(nei);
          result[j++] = nei;
        }
      }
    }
    if(j == numCourses)
      return result;
    return new int[]{};
  }

  public static void main(String[] args) {

  }
}
