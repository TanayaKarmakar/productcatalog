package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author t0k02w6 on 26/04/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumWidthOfBinaryTreeLeetcode662 {
  static class TreeItem {
    TreeNode node;
    int nodeIndx;

    public TreeItem(TreeNode node, int nodeIndx) {
      this.node = node;
      this.nodeIndx = nodeIndx;
    }
  }

  private static int widthOfBinaryTree(TreeNode root) {
    Queue<TreeItem> q = new LinkedList<>();
    q.add(new TreeItem(root, 0));
    int minWidth = 0;

    while(!q.isEmpty()) {
      int size = q.size();
      int start = -1;
      int end = -1;
      for(int i = 0; i < size; i++) {
        TreeItem remItem = q.poll();
        if(i == 0) {
          start = remItem.nodeIndx;
        }

        if(i == size - 1) {
          end = remItem.nodeIndx;
        }

        minWidth = Integer.max(minWidth, end - start + 1);

        if(remItem.node.left != null) {
          q.add(new TreeItem(remItem.node.left, 2 * remItem.nodeIndx));
        }

        if(remItem.node.right != null) {
          q.add(new TreeItem(remItem.node.left, 2 * remItem.nodeIndx + 1));
        }
      }
    }
    return minWidth;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(3);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(3);
    root.right.right = new TreeNode(9);

    int ans = widthOfBinaryTree(root);

    System.out.println(ans);
  }
}
