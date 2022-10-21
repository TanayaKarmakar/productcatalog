package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 02/10/22
 * @project ds-algo-2021-leetcode
 */
public class ConstructBinaryTreeFromInorderPreorderLeetcode105 {
  private static int preIndex = 0;

  private static TreeNode buildTree(int[] preorder, int[] inorder) {
    preIndex = 0;
    TreeNode root = buildTreeRec(preorder, inorder, 0, inorder.length - 1);
    return root;
  }

  private static TreeNode buildTreeRec(int[] preorder, int[] inorder, int start, int end) {
    if(start > end)
      return null;
    int val = preorder[preIndex++];
    TreeNode node = new TreeNode(val);
    int inIndex = search(val, inorder, start, end);
    node.left = buildTreeRec(preorder, inorder, start, inIndex - 1);
    node.right = buildTreeRec(preorder, inorder, inIndex + 1, end);
    return node;
  }

  private static int search(int val, int[] inorder, int start, int end) {
    for(int i = start; i <= end; i++) {
      if(inorder[i] == val)
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {

  }
}
