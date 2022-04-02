package com.app.medium;

import com.app.common.Pair;

import java.util.*;

/**
 * @author t0k02w6 on 31/03/22
 * @project ds-algo-2021
 */
public class EvaluateDivisionLeetcode399 {
    private static double value = 1;

    private static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> adjList = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            if(!adjList.containsKey(equation.get(0)))
                adjList.put(equation.get(0), new ArrayList<>());
            Pair<String, Double> pair1 = new Pair<>(equation.get(1), value);
            adjList.get(equation.get(0)).add(pair1);

            if(!adjList.containsKey(equation.get(1)))
                adjList.put(equation.get(1), new ArrayList<>());
            Pair<String, Double> pair2 = new Pair<>(equation.get(0), 1/value);
            adjList.get(equation.get(1)).add(pair2);
        }

        double[] ans = new double[queries.size()];
        int i = 0;
        for(List<String> query: queries) {
            String start = query.get(0);
            String end = query.get(1);
            if(!adjList.containsKey(start) || !adjList.containsKey(end)) {
                ans[i++] = -1;
            } else if(start.equals(end)) {
                ans[i++] = 1;
            } else {
                Set<String> visited = new HashSet<>();
                value = 1;
                boolean hasPath = dfs(adjList, start, end, visited);
                ans[i++] = hasPath ? value: -1;
            }
        }
        return ans;
    }

    private static boolean dfs(Map<String, List<Pair<String, Double>>> adjList, String start, String end, Set<String> visited) {
       if(start.equals(end)) {
           return true;
       }
       visited.add(start);
       List<Pair<String, Double>> neighbors = adjList.getOrDefault(start, new ArrayList<>());
       for(Pair<String, Double> nei: neighbors) {
           if(!visited.contains(nei.first)) {
               value = value * nei.second;
               if(dfs(adjList, nei.first, end, visited))
                   return true;
               value = value / nei.second;
           }

       }
       return false;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> eq1 = new ArrayList<>();
        eq1.add("a");
        eq1.add("b");

        equations.add(eq1);

        List<String> eq2 = new ArrayList<>();
        eq2.add("b");
        eq2.add("c");
        equations.add(eq2);


        double[] values = {2,3};

        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        queries.add(q1);

        q1 = new ArrayList<>();
        q1.add("b");
        q1.add("a");
        queries.add(q1);

        q1 = new ArrayList<>();
        q1.add("a");
        q1.add("e");
        queries.add(q1);

        q1 = new ArrayList<>();
        q1.add("a");
        q1.add("a");
        queries.add(q1);

        q1 = new ArrayList<>();
        q1.add("x");
        q1.add("x");
        queries.add(q1);

        double[] ans = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
    }
}
