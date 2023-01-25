package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 18/11/22
 * @project ds-algo-2021
 */
public class CountGoodNodesInABinaryTreeLeetcode1448 {
  private static int count = 0;

  public static int goodNodes(TreeNode root) {
    count = 0;
    goodNodesRec(root, Integer.MIN_VALUE);
    return count;
  }

  private static void goodNodesRec(TreeNode root, int maxVal) {
    if(root == null)
      return;
    if(root.val >= maxVal) {
      maxVal = root.val;
      count++;
    }
    goodNodesRec(root.left, maxVal);
    goodNodesRec(root.right, maxVal);

  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.left = new TreeNode(3);
    root.right.left = new TreeNode(1);
    root.right.right = new TreeNode(5);

    int ans = goodNodes(root);

    System.out.println(ans);
  }
}
