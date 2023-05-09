package com.app.topics.segmenttree.revision;

/**
 * @author t0k02w6 on 07/05/23
 * @project ds-algo-2021-leetcode
 */
public class BalancedParenthesisBetweenRange {
  static class SegTreeNode {
    int nOpen;
    int nClose;
    int nFull;

    public SegTreeNode(int nOpen, int nClose, int nFull) {
      this.nOpen = nOpen;
      this.nClose = nClose;
      this.nFull = nFull;
    }
  }

  private static SegTreeNode[] segTree;

  private static void build(String str) {
    int n = str.length();
    segTree = new SegTreeNode[4 * n];
    buildTreeRec(str, 0, n - 1, 0);
  }

  private static void buildTreeRec(String str, int low, int high, int treeIndx) {
    if(low == high) {
      int nOpen = 0;
      int nClose = 0;
      int nFull = 0;
      char ch = str.charAt(low);
      if(ch == '(') {
        nOpen++;
      } else {
        nClose++;
      }
      SegTreeNode segTreeNode = new SegTreeNode(nOpen, nClose, nFull);
      segTree[treeIndx] = segTreeNode;
      return;
    }
    int mid = (low + high) >> 1;
    buildTreeRec(str, low, mid, 2 * treeIndx + 1);
    buildTreeRec(str, mid + 1, high, 2 * treeIndx + 2);
    SegTreeNode leftNode = segTree[2 * treeIndx + 1];
    SegTreeNode rightNode = segTree[2 * treeIndx + 2];
    int nOpen = leftNode.nOpen + rightNode.nOpen - Integer.min(leftNode.nOpen, rightNode.nClose);
    int nClose = leftNode.nClose + rightNode.nClose - Integer.min(leftNode.nOpen, rightNode.nClose);
    int nFull = leftNode.nFull + rightNode.nFull + Integer.min(leftNode.nOpen, rightNode.nClose);
    SegTreeNode segTreeNode = new SegTreeNode(nOpen, nClose, nFull);
    segTree[treeIndx] = segTreeNode;
  }

  public static void main(String[] args) {
    String str = "";
  }
}
