package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 24/09/22
 * @project ds-algo-2021-leetcode
 */
public class CourseScheduleIILeetcode210 {
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDeg = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int source = prerequisites[i][1];
            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());
            adjList.get(source).add(dest);
            inDeg[dest]++;
        }

        int[] result = new int[numCourses];
        int count = 0;
        int j = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDeg[i] == 0) {
                count++;
                result[j++] = i;
                q.add(i);
            }
        }


        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> neighbours = adjList.getOrDefault(curr, new ArrayList<>());
            for(Integer el: neighbours) {
                inDeg[el]--;
                if(inDeg[el] == 0) {
                    result[j++] = el;
                    q.add(el);
                    count++;
                }
            }
        }

        return count == numCourses ? result: new int[]{};
    }

    public static void main(String[] args) {

    }
}
