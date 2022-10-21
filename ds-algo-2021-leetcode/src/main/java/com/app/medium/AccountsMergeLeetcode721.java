package com.app.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 15/10/22
 * @project ds-algo-2021-leetcode
 */
public class AccountsMergeLeetcode721 {
  private static List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<String>> map = createAdjacencyList(accounts);
    Set<String> visited = new HashSet<>();
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, List<String>> entry: map.entrySet()) {
      if(!visited.contains(entry.getKey())) {
        List<String> currentResult = new ArrayList<>();
        dfs(map, entry.getKey(), visited, currentResult);
        Collections.sort(currentResult);
        currentResult.add(0, entry.getValue().get(0));
        result.add(currentResult);
      }
    }
    return result;
  }

  private static void dfs(Map<String, List<String>> map, String current, Set<String> visited,
                          List<String> currentResult) {
    visited.add(current);
    currentResult.add(current);

    List<String> values = map.getOrDefault(current, new ArrayList<>());
    if(!values.isEmpty()) {
      values = values.subList(1, values.size());
      for(String currentValue: values) {
        if(!visited.contains(currentValue)) {
          dfs(map, currentValue, visited, currentResult);
        }
      }
    }
  }

  private static Map<String, List<String>> createAdjacencyList(List<List<String>> accounts) {
    Map<String, List<String>> map = new HashMap<>();
    for(List<String> currentAccount: accounts) {
      List<String> emailList = currentAccount.subList(1, currentAccount.size());
      for(String email: emailList) {
        if(!map.containsKey(email)) {
          map.put(email, new ArrayList<>());
          map.get(email).add(currentAccount.get(0));
        }
      }

      for(String email1: emailList) {
        for(String email2: emailList) {
          if(!email1.equals(email2)) {
            map.get(email1).add(email2);
          }
        }
      }
    }
    return map;
  }

  public static void main(String[] args) {

  }
}
