package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 23/09/22
 * @project ds-algo-2021-leetcode
 */
public class CourseScheduleLeetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDeg = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            if(!adjList.containsKey(src)) {
                adjList.put(src, new ArrayList<>());
            }
            adjList.get(src).add(dest);
            inDeg[dest]++;
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDeg.length; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                count++;
            }
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbors = adjList.getOrDefault(node, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Integer el: neighbors) {
                    inDeg[el]--;
                    if(inDeg[el] == 0) {
                        q.add(el);
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
