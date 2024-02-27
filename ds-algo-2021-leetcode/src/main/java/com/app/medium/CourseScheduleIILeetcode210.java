package com.app.medium;

import java.util.*;

public class CourseScheduleIILeetcode210 {
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDeg = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][1];
            int target = prerequisites[i][0];

            if(!adjList.containsKey(source))
                adjList.put(source, new ArrayList<>());
            adjList.get(source).add(target);

            inDeg[target]++;
        }

        int[] order = new int[numCourses];
        int count = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDeg[i] == 0) {
                q.add(i);
                order[count++] = i;
            }
        }

        if(q.isEmpty())
            return new int[]{};


        while(!q.isEmpty()) {
            Integer currNode = q.poll();

            List<Integer> neighbors = adjList.getOrDefault(currNode, new ArrayList<>());
            if(!neighbors.isEmpty()) {
                for(Integer nei: neighbors) {
                    inDeg[nei]--;
                    if(inDeg[nei] == 0) {
                        order[count++] = nei;
                        q.add(nei);
                    }
                }
            }
        }

        return count == numCourses ? order: new int[]{};

    }

    public static void main(String[] args) {
        int[][] prereq = {};
        int numCourses = 1;

        int[] ans = findOrder(numCourses, prereq);
        System.out.println(Arrays.toString(ans));

        prereq = new int[][]{{1,0}};
        numCourses = 2;
        ans = findOrder(numCourses, prereq);
        System.out.println(Arrays.toString(ans));

        prereq = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        numCourses = 4;
        ans = findOrder(numCourses, prereq);
        System.out.println(Arrays.toString(ans));
    }
}
