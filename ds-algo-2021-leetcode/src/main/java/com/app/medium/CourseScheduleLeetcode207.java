package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 13/06/23
 * @project ds-algo-2021-leetcode
 */
public class CourseScheduleLeetcode207 {
  private static boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] inDeg = new int[numCourses];
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for(int i = 0; i < prerequisites.length; i++) {
      int source = prerequisites[i][1];
      int dest = prerequisites[i][0];
      if(!adjList.containsKey(source))
        adjList.put(source, new ArrayList<>());
      adjList.get(source).add(dest);
      inDeg[dest]++;
    }

    Queue<Integer> q = new LinkedList<>();
    int count = 0;
    for(int i = 0; i < inDeg.length; i++) {
      if(inDeg[i] == 0) {
        q.add(i);
        count++;
      }
    }

    while(!q.isEmpty()) {
      Integer el = q.poll();
      List<Integer> neighbors = adjList.getOrDefault(el, new ArrayList<>());
      for(Integer nei: neighbors) {
        inDeg[nei]--;
        if(inDeg[nei] == 0) {
          q.add(nei);
          count++;
        }
      }
    }

    return count == numCourses;
  }

  public static void main(String[] args) {

  }
}
