package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 04/07/23
 * @project ds-algo-2021-leetcode
 */
public class BinaryTreeRightSideViewLeetcode199 {
  private static List<Integer> rightSideView(TreeNode root) {
    if(root == null)
      return new ArrayList<>();
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        TreeNode remNode = q.poll();
        if(i == size - 1) {
          result.add(remNode.val);
        }
        if(remNode.left != null)
          q.add(remNode.left);
        if(remNode.right != null)
          q.add(remNode.right);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);

    List<Integer> result = rightSideView(root);

    System.out.println(result);
  }
}
