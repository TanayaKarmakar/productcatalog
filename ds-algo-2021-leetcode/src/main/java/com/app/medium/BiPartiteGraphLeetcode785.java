package com.app.medium;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 14/04/23
 * @project ds-algo-2021-leetcode
 */
public class BiPartiteGraphLeetcode785 {
  private static boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n];

    Arrays.fill(colors, -1);

    for(int i = 0; i < n; i++) {
      if(colors[i] == -1) {
        if(!isBipartiteHelper(graph, i, colors)) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean isBipartiteHelper(int[][] graph, int currentNode, int[] colors) {
    Queue<Integer> q = new LinkedList<>();
    q.add(currentNode);
    colors[currentNode] = 1;

    while(!q.isEmpty()) {
      int node = q.poll();
      int[] neighbors = graph[node];

      for(int nei: neighbors) {
        if(colors[nei] == -1) {
          colors[nei] = 1 - colors[node];
          q.add(nei);
        } else if(colors[nei] == colors[node])
          return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {

  }
}
