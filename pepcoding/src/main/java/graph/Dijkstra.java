package graph;

import common.Pair1;
import common.Triplet;

import java.util.*;

/**
 * @author t0k02w6 on 07/03/22
 * @project ds-algo-2021
 */
class WeightComparator implements Comparator<Triplet<Integer, String, Integer>> {

    @Override
    public int compare(Triplet<Integer, String, Integer> o1, Triplet<Integer, String, Integer> o2) {
        return o1.third - o2.third;
    }
}

public class Dijkstra {
    private static Map<Integer, List<Pair1<Integer, Integer>>> buildGraph(int[][] paths) {
        Map<Integer, List<Pair1<Integer, Integer>>> adjList = new HashMap<>();
        for(int i = 0; i < paths.length; i++) {
            int[] currentPath = paths[i];
            Pair1<Integer, Integer> pair1 = new Pair1<>(currentPath[0], currentPath[2]);
            Pair1<Integer, Integer> pair2 = new Pair1<>(currentPath[1], currentPath[2]);

            if(!adjList.containsKey(currentPath[0])) {
                adjList.put(currentPath[0], new ArrayList<>());
            }
            adjList.get(currentPath[0]).add(pair2);

            if(!adjList.containsKey(currentPath[1])) {
                adjList.put(currentPath[1], new ArrayList<>());
            }
            adjList.get(currentPath[1]).add(pair1);
        }
        return adjList;
    }

    public static void printShortestPath(int[][] paths, int start, int nVertices) {
        Map<Integer, List<Pair1<Integer, Integer>>> adjList = buildGraph(paths);
        PriorityQueue<Triplet<Integer, String, Integer>> q = new PriorityQueue<>(new WeightComparator());

        boolean[] visited = new boolean[nVertices];

        q.add(new Triplet<>(start, start + " ", 0));
        while(!q.isEmpty()) {
            Triplet<Integer, String, Integer> triplet = q.poll();

            if(visited[triplet.first])
                continue;
            visited[triplet.first] = true;
            System.out.println(triplet.first + " Via " + triplet.second + " @ " + triplet.third);

            List<Pair1<Integer, Integer>> neighbors = adjList.get(triplet.first);
            for(Pair1<Integer, Integer> nei: neighbors) {
                if(!visited[nei.first]) {
                    q.add(new Triplet<>(nei.first, triplet.second + nei.first + " ", triplet.third + nei.second));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] paths = {{0,1,10},{1,2,8},{2,3,4},{0,3,10},{1,4,5},{4,6,10},{5,6,8},{4,5,2}};

        int start = 0;
        int nVertices = 7;

        printShortestPath(paths, start, nVertices);
    }
}
