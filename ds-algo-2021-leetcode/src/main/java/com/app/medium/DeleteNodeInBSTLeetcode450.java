package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 07/04/23
 * @project ds-algo-2021-leetcode
 */
public class DeleteNodeInBSTLeetcode450 {

  private static TreeNode deleteNode(TreeNode root, int key) {
    if(root == null)
      return null;
    if(root.val > key)
      root.left = deleteNode(root.left, key);
    else if(root.val < key)
      root.right = deleteNode(root.right, key);
    else {
      if(root.left != null && root.right != null) {
        TreeNode inorderSucc = findInorderSuccessor(root.right);
        root.val = inorderSucc.val;
        root.right = deleteNode(root.right, inorderSucc.val);
      } else {
        if(root.left != null) {
          return root.left;
        } else {
          return root.right;
        }
      }
    }
    return root;
  }

  private static TreeNode findInorderSuccessor(TreeNode right) {
    TreeNode temp = right;
    while(temp != null && temp.left != null) {
      temp = temp.left;
    }
    return temp;
  }

  public static void main(String[] args) {

  }
}
