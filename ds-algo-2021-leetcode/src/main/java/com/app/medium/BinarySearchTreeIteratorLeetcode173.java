package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import java.util.Stack;

/**
 * @author t0k02w6 on 09/04/23
 * @project ds-algo-2021-leetcode
 */

class BSTIterator {
  private Stack<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    leftMostTraversal(root);
  }

  public int next() {
    TreeNode topNode = stack.pop();

    if(topNode.right != null)
      leftMostTraversal(topNode.right);
    return topNode.val;
  }

  public boolean hasNext() {
    return stack.size() > 0;
  }

  private void leftMostTraversal(TreeNode root) {
    while(root != null) {
      stack.push(root);
      root = root.left;
    }
  }
}

public class BinarySearchTreeIteratorLeetcode173 {
  public static void main(String[] args) {

  }
}
