package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class MaximumWidthOfBinaryTreeLeetcode662 {
  static class Item {
    TreeNode node;
    int indx;

    public Item(TreeNode node, int indx) {
      this.node = node;
      this.indx = indx;
    }
  }

  private static int widthOfBinaryTree(TreeNode root) {
    int maxWidth = 1;
    Queue<Item> q = new LinkedList<>();
    q.add(new Item(root, 0));

    while(!q.isEmpty()) {
      int start = -1;
      int end = -1;
      int size = q.size();
      for(int i = 0; i < size; i++) {
        Item remItem = q.poll();
        if(i == 0) {
          start = remItem.indx;
        }
        if(i == size - 1) {
          end = remItem.indx;
        }
        maxWidth = Integer.max(end - start + 1, maxWidth);
        if(remItem.node.left != null) {
          q.add(new Item(remItem.node.left, 2 * remItem.indx));
        }
        if(remItem.node.right != null) {
          q.add(new Item(remItem.node.right, 2 * remItem.indx + 1));
        }
      }
    }
    return maxWidth;
  }

  public static void main(String[] args) {

  }
}
