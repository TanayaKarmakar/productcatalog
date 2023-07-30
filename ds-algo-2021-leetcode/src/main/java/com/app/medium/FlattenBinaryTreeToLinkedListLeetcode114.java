package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 08/07/23
 * @project ds-algo-2021-leetcode
 */
public class FlattenBinaryTreeToLinkedListLeetcode114 {
  private static void flatten(TreeNode root) {
    if(root == null)
      return;
    flattenRec(root);
  }

  private static TreeNode flattenRec(TreeNode root) {
    if(root == null)
      return null;
    TreeNode left = flattenRec(root.left);
    TreeNode right = flattenRec(root.right);
    root.left = null;
    root.right = left;
    TreeNode temp = root;
    while(temp.right != null) {
      temp = temp.right;
    }
    temp.right = right;
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);

    flatten(root);

    TreeNode temp = root;
    while(temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.right;
    }
    System.out.println();
  }
}
