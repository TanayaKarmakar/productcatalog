package com.app.easy;

/**
 * @author t0k02w6 on 15/06/23
 * @project ds-algo-2021-leetcode
 */
public class FindTheTownJudgeLeetcode997 {
  private static int findJudge(int n, int[][] trust) {
    int[] inDeg = new int[n + 1];
    int[] outDeg = new int[n + 1];

    for(int i = 0; i < trust.length; i++) {
      int[] currentNode = trust[i];
      int a = currentNode[0];
      int b = currentNode[1];
      inDeg[b]++;
      outDeg[a]++;
    }

    for(int i = 1; i <= n; i++) {
      if(inDeg[i] == (n - 1) && outDeg[i] == 0)
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(findJudge(2, new int[][]{{1,2}}));
  }
}
