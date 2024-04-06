package com.app.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BiPartiteGraphLeetcode785 {
    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);

        for(int i = 0; i < n; i++) {
            if(colors[i] == -1) {
                if(!isBipartite(graph, i, colors))
                    return false;
            }
        }
        return true;
    }

    private static boolean isBipartite(int[][] graph, int node, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = 1;

        while(!queue.isEmpty()) {
            Integer remNode = queue.poll();
            int[] neighbors = graph[remNode];

            for(Integer nei: neighbors) {
                if(colors[nei] == -1) {
                    colors[nei] = 1 - colors[node];
                    queue.add(nei);
                } else if(colors[nei] == colors[node])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};

        boolean ans = isBipartite(graph);

        System.out.println(ans);
    }
}
