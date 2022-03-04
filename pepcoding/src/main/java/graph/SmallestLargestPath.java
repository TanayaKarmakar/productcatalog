package graph;

import common.GraphUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 04/03/22
 * @project ds-algo-2021
 */
public class SmallestLargestPath {
    static String smallestPath = "";
    static String largestPath = "";
    static int minPathLen = Integer.MAX_VALUE;
    static int maxPathLen = Integer.MIN_VALUE;

    private static void dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int start, int end, String pathSoFar) {
        if(start == end) {
            int len = pathSoFar.split("\\s+").length;
            if(len > maxPathLen) {
                maxPathLen = len;
                largestPath = pathSoFar;
            }
            if(len < maxPathLen) {
                minPathLen = len;
                smallestPath = pathSoFar;
            }
            return;
        }
        visited.add(start);
        List<Integer> neighbors = adjList.get(start);
        for(Integer nei: neighbors) {
            if(!visited.contains(nei)) {
                dfs(adjList, visited, nei, end, pathSoFar + " " + nei);
            }
        }
        visited.remove(start);
    }

    private static String[] findSmallestLargestPath(int[][] path, int start, int end) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(path);
        String pathSoFar = "";

        Set<Integer> visited = new HashSet<>();

        dfs(adjList, visited, start, end, pathSoFar + start);
        return new String[] {smallestPath, largestPath};
    }

    public static void main(String[] args) {
        int[][] path = {{0,1},{1,2},{2,3},{0,3},{3,4},{4,5},{5,6},{4,6}};

        int start = 0;
        int end = 6;

        String[] paths = findSmallestLargestPath(path, start, end);

        System.out.println("Smallest Path - " + paths[0]);
        System.out.println("Largest Path - " + paths[1]);
    }
}
