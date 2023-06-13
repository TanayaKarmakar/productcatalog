package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 13/06/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumWidthOfBinaryTreeLeetcode662 {
  static class QueueItem {
    TreeNode node;
    int nodeIndx;

    public QueueItem(TreeNode node, int nodeIndx) {
      this.node = node;
      this.nodeIndx = nodeIndx;
    }
  }

  private static int widthOfBinaryTree(TreeNode root) {
    if(root == null)
      return 0;
    Queue<QueueItem> queue = new LinkedList<>();
    queue.add(new QueueItem(root, 0));

    int maxWidth = 1;
    while(!queue.isEmpty()) {
      int size = queue.size();
      int startIndx = -1;
      int endIndx = -1;
      for(int i = 0; i < size; i++) {
        QueueItem remItem = queue.poll();
        if(i == 0) {
          startIndx = remItem.nodeIndx;
        }
        if(i == size - 1) {
          endIndx = remItem.nodeIndx;
        }

        if(remItem.node.left != null) {
          queue.add(new QueueItem(remItem.node.left, 2 * remItem.nodeIndx + 1));
        }

        if(remItem.node.right != null) {
          queue.add(new QueueItem(remItem.node.right, 2 * remItem.nodeIndx + 2));
        }
      }
      maxWidth = Integer.max(maxWidth, (endIndx - startIndx + 1));
    }
    return maxWidth;
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
