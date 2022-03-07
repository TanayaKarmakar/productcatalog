package graph;

import common.GraphUtil;

import java.util.*;

/**
 * @author t0k02w6 on 06/03/22
 * @project ds-algo-2021
 */
class Pair {
    int node;
    int level;

    public Pair(int node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class BiPartiteGraph {
    private static boolean isBiPartite(int[][] paths, int nVertices) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(paths);
        int[] visited = new int[nVertices];
        Arrays.fill(visited, - 1);

        for(int i = 0; i < nVertices; i++) {
            if(visited[i] == -1) {
                boolean isBiPartite = isComponentBiPartite(adjList, i, nVertices, visited);
                if(!isBiPartite)
                    return false;
            }
        }
        return true;
    }

    private static boolean isComponentBiPartite(Map<Integer, List<Integer>> adjList, int node, int nVertices, int[] visited) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(node, 0));

        while(!queue.isEmpty()) {
            Pair removedNode = queue.poll();
            if(visited[removedNode.node] != -1) {
                if(visited[removedNode.node] != removedNode.level)
                    return false;
            } else {
                visited[removedNode.node] = removedNode.level;
            }
            List<Integer> neighbors = adjList.get(removedNode.node);
            for(Integer el: neighbors) {
                if(visited[el] == -1)
                    queue.add(new Pair(el, removedNode.level + 1));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] paths = {{0,1},{2,3},{4,5},{5,6},{4,6}};
        int nVertices = 7;

        boolean isBiPartite = isBiPartite(paths, nVertices);

        System.out.println(isBiPartite);

        paths = new int[][]{{0,1},{1,2},{2,3},{0,3}};
        nVertices = 4;
        isBiPartite = isBiPartite(paths, nVertices);

        System.out.println(isBiPartite);
    }
}
