package com.app.topics.unionfind;

/**
 * @author t0k02w6 on 23/07/23
 * @project ds-algo-2021-leetcode
 */
//by rank and path compression

public class UnionFind {
  int[] parent;
  int[] rank;

  public UnionFind(int n) {
    this.parent = new int[n];
    this.rank = new int[n];

    for(int i = 0; i < n; i++) {
      this.parent[i] = i;
    }
  }

  public void unionByRank(int u, int v) {
    int parentU = findParent(u);
    int parentV = findParent(v);
    if(parentU == parentV)
      return;
    if(rank[parentU] < rank[parentV]) {
      parent[parentU] = parentV;
    } else if(rank[parentV] < rank[parentU]) {
      parent[parentV] = parentU;
    } else {
      parent[parentU] = parentV;
      rank[parentV]++;
    }
  }

  public int findParent(int node) {
    if(parent[node] == node)
      return node;
    parent[node] = findParent(parent[node]);
    return parent[node];
  }
}
