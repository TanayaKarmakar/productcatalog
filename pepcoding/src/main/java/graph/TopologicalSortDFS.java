package graph;

import common.GraphUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author t0k02w6 on 08/03/22
 * @project ds-algo-2021
 */
public class TopologicalSortDFS {
    private static void topSort(int[][] paths, int nVertices) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, List<Integer>> adjList = GraphUtil.buildDiGraph(paths);

        boolean[] visited = new boolean[nVertices];
        for(int i = 0; i < nVertices; i++) {
            if(!visited[i]) {
                dfs(adjList, i, visited, stack);
            }
        }

        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    private static void dfs(Map<Integer, List<Integer>> adjList, int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
        for(Integer nei: neighbors) {
            if(!visited[nei])
                dfs(adjList, nei, visited, stack);
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        int nVertices = 7;
        int[][] paths = {{0,1},{0,3},{1,2},{2,3},{4,3},{4,5},{5,6},{4,6}};

        topSort(paths, nVertices);
    }
}
