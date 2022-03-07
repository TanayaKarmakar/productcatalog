package graph;

import common.GraphUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author t0k02w6 on 05/03/22
 * @project ds-algo-2021
 */
public class Hamiltonian {
    private static void printPath(int[][] paths, int nVertices) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(paths);
        Set<Integer> visited = new HashSet<>();

        int originalSource = 0;
        int start = 0;
        String pathSofar = start + "";
        hamiltonian(adjList, visited,nVertices, start, pathSofar, originalSource);
    }

    private static void hamiltonian(Map<Integer, List<Integer>> adjList, Set<Integer> visited,int nVertices, int start, String pathSofar, int originalSource) {
        if(visited.size() == nVertices - 1) {
            List<Integer> neighbors = adjList.get(start);
            boolean cycleFound = false;
            for(Integer nei: neighbors) {
                if(nei == originalSource) {
                    cycleFound = true;
                    break;
                }
            }
            System.out.println(pathSofar + (cycleFound ? "Cycle":"Path"));
            return;
        }
        visited.add(start);
        List<Integer> neighbors = adjList.get(start);
        for(Integer nei: neighbors) {
            if(!visited.contains(nei))
                hamiltonian(adjList, visited, nVertices, nei, pathSofar + " " + nei, originalSource);
        }
        visited.remove(start);
    }

    public static void main(String[] args) {
        int[][] paths = {{0,1},{1,2},{2,3},{0,3},{1,4},{4,5},{2,5},{4,6},{5,6}};
        int nVertices = 7;

        printPath(paths, nVertices);
    }
}
