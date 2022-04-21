package graph;


import java.util.*;

/**
 * @author t0k02w6 on 21/04/22
 * @project ds-algo-2021
 */
public class CycleDetectionUsingKahnsAlgo {
    private static boolean isCyclePresent(Map<Integer, List<Integer>> adjList, int n) {
        int[] inDeg = new int[n];
        for(Map.Entry<Integer, List<Integer>> entry: adjList.entrySet()) {
            List<Integer> neighbors = entry.getValue();
            for(Integer nei: neighbors) {
                inDeg[nei]++;
            }
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()) {
            Integer remNode = q.poll();
            List<Integer> neighbors = adjList.get(remNode);
            for(Integer nei: neighbors) {
                inDeg[nei]--;
                if(inDeg[nei] == 0) {
                    q.add(nei);
                    count++;
                }
            }
        }

        return count != n;
    }


    public static void main(String[] args) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        adjList.put(0, Arrays.asList(1));
        adjList.put(1, Arrays.asList(2));
        adjList.put(2, Arrays.asList(0, 3));

        boolean ans = isCyclePresent(adjList, 4);
        System.out.println(ans);

    }
}
