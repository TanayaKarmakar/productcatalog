package com.app.medium;

import java.util.*;

/**
 * @author t0k02w6 on 29/03/22
 * @project ds-algo-2021
 */
public class CourseScheduleIILeetcode210 {


    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDeg = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int[] prereq = prerequisites[i];
            int s = prereq[1];
            int t = prereq[0];
            if(!adjList.containsKey(s)) {
                adjList.put(s, new ArrayList<>());
            }
            adjList.get(s).add(t);
            inDeg[t]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDeg[i] == 0)
                q.add(i);
        }

        int[] finalAns = new int[numCourses];
        int count = 0;
        while(!q.isEmpty()) {
            Integer el = q.poll();
            finalAns[count] = el;
            count++;

            List<Integer> neighbors = adjList.getOrDefault(el, new ArrayList<>());
            for(Integer nei: neighbors) {
                inDeg[nei]--;
                if(inDeg[nei] == 0)
                    q.add(nei);
            }
        }

        return count == numCourses ? finalAns: new int[]{};
    }



    public static void main(String[] args) {
        int[][] prerequisites = {};
        int numCourses = 2;

        int[] ans = findOrder( numCourses, prerequisites);

        System.out.println(Arrays.toString(ans));

    }
}
