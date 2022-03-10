package graph;

import common.Pair1;
import common.Triplet;

import java.util.*;

/**
 * @author t0k02w6 on 07/03/22
 * @project ds-algo-2021
 */
class MSTWeightComparator implements Comparator<Triplet<Integer, Integer, Integer>> {

    @Override
    public int compare(Triplet<Integer, Integer, Integer> o1, Triplet<Integer, Integer, Integer> o2) {
        return o1.third - o2.third;
    }
}

public class PrimsAlgorithm {
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

    private static void printMinimalSpanningTree(int[][] paths, int start, int nVertices) {
        Map<Integer, List<Pair1<Integer, Integer>>> adjList = buildGraph(paths);

        PriorityQueue<Triplet<Integer, Integer, Integer>> pQ = new PriorityQueue<>(new MSTWeightComparator());
        pQ.add(new Triplet<>(start, -1, 0));

        boolean[] visited = new boolean[nVertices];

        while(!pQ.isEmpty()) {
            Triplet<Integer, Integer, Integer> triplet = pQ.poll();
            if(visited[triplet.first])
                continue;
            visited[triplet.first] = true;
            if(triplet.second != -1) {
                System.out.println(triplet.first + " via " + triplet.second + " @ " + triplet.third);
            }

            List<Pair1<Integer, Integer>> neighbors = adjList.get(triplet.first);
            for(Pair1<Integer,Integer> nei: neighbors) {
                if(!visited[nei.first]) {
                    pQ.add(new Triplet<>(nei.first, triplet.first, nei.second));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] paths = {{0,1,10},{1,2,8},{2,3,4},{0,3,10},{1,4,5},{4,6,10},{5,6,8},{4,5,2}};

        int start = 0;
        int nVertices = 7;

        printMinimalSpanningTree(paths, start, nVertices);
    }
}
