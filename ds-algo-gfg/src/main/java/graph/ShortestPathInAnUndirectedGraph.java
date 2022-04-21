package graph;

import java.util.*;

/**
 * @author t0k02w6 on 20/04/22
 * @project ds-algo-2021
 */
public class ShortestPathInAnUndirectedGraph {
    private static int[] shortestDist(int n, Map<Integer, List<Integer>> adjList, int source) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while(!q.isEmpty()) {
            Integer remNode = q.poll();
            List<Integer> neighbors = adjList.getOrDefault(remNode, new ArrayList<>());
            //visited.add(remNode);
            for(Integer nei: neighbors) {
                if(!visited.contains(nei)) {
                    q.add(nei);
                    dist[nei] = dist[remNode] + 1;
                    visited.add(nei);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1,2));
        adjList.put(1, Arrays.asList(0,2,3));
        adjList.put(2, Arrays.asList(0,1,3));
        adjList.put(3, Arrays.asList(1,2));

        int[] dist = shortestDist(4, adjList, 0);

        System.out.println(Arrays.toString(dist));
    }
}
