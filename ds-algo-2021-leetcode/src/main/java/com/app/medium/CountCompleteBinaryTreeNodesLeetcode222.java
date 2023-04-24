package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class CountCompleteBinaryTreeNodesLeetcode222 {
  private static int countNodes(TreeNode root) {
    if(root == null)
      return 0;
    int lCount = 0;
    TreeNode left = root;
    while(left != null) {
      left = left.left;
      lCount++;
    }

    TreeNode right = root;
    int rCount = 0;
    while(right != null) {
      right = right.right;
      rCount++;
    }

    if(lCount == rCount)
      return  (int)Math.pow(2, lCount) - 1;
    return countNodes(root.left) + countNodes(root.right) + 1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    int ans = countNodes(root);

    System.out.println(ans);

  }
}
