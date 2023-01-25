package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 06/12/22
 * @project ds-algo-2021
 */
public class ReorderRoutesToMakeAllPathsLeadToCityZeroLeetcode1466 {
  private static int minReorder(int n, int[][] connections) {
    Set<Integer> visited = new HashSet<>();
    Set<String> path = new HashSet<>();
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for(int[] conn: connections) {
      int source = conn[0];
      int target = conn[1];
      if(!adjList.containsKey(source))
        adjList.put(source, new ArrayList<>());
      adjList.get(source).add(target);
      if(!adjList.containsKey(target))
        adjList.put(target, new ArrayList<>());
      adjList.get(target).add(source);

      path.add(source + "|" + target);
    }

    int count = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    visited.add(0);

    while(!q.isEmpty()) {
      Integer node = q.poll();
      List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
      if(!neighbors.isEmpty()) {
        for(Integer el: neighbors) {
          if(!visited.contains(el)) {
            q.add(el);
            visited.add(el);
            if(path.contains(node + "|" + el))
              count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {

  }
}
