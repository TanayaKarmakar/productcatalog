package com.app.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfProvincesLeetcode547 {
    private static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];

        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j && isConnected[i][j] == 1) {
                    if(!adjList.containsKey(i)) {
                        adjList.put(i, new ArrayList<>());
                    }
                    adjList.get(i).add(j);
                    if(!adjList.containsKey(j)) {
                        adjList.put(j, new ArrayList<>());
                    }
                    adjList.get(j).add(i);
                }
            }
        }

        int numProvinces = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                numProvinces++;
                dfs(adjList, i, visited);
            }
        }
        return numProvinces;
    }

    private static void dfs(Map<Integer, List<Integer>> adjList, int node, boolean[] visited) {
        List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
        visited[node] = true;
        if(!neighbors.isEmpty()) {
            for(Integer nei: neighbors) {
                if(!visited[nei]) {
                    dfs(adjList, nei, visited);
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
