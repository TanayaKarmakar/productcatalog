package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import java.util.Stack;

/**
 * @author t0k02w6 on 16/10/22
 * @project ds-algo-2021-leetcode
 */
public class KthSmallestElementInBSTLeetcode230 {
  private static int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();

    while(root != null || !stack.isEmpty()) {
      while(root != null) {
        stack.push(root);
        root = root.left;
      }

      root = stack.pop();
      k--;
      if(k == 0)
        return root.val;
      root = root.right;
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);

    int k = 1;
    int ans = kthSmallest(root, k);

    System.out.println(ans);
  }
}
