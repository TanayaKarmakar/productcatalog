package graph;

import java.util.*;

/**
 * @author t0k02w6 on 20/04/22
 * @project ds-algo-2021
 */
public class DetectCycleInAnUndirectedGraph {
    private static boolean isCycle(Map<Integer, List<Integer>> adjList, int n) {
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(isCycleRec(adjList, i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycleRec(Map<Integer, List<Integer>> adjList, int curr, int parent, boolean[] visited) {
        visited[curr] = true;
        List<Integer> neighbors = adjList.get(curr);
        for(Integer nei: neighbors) {
            if(!visited[nei]) {
                if(isCycleRec(adjList, nei, curr, visited))
                    return true;
            } else if(nei != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Collections.singletonList(1));
        adjList.put(1, Arrays.asList(0,2,3));
        adjList.put(2, Arrays.asList(1,3,4));
        adjList.put(3, Arrays.asList(1,2));
        adjList.put(4, Arrays.asList(2,5));
        adjList.put(5, Collections.singletonList(4));

        boolean ans = isCycle(adjList, 6);
        System.out.println(ans);
    }
}
