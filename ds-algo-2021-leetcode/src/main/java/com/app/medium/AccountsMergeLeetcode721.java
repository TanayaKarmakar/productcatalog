package com.app.medium;

import com.sun.source.tree.Tree;

import java.util.*;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class AccountsMergeLeetcode721 {
    private static Map<String, List<String>> createAdjacencyList(List<List<String>> accounts) {
        Map<String, List<String>> adjList = new HashMap<>();

        for(List<String> account: accounts) {
            List<String> emailList = account.subList(1, account.size());
            for(String email: emailList) {
                if(!adjList.containsKey(email))  {
                    adjList.put(email, new ArrayList<>());
                    adjList.get(email).add(account.get(0));
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

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> adjList = createAdjacencyList(accounts);

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for(Map.Entry<String, List<String>> entry: adjList.entrySet()) {
            if(!visited.contains(entry.getKey())) {
                List<String> current = new ArrayList<>();
                dfs(adjList, visited, entry.getKey(), current);
                Collections.sort(current);
                current.add(0, entry.getValue().get(0));
                result.add(current);
            }
        }
        return result;
    }

    private static void dfs(Map<String, List<String>> adjList, Set<String> visited, String key, List<String> current) {
        current.add(key);
        visited.add(key);

        List<String> emails = adjList.get(key).subList(1, adjList.get(key).size());
        if(!emails.isEmpty()) {
            for(String email: emails) {
                if(!visited.contains(email))
                    dfs(adjList, visited, email, current);
            }
        }

    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        List<String> acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("johnsmith@mail.com");
        acc1.add("john_newyork@mail.com");
        accounts.add(acc1);

        List<String> acc2 = new ArrayList<>();
        acc2.add("John");
        acc2.add("johnsmith@mail.com");
        acc2.add("john00@mail.com");
        accounts.add(acc2);

        List<String> acc3 = new ArrayList<>();
        acc3.add("Mary");
        acc3.add("mary@mail.com");
        accounts.add(acc3);

        List<String> acc4 = new ArrayList<>();
        acc4.add("John");
        acc4.add("johnnybravo@mail.com");
        accounts.add(acc4);

        List<List<String>> res = accountsMerge(accounts);
        System.out.println(res);
    }
}
