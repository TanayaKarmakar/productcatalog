package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 08/04/23
 * @project ds-algo-2021-leetcode
 */
public class CountGoodNodesInABinaryTreeLeetcode1448 {
  private static int count = 0;

  private static int goodNodes(TreeNode root) {
    count = 0;
    countNodesRec(root, root.val);
    return count;
  }

  private static void countNodesRec(TreeNode root, int maxVal) {
    if(root == null)
      return;
    if(root.val >= maxVal)
      count++;
    countNodesRec(root.left, Integer.max(root.val, maxVal));
    countNodesRec(root.right, Integer.max(root.val, maxVal));
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
