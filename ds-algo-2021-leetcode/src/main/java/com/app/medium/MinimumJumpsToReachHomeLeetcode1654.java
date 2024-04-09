package com.app.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpsToReachHomeLeetcode1654 {
    static class JumpItem {
        int currentPos;
        String pathSoFar;

        public JumpItem(int currentPos, String pathSoFar) {
            this.currentPos = currentPos;
            this.pathSoFar = pathSoFar;
        }
    }

    private static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> forbiddenSet = new HashSet<>();
        for(int item: forbidden) {
            forbiddenSet.add(item);
        }

        if(forbiddenSet.contains(0) || forbiddenSet.contains(x))
            return -1;

        Queue<JumpItem> queue = new LinkedList<>();
        queue.add(new JumpItem(0, "S"));
        visited.add(0);
        int count = 0;
        int limit = 6000;


        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                JumpItem remNode = queue.poll();

                if(remNode.currentPos == x)
                    return count;

                int forward = remNode.currentPos + a;
                if(!visited.contains(forward) && !forbiddenSet.contains(forward) && forward > 0 && forward < limit) {
                    queue.add(new JumpItem(forward, remNode.pathSoFar + "F"));
                    visited.add(forward);
                }

                int backward = remNode.currentPos - b;
                char lastChar = remNode.pathSoFar.charAt(remNode.pathSoFar.length() - 1);
                if(!visited.contains(backward) && !forbiddenSet.contains(backward) && backward > 0 && lastChar != 'B') {
                    queue.add(new JumpItem(backward, remNode.pathSoFar + "B"));
                    visited.add(backward);
                }
            }
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] forbidden = {14,4,18,1,15};
        int a = 3;
        int b = 15;
        int x = 9;
        int ans = minimumJumps(forbidden, a, b, x);

        System.out.println(ans);

        forbidden = new int[]{8,3,16,6,12,20};
        a = 15;
        b = 13;
        x = 11;
        ans = minimumJumps(forbidden, a, b, x);

        System.out.println(ans);
    }
}
