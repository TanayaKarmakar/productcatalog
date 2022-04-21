package graph;

import java.util.*;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class TopologicalSortDFS {
    private static List<Integer> topoSort(Map<Integer, List<Integer>> adjList, int n) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i])
                dfs(adjList, i, stack, visited);
        }

        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static void dfs(Map<Integer, List<Integer>> adjList, int current, Stack<Integer> stack, boolean[] visited) {
        visited[current] = true;
        List<Integer> neighbors = adjList.getOrDefault(current, new ArrayList<>());
        for(Integer nei: neighbors) {
            if(!visited[nei])
                dfs(adjList, nei, stack, visited);
        }
        stack.push(current);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1));
        adjList.put(1, Arrays.asList(3));
        adjList.put(2, Arrays.asList(3, 4));
        adjList.put(3, Arrays.asList(4));

        List<Integer> result = topoSort(adjList, 5);
        System.out.println(result);
    }
}
