package graph;

import common.GraphUtil;

import java.util.*;

/**
 * @author t0k02w6 on 06/03/22
 * @project ds-algo-2021
 */
class Node {
    int node;
    String pathSoFar;

    public Node(int node, String pathSoFar) {
        this.node = node;
        this.pathSoFar = pathSoFar;
    }
}

public class BreadthFirstSearch {
    private static void bfs(int[][] paths, int start, int end) {
        Map<Integer, List<Integer>> adjList = GraphUtil.buildGraph(paths);

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, start + " "));

        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.node == end) {
                System.out.println(node.pathSoFar);
                continue;
            }
            List<Integer> neighbors = adjList.get(node.node);
            for(Integer nei: neighbors) {
                if(!visited.contains(nei)) {
                    visited.add(nei);
                    q.add(new Node(nei, node.pathSoFar + nei + " "));
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] paths = {{0,1},{1,2},{2,3},{0,3},{1,4},{4,5},{2,5},{4,6},{5,6}};

        int start = 0;
        int end = 6;

        bfs(paths, start, end);
    }
}
