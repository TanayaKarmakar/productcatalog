package com.app.medium;

import java.util.*;

public class TimeNeededToInformAllTheEmployeesLeetcode1376 {
    static class NodeItem {
        int node;
        int informTime;

        public NodeItem(int node, int informTime) {
            this.node = node;
            this.informTime = informTime;
        }
    }

    private static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < manager.length; i++) {
            int value = manager[i];
            if(value != -1) {
                if(!adjList.containsKey(value)) {
                    adjList.put(value, new ArrayList<>());
                }
                adjList.get(value).add(i);
            }
        }

        int maxTime = 0;
        Queue<NodeItem> queue = new LinkedList<>();
        queue.add(new NodeItem(headID, 0));

        while(!queue.isEmpty()) {
            NodeItem remItem = queue.poll();

            List<Integer> neighbors = adjList.getOrDefault(remItem.node, new ArrayList<>());

            if(!neighbors.isEmpty()) {
                for(Integer nei: neighbors) {
                    int nextInformTime = informTime[remItem.node] + remItem.informTime;
                    queue.add(new NodeItem(nei, nextInformTime));
                    maxTime = Integer.max(maxTime, nextInformTime);
                }
            }
        }
        return maxTime;
    }

    public static void main(String[] args) {

    }
}
