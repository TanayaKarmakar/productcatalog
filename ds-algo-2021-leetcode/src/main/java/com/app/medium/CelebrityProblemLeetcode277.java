package com.app.medium;

/**
 * @author t0k02w6 on 16/04/22
 * @project ds-algo-2021
 */
class Solution {
    int[][] graph;
    int n;

    public Solution(int[][] graph, int n) {
        this.graph = graph;
        this.n = n;
    }

    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 0; i < n; i++) {
            if(knows(candidate, i)) {
                candidate = i;
            }
        }

        if(isCelebrity(candidate))
            return candidate;
        return -1;
    }

    private boolean isCelebrity(int candidate) {
        for(int i = 0; i < n; i++) {
            if(i == candidate) continue;
            if(knows(candidate, i) || !knows(i, candidate))
                return false;
        }
        return true;
    }

    private boolean knows(int i, int j) {
        return graph[i][j] == 1;
    }
}


public class CelebrityProblemLeetcode277 {
    public static void main(String[] args) {

    }
}
