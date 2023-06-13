package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 06/06/23
 * @project ds-algo-2021-leetcode
 */
public class EvaluateDivisionLeetcode399 {
  static class Neighbor {
    String node;
    double value;

    public Neighbor(String node, double value) {
      this.node = node;
      this.value = value;
    }
  }

  private static double finalAns = 1;

  private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, List<Neighbor>> adjList = new HashMap<>();

    for(int i = 0; i < equations.size(); i++) {
      String s = equations.get(i).get(0);
      String d = equations.get(i).get(1);
      if(!adjList.containsKey(s)) {
        adjList.put(s, new ArrayList<>());
      }
      adjList.get(s).add(new Neighbor(d, values[i]));
      if(!adjList.containsKey(d)) {
        adjList.put(d, new ArrayList<>());
      }
      adjList.get(d).add(new Neighbor(s, 1/values[i]));
    }

    double[] result = new double[queries.size()];
    int j = 0;
    for(List<String> currentQuery: queries) {
      String s = currentQuery.get(0);
      String d = currentQuery.get(1);
      if(!adjList.containsKey(s) || !adjList.containsKey(d)) {
        result[j++] = -1;
      } else if(s.equals(d)) {
        result[j++] = 1;
      } else {
        finalAns = 1;
        Set<String> visited = new HashSet<>();
        boolean hasPath = dfs(adjList, s, d, visited);
        result[j++] = hasPath ? finalAns: -1;
      }
    }
    return result;
  }

  private static boolean dfs(Map<String, List<Neighbor>> adjList, String s, String d, Set<String> visited) {
    if(s.equals(d))
      return true;
    visited.add(s);
    List<Neighbor> neighbors = adjList.get(s);
    for(Neighbor nei: neighbors) {
      if(!visited.contains(nei.node)) {
        finalAns = finalAns * nei.value;
        if(dfs(adjList, nei.node, d, visited))
          return true;
        finalAns = finalAns / nei.value;
      }
    }
    return false;
  }

  public static void main(String[] args) {

  }
}
