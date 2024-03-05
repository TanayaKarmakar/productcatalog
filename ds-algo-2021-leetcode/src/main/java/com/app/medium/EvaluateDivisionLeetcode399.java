package com.app.medium;

import java.util.*;

public class EvaluateDivisionLeetcode399 {
    static class Node {
        String node;
        double value;

        public Node(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }

    private static double finalAns = 1;

    private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> adjList = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            String source = equations.get(i).get(0);
            String target = equations.get(i).get(1);

            if(!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<>());
            }
            adjList.get(source).add(new Node(target, values[i]));
            if(!adjList.containsKey(target)) {
                adjList.put(target, new ArrayList<>());
            }
            adjList.get(target).add(new Node(source, 1 / values[i]));
        }

        double[] result = new double[queries.size()];


        int j = 0;
        for(List<String> query: queries) {
            if(!adjList.containsKey(query.get(0)) || !adjList.containsKey(query.get(1)))
                result[j++] = -1;
            else if(query.get(0).equals(query.get(1)))
                result[j++] = 1;
            else {
                finalAns = 1;
                Set<String> visited = new HashSet<>();
                if(dfs(query.get(0), query.get(1), adjList, visited))
                    result[j++] = finalAns;
                else
                    result[j++] = -1;
            }
        }
        return result;
    }

    private static boolean dfs(String source, String target, Map<String, List<Node>> adjList, Set<String> visited) {
        if(source.equals(target))
            return true;
        visited.add(source);
        List<Node> neighbors = adjList.getOrDefault(source, new ArrayList<>());
        if(!neighbors.isEmpty()) {
            for(Node nei: neighbors) {
                if(!visited.contains(nei.node)) {
                    finalAns = finalAns * nei.value;
                    if(dfs(nei.node, target, adjList, visited))
                        return true;
                    finalAns = finalAns / nei.value;
                }
            }
        }
        return false;
    }



    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> equation = new ArrayList<>();
        equation.add("a");
        equation.add("b");
        equations.add(equation);

        equation = new ArrayList<>();
        equation.add("b");
        equation.add("c");
        equations.add(equation);

        double[] values = {2.0,3.0};

        List<List<String>> queries = new ArrayList<>();
        List<String> query = new ArrayList<>();
        query.add("a");
        query.add("c");
        queries.add(query);

        query = new ArrayList<>();
        query.add("b");
        query.add("a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a");
        query.add("e");
        queries.add(query);

        query = new ArrayList<>();
        query.add("a");
        query.add("a");
        queries.add(query);

        query = new ArrayList<>();
        query.add("x");
        query.add("x");
        queries.add(query);

        double[] result = calcEquation(equations, values, queries);

        System.out.println(Arrays.toString(result));
    }
}
