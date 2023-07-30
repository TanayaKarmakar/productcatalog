package com.app.topics.unionfind;

/**
 * @author t0k02w6 on 23/07/23
 * @project ds-algo-2021-leetcode
 */
public class UnionFindTest {
  public static void main(String[] args) {
    int[][] edges = {{1,2},{2,3},{3,4},{5,6},{6,7}};
    int n = 8;
    UnionFind unionFind = new UnionFind(n);
    unionFind.unionByRank(1,2);
    unionFind.unionByRank(2, 3);
    unionFind.unionByRank(3, 4);

    unionFind.unionByRank(5, 6);
    unionFind.unionByRank(6, 7);

    for(int i = 1; i < n; i++) {
      System.out.println(unionFind.findParent(i));
    }
  }
}
