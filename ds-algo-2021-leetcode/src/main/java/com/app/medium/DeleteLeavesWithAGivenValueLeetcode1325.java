package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 11/04/23
 * @project ds-algo-2021-leetcode
 */
public class DeleteLeavesWithAGivenValueLeetcode1325 {
  private static TreeNode removeLeafNodes(TreeNode root, int target) {
    if(root == null)
      return null;
    root.left = removeLeafNodes(root.left, target);
    root.right = removeLeafNodes(root.right, target);

    if(isLeaf(root) && root.val == target)
      return null;
    return root;
  }

  private static boolean isLeaf(TreeNode root) {
    return root.left == null && root.right == null;
  }

  private static void levelOrderTraversal(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();

    q.add(root);

    while(!q.isEmpty()) {
      TreeNode node = q.poll();

      System.out.println(node.val);

      if(node.left != null)
        q.add(node.left);
      if(node.right != null)
        q.add(node.right);
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(2);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);

    int target = 2;
    root = removeLeafNodes(root, target);

    levelOrderTraversal(root);
  }
}
