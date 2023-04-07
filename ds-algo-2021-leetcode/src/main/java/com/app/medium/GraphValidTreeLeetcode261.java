package com.app.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class GraphValidTreeLeetcode261 {

  private static boolean validTree(int n, int[][] edges) {
    Map<Integer, List<Integer>> map = new HashMap<>();

    for(int i = 0; i < edges.length; i++) {
      int s = edges[i][0];
      int t = edges[i][1];
      if(!map.containsKey(s))
        map.put(s, new ArrayList<>());
      map.get(s).add(t);

      if(!map.containsKey(t))
        map.put(t, new ArrayList<>());
      map.get(t).add(s);
    }

    boolean[] visited = new boolean[n];
    int count = 0;
    for(int i = 0; i < n; i++) {
      if(!visited[i]) {
        count++;
        dfs(i, map, visited);
      }
    }

    if(count > 1)
      return false;

    Arrays.fill(visited, false);
    return !hasCycle(0, -1, map, visited);
  }

  private static boolean hasCycle(int node, int parent, Map<Integer, List<Integer>> map, boolean[] visited) {
    List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());
    visited[node] = true;
    for(Integer nei: neighbors) {
      if(!visited[nei]) {
        if(hasCycle(nei, node, map, visited)) {
          return true;
        }
      } else {
        if(nei != parent)
          return true;
      }
    }
    return false;
  }

  private static void dfs(int node, Map<Integer, List<Integer>> map, boolean[] visited) {
    List<Integer> neighbors = map.getOrDefault(node, new ArrayList<>());

    visited[node] = true;
    for(Integer nei: neighbors) {
      if(!visited[nei])
        dfs(nei, map, visited);
    }
  }

  public static void main(String[] args) {
    int n = 5;
    int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};

    System.out.println(validTree(n, edges));

    n = 5;
    edges = new int[][]{{0,1},{0,2},{0,3},{1,4}};

    System.out.println(validTree(n, edges));
  }
}
