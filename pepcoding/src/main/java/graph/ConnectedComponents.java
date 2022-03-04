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
public class ConnectedComponents {

    private static int connectedComponents(int[][] paths, int nVertices) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(paths);

        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for(int v = 0; v < nVertices; v++) {
            if(!visited.contains(v)) {
                count++;
                dfs(adjList, visited, v);
            }
        }
        return count;
    }

    private static void dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visited, int node) {
        visited.add(node);
        List<Integer> neighbors = adjList.get(node);
        for(Integer nei: neighbors) {
            if(!visited.contains(nei)) {
                dfs(adjList, visited, nei);
            }
        }
    }


    public static void main(String[] args) {
        int[][] paths = {
                {0, 1},
                {2, 3},
                {4, 5},
                {5, 6},
                {4, 6}
        };

        int nVertices = 7;
        int ans = connectedComponents(paths, nVertices);

        System.out.println(ans);
    }
}
