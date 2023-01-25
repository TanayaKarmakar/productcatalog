package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 21/11/22
 * @project ds-algo-2021
 */
public class NumberOfProvincesLeetcode547 {
  public int findCircleNum(int[][] isConnected) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();

    int n = isConnected.length;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        if(i == j)
          continue;
        if(isConnected[i][j] == 1) {
          if(!adjList.containsKey(i))
            adjList.put(i, new ArrayList<>());
          adjList.get(i).add(j);
        }
      }
    }

    Set<Integer> visited = new HashSet<>();
    int provinceCount = 0;

    for(int i = 0; i < n; i++) {
      if(!visited.contains(i)) {
        provinceCount++;
        dfs(adjList, i, visited);
      }
    }

    return provinceCount;
  }

  private void dfs(Map<Integer, List<Integer>> adjList, int i, Set<Integer> visited) {
    visited.add(i);
    List<Integer> neighbors = adjList.getOrDefault(i, new ArrayList<>());
    if(!neighbors.isEmpty()) {
      for(Integer nei: neighbors) {
        if(!visited.contains(nei))
          dfs(adjList, nei, visited);
      }
    }
  }

  public static void main(String[] args) {

  }
}
