package com.app.hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 01/12/22
 * @project ds-algo-2021
 */
public class BusRoutesLeetcode815 {
  private static int numBusesToDestination(int[][] routes, int source, int target) {
    Map<Integer, Set<Integer>> adjList = new HashMap<>();

    for(int[] route: routes) {
      for(int val: route) {
        if(!adjList.containsKey(val))
          adjList.put(val, new HashSet<>());
        for(int val1: route) {
          if(val != val1)
            adjList.get(val).add(val1);
        }
      }
    }

    int count = 0;
    Queue<Integer> q = new LinkedList<>();
    q.add(source);

    Set<Integer> visited = new HashSet<>();

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        Integer el = q.poll();
        if(el == target)
          return count;
        visited.add(el);
        Set<Integer> neighbors = adjList.getOrDefault(el, new HashSet<>());
        if(!neighbors.isEmpty()) {
          for(Integer nei: neighbors) {
            if(!visited.contains(nei))
              q.add(nei);
          }
        }
      }
      count++;
    }

    return -1;
  }

  public static void main(String[] args) {
    int[][] routes = {{1,2,7},{3,6,7}};
    int source = 1;
    int target = 6;
    int ans = numBusesToDestination(routes, source, target);

    System.out.println(ans);

    routes = new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}};
    source = 15;
    target = 12;
    ans = numBusesToDestination(routes, source, target);

    System.out.println(ans);
  }
}
