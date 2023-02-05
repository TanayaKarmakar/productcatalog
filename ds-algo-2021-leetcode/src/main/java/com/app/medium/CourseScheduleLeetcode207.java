package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 31/01/23
 * @project ds-algo-2021
 */
public class CourseScheduleLeetcode207 {
  private static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    int[] inDeg = new int[numCourses];

    for(int[] curr: prerequisites) {
      int target = curr[0];
      int source = curr[1];
      if(!adjList.containsKey(source)) {
        adjList.put(source, new ArrayList<>());
      }
      adjList.get(source).add(target);
      inDeg[target]++;
    }

    int count = 0;
    Queue<Integer> q = new LinkedList<>();
    List<Integer> order = new ArrayList<>();

    for(int i = 0; i < numCourses; i++) {
      if(inDeg[i] == 0)
        q.add(i);
    }

    while(!q.isEmpty()) {
      int rem = q.poll();
      count++;

      order.add(rem);
      List<Integer> nei = adjList.getOrDefault(rem, new ArrayList<>());
      if(!nei.isEmpty()) {
        for(Integer el: nei) {
          inDeg[el]--;
          if(inDeg[el] == 0)
            q.add(el);
        }
      }
    }
    return count == numCourses;
  }

  public static void main(String[] args) {

  }
}
