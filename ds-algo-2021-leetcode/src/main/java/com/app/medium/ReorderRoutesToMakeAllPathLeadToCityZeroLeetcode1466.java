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
 * @author t0k02w6 on 15/06/23
 * @project ds-algo-2021-leetcode
 */
public class ReorderRoutesToMakeAllPathLeadToCityZeroLeetcode1466 {
  private static int minReorder(int n, int[][] connections) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<String> paths = new HashSet<>();

    for(int i = 0; i < connections.length; i++) {
      int src = connections[i][0];
      int dest = connections[i][1];
      if(!adjList.containsKey(src))
        adjList.put(src, new ArrayList<>());
      adjList.get(src).add(dest);

      if(!adjList.containsKey(dest))
        adjList.put(dest, new ArrayList<>());
      adjList.get(dest).add(src);

      paths.add(src + "|" + dest);
    }

    int count = 0;
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();

    visited.add(0);
    q.add(0);

    while(!q.isEmpty()) {
      int curr = q.poll();
      List<Integer> neighbors = adjList.getOrDefault(curr, new ArrayList<>());
      if(!neighbors.isEmpty()) {
        for(Integer nei: neighbors) {
          if(!visited.contains(nei)) {
            q.add(nei);
            visited.add(nei);

            if(paths.contains(curr + "|" + nei))
              count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};

    int count = minReorder(n, connections);
    System.out.println(count);
  }
}
