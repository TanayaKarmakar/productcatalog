package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class CountCompleteTreeNodesLeetcode222 {
  private static int countNodes(TreeNode root) {
    if(root == null)
      return 0;
    int lHeight = 0;
    TreeNode temp = root;
    while(temp != null) {
      temp = temp.left;
      lHeight++;
    }

    int rHeight = 0;
    temp = root;
    while(temp != null) {
      temp = temp.right;
      rHeight++;
    }

    if(lHeight == rHeight) {
      return (int)Math.pow(2, lHeight) - 1;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);

    int ans = countNodes(root);

    System.out.println(ans);
  }
}
