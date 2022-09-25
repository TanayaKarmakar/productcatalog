package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 21/09/22
 * @project ds-algo-2021-leetcode
 */
public class EvaluateDivisionLeetcode399 {
    static class Neighbor {
        String node;
        double weight;

        public Neighbor(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }

    }

    private static double finalAns = 1;

    private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();
        double[] result = new double[n];
        Map<String, List<Neighbor>> adjList = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> currentEq = equations.get(i);
            String s = currentEq.get(0);
            String d = currentEq.get(1);
            if(!adjList.containsKey(s))
                adjList.put(s, new ArrayList<>());
            adjList.get(s).add(new Neighbor(d, values[i]));
            if(!adjList.containsKey(d))
                adjList.put(d, new ArrayList<>());
            adjList.get(d).add(new Neighbor(s, 1 / values[i]));
        }

        for(int i = 0; i < queries.size(); i++) {
            List<String> currentQuery = queries.get(i);
            String source = currentQuery.get(0);
            String dest = currentQuery.get(1);
            if(!adjList.containsKey(source) || !adjList.containsKey(dest)) {
                result[i] = -1;
            } else if(source.equals(dest)) {
                result[i] = 1;
            } else {
                finalAns = 1;
                Set<String> visited = new HashSet<>();
                boolean hasPath = dfs(adjList, source, dest,visited);
                result[i] = hasPath ? finalAns: -1;
            }
        }
        return result;
    }

    private static boolean dfs(Map<String, List<Neighbor>> adjList, String source, String dest, Set<String> visited) {
        if(source.equals(dest)) {
            return true;
        }

        visited.add(source);
        List<Neighbor> neighbors = adjList.getOrDefault(source, new ArrayList<>());
        if(!neighbors.isEmpty()) {
            for(Neighbor nei: neighbors) {
                if(!visited.contains(nei.node)) {
                    finalAns = finalAns * nei.weight;
                    if(dfs(adjList, nei.node, dest, visited))
                        return true;
                    finalAns = finalAns / nei.weight;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
