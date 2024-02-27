package com.app.medium;

import java.util.*;

public class CourseScheduleLeetcode207 {
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        int[] inDeg = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1];
            int target = prerequisites[i][0];
            if(!adjList.containsKey(source)) {
                adjList.put(source, new ArrayList<>());
            }
            adjList.get(source).add(target);
            inDeg[target]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < numCourses; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if(q.isEmpty())
            return false;

        while(!q.isEmpty()) {
            Integer currNode = q.poll();
            List<Integer> neighbors = adjList.getOrDefault(currNode, new ArrayList<>());

            if(!neighbors.isEmpty()) {
                for(Integer nei: neighbors) {
                    inDeg[nei]--;
                    if(inDeg[nei] == 0) {
                        q.add(nei);
                        count++;
                    }
                }
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {

    }
}
