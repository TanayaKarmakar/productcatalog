package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 06/12/22
 * @project ds-algo-2021
 */
public class GraphValidTreeLeetcode261 {
  public static boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for(int[] current: edges) {
      int s = current[0];
      int t = current[1];
      if(!adjList.containsKey(s))
        adjList.put(s, new ArrayList<>());
      adjList.get(s).add(t);
      if(!adjList.containsKey(t))
        adjList.put(t, new ArrayList<>());
      adjList.get(t).add(s);
    }

    Set<Integer> visited = new HashSet<>();
    int count = 0;
    for(int i = 0; i < n; i++) {
      if(!visited.contains(i)) {
        dfs(adjList, visited, i);
        count++;
      }
    }
    if(count != 1)
      return false;

    visited.clear();
    return !hasCycle(adjList, visited, 0, -1);
  }

  private static boolean hasCycle(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int current, int parent) {
    visited.add(current);
    List<Integer> neighbors = adjList.getOrDefault(current, new ArrayList<>());
    if(!neighbors.isEmpty()) {
      for(Integer el: neighbors) {
        if(visited.contains(el) && el != parent)
          return true;
        if(!visited.contains(el) && hasCycle(adjList, visited, el, current))
          return true;
      }
    }
    return false;
  }

  private static void dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int current) {
    visited.add(current);
    List<Integer> neighbors = adjList.getOrDefault(current, new ArrayList<>());
    if(!neighbors.isEmpty()) {
      for(Integer nei: neighbors) {
        if(!visited.contains(nei))
          dfs(adjList, visited, nei);
      }
    }
  }

  public static void main(String[] args) {

  }
}
