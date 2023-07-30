package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.Stack;

/**
 * @author t0k02w6 on 09/07/23
 * @project ds-algo-2021-leetcode
 */
public class InorderSuccessorLeetcode285 {
  private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root == null)
      return null;
    TreeNode curr = p;
    if(curr.right != null) {
      TreeNode temp = curr.right;
      while(temp.left != null) {
        temp = temp.left;
      }
      return temp;
    }

    Stack<TreeNode> stack = new Stack<>();
    curr = root;
    boolean isFound = false;

    while(!stack.isEmpty() || curr != null) {
      while(curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      if(isFound)
        return curr;
      if(curr == p) {
        isFound = true;
      }
      curr = curr.right;
    }
    return null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(4);
    root.left.left.left = new TreeNode(1);

    System.out.println(inorderSuccessor(root, root.right));

    root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    System.out.println(inorderSuccessor(root, root.left).val);
  }
}
