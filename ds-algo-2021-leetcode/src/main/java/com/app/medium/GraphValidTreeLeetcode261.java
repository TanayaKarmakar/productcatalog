package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 25/04/22
 * @project ds-algo-2021
 */
public class GraphValidTreeLeetcode261 {
    private static Map<Integer, List<Integer>> buildAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if(!adjList.containsKey(n1))
                adjList.put(n1, new ArrayList<>());
            adjList.get(n1).add(n2);
            if(!adjList.containsKey(n2))
                adjList.put(n2, new ArrayList<>());
            adjList.get(n2).add(n1);
        }
        return adjList;
    }

    private static void dfs(Map<Integer, List<Integer>> adjList, int node, boolean[] visited) {
        visited[node] = true;
        List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());

        for(Integer nei: neighbors) {
            if(!visited[nei])
                dfs(adjList, nei, visited);
        }
    }

    private static boolean isCycle(Map<Integer, List<Integer>> adjList, int node, int parent, boolean[] visited) {
        visited[node] = true;
        List<Integer> neighbors = adjList.get(node);
        for(Integer nei: neighbors) {
            if(!visited[nei]) {
                if(isCycle(adjList, nei, node, visited))
                    return true;
            } else if(nei != parent)
                return true;
        }
        return false;
    }

    private static boolean validTree(int n, int[][] edges) {
        if(edges.length == 0) {
            if(n == 1)
                return true;
            return false;
        }
        Map<Integer, List<Integer>> adjList = buildAdjList(edges);

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
        boolean isCycle = isCycle(adjList, 0, -1, visited);
        if(isCycle)
            return false;
        return true;
    }


    public static void main(String[] args) {
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int n = 5;

        System.out.println(validTree(n, edges));
    }
}
