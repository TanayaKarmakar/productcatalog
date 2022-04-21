package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class CycleDetectionForDirectedGraph {
    private static boolean isCycle(Map<Integer, List<Integer>> adjList, int n) {
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                if(isCycleRec(adjList, i, visited, recStack))
                    return true;
            }
        }
        return false;
    }

    private static boolean isCycleRec(Map<Integer, List<Integer>> adjList, int current, boolean[] visited, boolean[] recStack) {
        visited[current] = true;
        recStack[current] = true;

        List<Integer> neighbors = adjList.getOrDefault(current, new ArrayList<>());
        for(Integer nei: neighbors) {
            if(!visited[nei] && isCycleRec(adjList, nei, visited, recStack)) {
                return true;
            } else if(recStack[nei])
                return true;
        }
        recStack[current] = false;
        return false;
    }

    public static void main(String[] args) {

    }
}
