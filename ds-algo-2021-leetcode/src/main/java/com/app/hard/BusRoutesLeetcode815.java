package com.app.hard;

import java.util.*;

public class BusRoutesLeetcode815 {
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int[] route: routes) {
            for(int rt1: route) {
                if(!adjList.containsKey(rt1)) {
                    adjList.put(rt1, new ArrayList<>());
                }
                for(int rt2: route) {
                    if(rt1 != rt2) {
                        adjList.get(rt1).add(rt2);
                    }
                }
            }
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int remNode = queue.poll();
                if(remNode == target)
                    return count;
                List<Integer> neighbors = adjList.getOrDefault(remNode, new ArrayList<>());
                for(Integer nei: neighbors) {
                    if(!visited.contains(nei)) {
                        queue.add(nei);
                        visited.add(nei);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
