package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 02/04/22
 * @project ds-algo-2021
 */
public class CourseScheduleLeetcode207 {
    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDeg = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            int dest = pair[0];
            int source = pair[1];

            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());
            adjList.get(source).add(dest);
            inDeg[dest]++;
        }

        int courseFinished = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                courseFinished++;
            }
        }

        while(!q.isEmpty()) {
            Integer node = q.poll();

            List<Integer> neibhbors = adjList.getOrDefault(node, new ArrayList<>());
            for(Integer nei: neibhbors) {
                inDeg[nei]--;
                if(inDeg[nei] == 0) {
                    q.add(nei);
                    courseFinished++;
                }
            }
        }
        return courseFinished == numCourses;
    }

    public static void main(String[] args) {

    }
}
