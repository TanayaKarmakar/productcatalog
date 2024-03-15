package com.app.easy;

public class FindTheTownJudgeLeetcode997 {
    private static int findJudge(int n, int[][] trust) {
        int[] inDeg = new int[n + 1];
        int[] outDeg = new int[n + 1];

        for(int i = 0; i < trust.length; i++) {
            int source = trust[i][0];
            int target = trust[i][1];

            inDeg[target]++;
            outDeg[source]++;
        }

        for(int i = 1; i <= n; i++) {
            if(inDeg[i] == n - 1 && outDeg[i] == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
