package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 05/06/23
 * @project ds-algo-2021-leetcode
 */
public class MaximumDifferenceBetweenNodeAndAncestorLeetcode1026 {
  private static int result = 0;

  private static int maxAncestorDiff(TreeNode root) {
    result = 0;
    maxDiffRec(root, root.val, root.val);
    return result;
  }

  private static void maxDiffRec(TreeNode root, int min, int max) {
    if(root == null)
      return;
    result = Integer.max(result, Integer.max(Math.abs(root.val - min), Math.abs(root.val - max)));
    max = Integer.max(max, root.val);
    min = Integer.min(min, root.val);
    maxDiffRec(root.left, min, max);
    maxDiffRec(root.right, min, max);
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
