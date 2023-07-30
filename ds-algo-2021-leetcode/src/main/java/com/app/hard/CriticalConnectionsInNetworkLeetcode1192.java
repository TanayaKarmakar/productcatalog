package com.app.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author t0k02w6 on 27/07/23
 * @project ds-algo-2021-leetcode
 */
public class CriticalConnectionsInNetworkLeetcode1192 {
  private static int timer = 1;

  private static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    LinkedList<Integer>[] adjList = new LinkedList[n];
    boolean[] visited = new boolean[n];
    int[] timeOfInsertion = new int[n];
    int[] low = new int[n];
    timer = 1;

    for(List<Integer> currentConnection: connections) {
      int src = currentConnection.get(0);
      int dest = currentConnection.get(1);
      if(adjList[src] == null)
        adjList[src] = new LinkedList<>();
      adjList[src].add(dest);

      if(adjList[dest] == null)
        adjList[dest] = new LinkedList<>();
      adjList[dest].add(src);
    }

    List<List<Integer>> bridges = new ArrayList<>();

    dfs(adjList, 0, -1, visited, timeOfInsertion, low, bridges);
    return bridges;
  }

  private static void dfs(LinkedList<Integer>[] adjList, int node, int parent, boolean[] visited, int[] timeOfInsertion, int[] low, List<List<Integer>> bridges) {
    visited[node] = true;
    timeOfInsertion[node] = low[node] = timer;
    timer++;

    LinkedList<Integer> neighbors = adjList[node];
    for(Integer nei: neighbors) {
      if(nei == parent)
        continue;
      if(!visited[nei]) {
        dfs(adjList, nei, node, visited, timeOfInsertion, low, bridges);
        low[node] = Integer.min(low[node], low[nei]);
        if(low[nei] > timeOfInsertion[node]) {
          List<Integer> bridge = new ArrayList<>();
          bridge.add(node);
          bridge.add(nei);
          bridges.add(bridge);
        }
      } else {
        low[node] = Integer.min(low[node], low[nei]);
      }
    }
  }

  public static void main(String[] args) {
    int n = 4;
    List<List<Integer>> connections = new ArrayList<>();
    List<Integer> connection = new ArrayList<>();
    connection.add(0);
    connection.add(1);
    connections.add(connection);

    connection = new ArrayList<>();
    connection.add(1);
    connection.add(2);
    connections.add(connection);

    connection = new ArrayList<>();
    connection.add(2);
    connection.add(0);
    connections.add(connection);

    connection = new ArrayList<>();
    connection.add(1);
    connection.add(3);
    connections.add(connection);

    List<List<Integer>> ans = criticalConnections(n, connections);
    System.out.println(ans);
  }
}
