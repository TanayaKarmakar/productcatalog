package graph;

import java.util.*;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class TopologicalSortingKahnsAlgo {
    private static List<Integer> topoSort(Map<Integer, List<Integer>> adjList, int n) {
        int[] inDeg = new int[n];

        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()) {
            List<Integer> neighbors = entry.getValue();
            for(Integer nei: neighbors) {
                inDeg[nei]++;
            }
        }

        List<Integer> topoSortList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                topoSortList.add(i);
            }
        }

        while(!q.isEmpty()) {
            Integer remNode = q.poll();

            List<Integer> neighbors = adjList.getOrDefault(remNode, new ArrayList<>());
            for(Integer nei: neighbors) {
                inDeg[nei]--;
                if(inDeg[nei] == 0) {
                    q.add(nei);
                    topoSortList.add(nei);
                }
            }
        }

        return topoSortList.size() == n ? topoSortList: new ArrayList<>();
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1,2));
        adjList.put(1, Arrays.asList(3));
        adjList.put(2, Arrays.asList(3));
        adjList.put(3, Arrays.asList(4,5));


        List<Integer> topoSortList = topoSort(adjList, 6);
        System.out.println(topoSortList);
    }
}
