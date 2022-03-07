package graph;

import common.GraphUtil;
import common.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author t0k02w6 on 07/03/22
 * @project ds-algo-2021
 */

public class SpeadInfectionTime {
    private static int countInfected(int[][] paths, int nVertices, int time, int start) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(paths);

        int[] visited = new int[nVertices];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 1));
        int count = 0;

        while(!queue.isEmpty()) {
            Pair removedPair = queue.poll();

            if(visited[removedPair.first] > 0){
                continue;
            }
            visited[removedPair.first] = removedPair.second;
            if(removedPair.second > time)
                break;
            count++;
            List<Integer> neighbors = adjList.get(removedPair.first);
            for(Integer nei: neighbors) {
                if(visited[nei] == 0) {
                    queue.add(new Pair(nei, removedPair.second + 1));
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] paths = {{0,1},{1,2},{2,3},{0,3},{1,4},{4,6},{5,6},{4,5}};

        int nVertices = 7;
        int start = 6;
        int time = 3;

        int ans = countInfected(paths, nVertices, time, start);
        System.out.println(ans);
    }
}
