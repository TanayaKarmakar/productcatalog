package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 18/10/22
 * @project ds-algo-2021-leetcode
 */
public class DeleteNodeInABSTLeetcode450 {

  private static TreeNode deleteNode(TreeNode root, int key) {
    if(root == null)
      return null;
    if(root.val > key)
      root.left =  deleteNode(root.left, key);
    else if(root.val < key)
      root.right = deleteNode(root.right, key);
    else {
      if(root.left != null)
        return root.left;
      else if(root.right != null)
        return root.right;
      else {
        TreeNode start = root.right;
        while(start != null && start.left != null) {
          start = start.left;
        }
        root.val = start.val;
        root.right = deleteNode(root.right, start.val);
      }
    }
    return root;
  }

  public static void main(String[] args) {

  }
}
