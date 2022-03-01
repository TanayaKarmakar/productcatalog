package graph;

import java.util.*;

/**
 * @author t0k02w6 on 01/03/22
 * @project ds-algo-2021
 */
public class HasPath {
    private static boolean bfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited.add(start);

        while(!queue.isEmpty()) {
            Integer node = queue.poll();

            if(node == end)
                return true;
            List<Integer> neighbours = adjList.get(node);
            for(Integer nei: neighbours) {
                if(!visited.contains(nei)) {
                    queue.add(nei);
                    visited.add(nei);
                }
            }
        }

        return false;
    }

    private static boolean dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int start, int end) {
        if(start == end)
            return true;
        visited.add(start);
        List<Integer> neighbours = adjList.get(start);
        for(Integer nei: neighbours) {
            if(!visited.contains(nei)) {
                boolean hasPath = dfs(adjList, visited, nei, end);
                if(hasPath) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPath(int[][] paths, int start, int end) {
        Map<Integer, List<Integer>> adjList = buildGraph(paths);

        Set<Integer> visited = new HashSet<>();
        return bfs(adjList, visited, start, end);
    }

    private static boolean hasPathDfs(int[][] paths, int start, int end) {
        Map<Integer, List<Integer>> adjList = buildGraph(paths);

        Set<Integer> visited = new HashSet<>();
        return dfs(adjList, visited, start, end);
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] paths) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < paths.length; i++) {
            int[] currentEdge = paths[i];
            if(!adjList.containsKey(currentEdge[0])) {
                adjList.put(currentEdge[0], new ArrayList<>());
            }
            adjList.get(currentEdge[0]).add(currentEdge[1]);

            if(!adjList.containsKey(currentEdge[1])) {
                adjList.put(currentEdge[1], new ArrayList<>());
            }
            adjList.get(currentEdge[1]).add(currentEdge[0]);
        }
        return adjList;
    }

    public static void main(String[] args) {
        int nVertices = 7;
        int nEdges = 8;
        int[][] path = {{0,1},{1,2},{2,3},{0,3},{3,4},{4,5},{5,6},{4,6}};

        int start = 0;
        int end = 6;

        boolean hasPath = hasPath(path, start, end);

        System.out.println("BFS Approach");
        System.out.println(hasPath);

        System.out.println("DFS Approach");
        hasPath = hasPathDfs(path, start, end);
        System.out.println(hasPath);
    }
}
