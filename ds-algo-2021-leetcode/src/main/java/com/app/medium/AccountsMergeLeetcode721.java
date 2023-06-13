package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 13/06/23
 * @project ds-algo-2021-leetcode
 */
public class AccountsMergeLeetcode721 {
  private static List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<String>> adjList = createAdjacencyList(accounts);
    Set<String> visited = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    for(Map.Entry<String, List<String>> entry: adjList.entrySet()) {
      if(!visited.contains(entry.getKey())) {
        List<String> currentResult = new ArrayList<>();
        dfs(adjList, entry.getKey(), visited, currentResult);
        Collections.sort(currentResult);
        currentResult.add(0, adjList.get(entry.getKey()).get(0));
        result.add(currentResult);
      }
    }
    return result;
  }

  private static void dfs(Map<String, List<String>> adjList, String key, Set<String> visited, List<String> currentResult) {
    visited.add(key);
    currentResult.add(key);

    List<String> neighbours = adjList.getOrDefault(key, new ArrayList<>());
    if(!neighbours.isEmpty()) {
      neighbours = neighbours.subList(1, neighbours.size());
      for(String nei: neighbours) {
        if(!visited.contains(nei)) {
          dfs(adjList, nei, visited, currentResult);
        }
      }
    }
  }

  private static Map<String, List<String>> createAdjacencyList(List<List<String>> accounts) {
    Map<String, List<String>> adjList = new HashMap<>();
    for(List<String> currentAccount: accounts) {
      List<String> emailList = currentAccount.subList(1, currentAccount.size());
      for(String email: emailList) {
        if(!adjList.containsKey(email)) {
          adjList.put(email, new ArrayList<>());
          adjList.get(email).add(currentAccount.get(0));
        }
      }

      for(String email1: emailList) {
        for(String email2: emailList) {
          if(!email1.equals(email2)) {
            adjList.get(email1).add(email2);
          }
        }
      }
    }
    return adjList;
  }

  public static void main(String[] args) {

  }
}
