package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 26/09/22
 * @project ds-algo-2021-leetcode
 */
public class BiPartiteLeetcode785 {
    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        Arrays.fill(colors, -1);
        for(int i = 0; i < n; i++) {
            if(colors[i] == -1) {
                if(!isBipartiteHelper(i, graph, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isBipartiteHelper(int start, int[][] graph, int[] colors) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        colors[start] = 1;

        while(!q.isEmpty()) {
            Integer el = q.poll();
            int currentColor = colors[el];
            int[] neighbors = graph[el];

            for(int i = 0; i < neighbors.length; i++) {
                if(colors[neighbors[i]] == currentColor)
                    return false;
                if(colors[neighbors[i]] == -1) {
                    int nextValue = 1 - currentColor;
                    colors[neighbors[i]] = nextValue;
                    q.add(neighbors[i]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};

        boolean ans = isBipartite(graph);

        System.out.println(ans);
    }
}
