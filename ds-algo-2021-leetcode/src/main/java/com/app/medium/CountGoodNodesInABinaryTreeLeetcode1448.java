package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 07/07/23
 * @project ds-algo-2021-leetcode
 */
public class CountGoodNodesInABinaryTreeLeetcode1448 {
  private static int count = 0;

  private static int goodNodes(TreeNode root) {
    count = 0;
    goodNodesRec(root, root.val);
    return count;
  }

  private static void goodNodesRec(TreeNode root, int maxval) {
    if(root == null)
      return;
    if(maxval <= root.val) {
      count++;
      maxval = root.val;
    }
    goodNodesRec(root.left, maxval);
    goodNodesRec(root.right, maxval);
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

    root = new TreeNode(3);
    root.left = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(2);

    ans = goodNodes(root);

    System.out.println(ans);
  }
}
