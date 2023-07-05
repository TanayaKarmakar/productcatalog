package com.app.medium;

import com.app.common.BinaryTree.TreeNode;

/**
 * @author t0k02w6 on 02/07/23
 * @project ds-algo-2021-leetcode
 */
public class ConstructBinaryTreeFromPreorderPostorderLeetcode105 {
  private static int preIndx = 0;

  private static TreeNode buildTree(int[] preorder, int[] inorder) {
    preIndx = 0;
    return buildTreeRec(preorder, inorder, 0, inorder.length - 1);
  }

  private static TreeNode buildTreeRec(int[] preorder, int[] inorder, int start, int end) {
    if(start > end)
      return null;
    TreeNode root = new TreeNode(preorder[preIndx]);
    int inorderIndx = searchItem(inorder, preorder[preIndx], start, end);
    preIndx++;
    if(inorderIndx != -1) {
      root.left = buildTreeRec(preorder, inorder, start, inorderIndx - 1);
      root.right = buildTreeRec(preorder, inorder, inorderIndx + 1, end);
    }
    return root;
  }

  private static int searchItem(int[] inorder, int item, int start, int end) {
    for(int i = start; i <= end; i++) {
      if(inorder[i] == item)
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {

  }
}
