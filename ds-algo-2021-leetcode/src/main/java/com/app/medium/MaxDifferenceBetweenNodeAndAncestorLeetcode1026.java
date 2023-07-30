package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class MaxDifferenceBetweenNodeAndAncestorLeetcode1026 {
  private static int result;

  private static int maxAncestorDiff(TreeNode root) {
    result = 0;
    maxAncestorDiffRec(root, root.val, root.val);
    return result;
  }

  private static void maxAncestorDiffRec(TreeNode root, int min, int max) {
    if(root == null)
      return;
    result = Integer.max(result, Integer.max(Math.abs(root.val - min), Math.abs(root.val - max)));
    min = Integer.min(min, root.val);
    max = Integer.max(max, root.val);
    maxAncestorDiffRec(root.left, min, max);
    maxAncestorDiffRec(root.right, min, max);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(3);
    root.right = new TreeNode(10);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(6);
    root.left.right.left = new TreeNode(4);
    root.left.right.right = new TreeNode(7);
    root.right.right = new TreeNode(14);
    root.right.right.left = new TreeNode(13);

    int ans = maxAncestorDiff(root);

    System.out.println(ans);
  }
}
