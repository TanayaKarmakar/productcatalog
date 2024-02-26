package com.app.hard;

import java.util.*;

public class BusRoutesLeetcode815 {
    private static int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, Set<Integer>> adjList = new HashMap<>();

        for(int[] route: routes) {
            for(int curr: route) {
                if(!adjList.containsKey(curr))
                    adjList.put(curr, new HashSet<>());
                for(int curr1: route) {
                    if(curr != curr1) {
                        adjList.get(curr).add(curr1);
                    }
                }
            }
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int el = queue.poll();
                if(el == target)
                    return count;
                visited.add(el);
                Set<Integer> neighbors = adjList.getOrDefault(el, new HashSet<>());
                for(Integer nei: neighbors) {
                    if(!visited.contains(nei))
                        queue.add(nei);
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        int start = 1;
        int end = 6;

        int ans = numBusesToDestination(routes, start, end);

        System.out.println(ans);
    }
}
