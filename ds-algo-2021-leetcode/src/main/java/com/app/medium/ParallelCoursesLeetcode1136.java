package com.app.medium;

import java.util.*;

public class ParallelCoursesLeetcode1136 {
    private static int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDeg = new int[n + 1];
        for(int i = 0; i < relations.length; i++) {
            int prevCourse = relations[i][0];
            int nextCourse = relations[i][1];

            if(!adjList.containsKey(prevCourse))
                adjList.put(prevCourse, new ArrayList<>());
            adjList.get(prevCourse).add(nextCourse);
            inDeg[nextCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int j = 0;
        for(int i = 1; i <= n; i++) {
            if(inDeg[i] == 0) {
                queue.add(i);
                j++;
            }
        }

        if(queue.isEmpty())
            return -1;
        int count = 0;


        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer remNode = queue.poll();
                List<Integer> neighbors = adjList.getOrDefault(remNode, new ArrayList<>());
                if(!neighbors.isEmpty()) {
                    for(Integer nei: neighbors) {
                        inDeg[nei]--;
                        if(inDeg[nei] == 0) {
                            queue.add(nei);
                            j++;
                        }
                    }
                }
            }
            count++;
        }

        return j == n ? count: -1;
    }

    public static void main(String[] args) {
        int[][] relations = {{1,3},{2,3}};
        int n = 3;
        int ans = minimumSemesters(n, relations);

        System.out.println(ans);
    }
}
