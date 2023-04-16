package com.app.medium;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class ReorderRoutesToMakeAllPathLeadToCityZeroLeetcode1466 {
  private static int minReorder(int n, int[][] connections) {
    Set<Integer> visited = new HashSet<>();
    Set<String> paths = new HashSet<>();
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    for(int i = 0; i < connections.length; i++) {
      int source = connections[i][0];
      int target = connections[i][1];

      if(!adjList.containsKey(source))
        adjList.put(source, new ArrayList<>());
      adjList.get(source).add(target);

      if(!adjList.containsKey(target))
        adjList.put(target, new ArrayList<>());
      adjList.get(target).add(source);

      paths.add(source + "|" + target);
    }

    Queue<Integer> q = new LinkedList<>();
    q.add(0);
    visited.add(0);

    int count = 0;
    while(!q.isEmpty()) {
      int node = q.poll();
      List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
      if(!neighbors.isEmpty()) {
        for(Integer el: neighbors) {
          if(!visited.contains(el)) {
            q.add(el);
            visited.add(el);

            if(paths.contains(node + "|" + el))
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
