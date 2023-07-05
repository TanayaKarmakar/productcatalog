package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 21/06/23
 * @project ds-algo-2021-leetcode
 */
public class NumberOfProvincesLeetcode547 {
  private static int findCircleNum(int[][] isConnected) {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    for(int i = 0; i < isConnected.length; i++) {
      for(int j = 0; j < isConnected[0].length; j++) {
        if(i != j && isConnected[i][j] == 1) {
          if(!adjList.containsKey(i))
            adjList.put(i, new ArrayList<>());
          adjList.get(i).add(j);

          if(!adjList.containsKey(j))
            adjList.put(j, new ArrayList<>());
          adjList.get(j).add(i);
        }
      }
    }

    boolean[] isVisited = new boolean[isConnected.length];
    int nProvinces = 0;
    for(int i = 0; i < isVisited.length; i++) {
      if(!isVisited[i]) {
        nProvinces++;
        dfs(adjList, i, isVisited);
      }
    }
    return nProvinces;
  }

  private static void dfs(Map<Integer, List<Integer>> adjList, int node, boolean[] isVisited) {
    isVisited[node] = true;
    List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());

    if(!neighbors.isEmpty()) {
      for(Integer nei: neighbors) {
        if(!isVisited[nei]) {
          dfs(adjList, nei, isVisited);
        }
      }
    }
  }


  public static void main(String[] args) {
    int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};

    int ans = findCircleNum(isConnected);
    System.out.println(ans);
  }
}
