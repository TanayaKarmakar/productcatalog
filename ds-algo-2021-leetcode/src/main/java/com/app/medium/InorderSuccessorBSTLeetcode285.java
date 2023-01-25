package com.app.medium;


import com.app.common.BinaryTree.TreeNode;
import java.util.Stack;

/**
 * @author t0k02w6 on 05/12/22
 * @project ds-algo-2021
 */
public class InorderSuccessorBSTLeetcode285 {
  private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode curr = p;
    if(curr.right != null) {
      curr = curr.right;
      while(curr.left != null) {
        curr = curr.left;
      }
      return curr;
    }

    curr = root;
    boolean isFound = false;
    Stack<TreeNode> stack = new Stack<>();
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
    TreeNode root = new TreeNode(2);
    root.right = new TreeNode(3);

    System.out.println(inorderSuccessor(root, root).val);
  }
}
