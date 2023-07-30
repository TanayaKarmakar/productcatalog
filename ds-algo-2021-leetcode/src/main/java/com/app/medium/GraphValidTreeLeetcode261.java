package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 06/07/23
 * @project ds-algo-2021-leetcode
 */
public class GraphValidTreeLeetcode261 {
  private static boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    for(int i = 0; i < edges.length; i++) {
      int src = edges[i][0];
      int dest = edges[i][1];

      if(!adjList.containsKey(src))
        adjList.put(src, new ArrayList<>());
      adjList.get(src).add(dest);

      if(!adjList.containsKey(dest))
        adjList.put(dest, new ArrayList<>());
      adjList.get(dest).add(src);
    }

    boolean[] visited = new boolean[n];
    int count = 0;
    for(int i = 0; i < n; i++) {
      if(!visited[i]) {
        count++;
        dfs(adjList, i, visited);
      }
    }

    if(count > 1)
      return false;
    Arrays.fill(visited, false);
    return !hasCycle(adjList, 0, -1, visited);
  }

  private static boolean hasCycle(Map<Integer, List<Integer>> adjList, int node, int parent, boolean[] visited) {
    visited[node] = true;
    List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
    if(!neighbors.isEmpty()) {
      for(Integer nei: neighbors) {
        if(!visited[nei]) {
          if(hasCycle(adjList, nei, node, visited))
            return true;
        } else {
          if(nei != parent)
            return true;
        }
      }
    }
    return false;
  }


  private static void dfs(Map<Integer, List<Integer>> adjList, int current, boolean[] visited) {
    visited[current] = true;
    List<Integer> neighbors = adjList.getOrDefault(current, new ArrayList<>());
    if(!neighbors.isEmpty()) {
      for(Integer nei: neighbors) {
        if(!visited[nei])
          dfs(adjList, nei, visited);
      }
    }
  }

  public static void main(String[] args) {

  }
}
