package graph;

import common.GraphUtil;

import java.util.*;

/**
 * @author t0k02w6 on 01/03/22
 * @project ds-algo-2021
 */
public class PrintAllPath {
    private static void dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, Stack<Integer> stack, int start, int end) {
        if(start == end) {
            System.out.println(stack);
            return;
        }
        visited.add(start);
        List<Integer> neighbors = adjList.get(start);

        for(Integer nei: neighbors) {
            if(!visited.contains(nei)) {
                stack.push(nei);
                dfs(adjList, visited, stack, nei, end);
                stack.pop();
            }
        }
        visited.remove(start);
    }

    private static void printAllPath(int[][] paths, int start, int end) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(paths);

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        dfs(adjList, visited, stack, start, end);
    }

    public static void main(String[] args) {
        int[][] path = {{0,1},{1,2},{2,3},{0,3},{3,4},{4,5},{5,6},{4,6}};

        int start = 0;
        int end = 6;

        printAllPath(path, start, end);
    }
}
