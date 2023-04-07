package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */
public class BinaryTreeLevelOrderZigzagTraversalLeetcode103 {
  private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if(root == null)
      return new ArrayList<>();
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    List<List<Integer>> result = new ArrayList<>();
    stack1.push(root);
    List<Integer> current = null;
    while(!stack1.isEmpty() || !stack2.isEmpty()) {
      if(!stack1.isEmpty()) {
        current = new ArrayList<>();
        while(!stack1.isEmpty()) {
          TreeNode remNode = stack1.pop();
          current.add(remNode.val);
          if(remNode.left != null)
            stack2.push(remNode.left);
          if(remNode.right != null)
            stack2.push(remNode.right);
        }
        result.add(current);
      }


      if(!stack2.isEmpty()) {
        current = new ArrayList<>();
        while(!stack2.isEmpty()) {
          TreeNode remNode = stack2.pop();
          current.add(remNode.val);

          if(remNode.right != null) {
            stack1.push(remNode.right);
          }
          if(remNode.left != null) {
            stack1.push(remNode.left);
          }
        }
        result.add(current);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    List<List<Integer>> result = zigzagLevelOrder(root);
    System.out.println(result);
  }
}
