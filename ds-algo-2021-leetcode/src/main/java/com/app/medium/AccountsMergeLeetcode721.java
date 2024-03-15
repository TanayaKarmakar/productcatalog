package com.app.medium;

import java.util.*;

public class AccountsMergeLeetcode721 {
    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> adjList = createList(accounts);
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(Map.Entry<String, List<String>> entry: adjList.entrySet()) {
            if(!visited.contains(entry.getKey())) {
                List<String> currentResult = new ArrayList<>();
                dfs(adjList, entry.getKey(), visited, currentResult);
                Collections.sort(currentResult);
                currentResult.add(0, entry.getValue().get(0));
                result.add(currentResult);
            }
        }

        return result;
    }

    private static void dfs(Map<String, List<String>> adjList, String email, Set<String> visited, List<String> currentResult) {
        visited.add(email);
        currentResult.add(email);
        List<String> neighbors = adjList.getOrDefault(email, new ArrayList<>());
        if(!neighbors.isEmpty()) {
            neighbors = neighbors.subList(1, neighbors.size());
            for(String nei: neighbors) {
                if(!visited.contains(nei)) {
                    dfs(adjList, nei, visited, currentResult);
                }
            }
        }
    }

    private static Map<String, List<String>> createList(List<List<String>> accounts) {
        Map<String, List<String>> adjList = new HashMap<>();
        for(List<String> account: accounts) {
            List<String> emails = account.subList(1, account.size());
            for(String email: emails) {
                if(!adjList.containsKey(email)) {
                    adjList.put(email, new ArrayList<>());
                    adjList.get(email).add(account.get(0));
                }
            }

            for(String email1: emails) {
                for(String email2: emails) {
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
