package graph;

import common.GraphUtil;
import common.Util;

import java.util.*;

/**
 * @author t0k02w6 on 05/03/22
 * @project ds-algo-2021
 */
public class PerfectFriends {
    private static void findConnectedComponents(Map<Integer, List<Integer>> adjList, int node,
                                                Set<Integer> visited, List<Integer> components) {
        visited.add(node);
        components.add(node);

        List<Integer> neighbors = adjList.get(node);

        for(Integer nei: neighbors) {
            if(!visited.contains(nei)) {
                findConnectedComponents(adjList, nei, visited, components);
            }
        }
    }

    private static int findWays(int[][] edges, int nVertices) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(edges);
        List<List<Integer>> components = new ArrayList<>();

        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < nVertices; i++) {
            if(!visited.contains(i)) {
                List<Integer> component = new ArrayList<>();
                findConnectedComponents(adjList, i, visited, component);
                components.add(component);
            }
        }

        if(components.size() == 1)
            return 0;
        int totalWays = 0;
        for(int i = 0; i < components.size(); i++) {
            for(int j = i + 1; j < components.size(); j++) {
                totalWays += (components.get(i).size() * components.get(j).size());
            }
        }
        return totalWays;
    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{2,3},{4,5},{5,6},{4,6}};
        int nVertices = 7;

        int totalWays = findWays(edges, nVertices);

        System.out.println(totalWays);
    }
}
