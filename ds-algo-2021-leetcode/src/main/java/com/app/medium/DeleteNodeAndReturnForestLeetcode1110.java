package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 25/06/23
 * @project ds-algo-2021-leetcode
 */
public class DeleteNodeAndReturnForestLeetcode1110 {
  private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> delSet = new HashSet<>();
    for(int del: to_delete) {
      delSet.add(del);
    }
    List<TreeNode> result = new ArrayList<>();
    delNodesRec(root, delSet, result);
    if(!delSet.contains(root.val)) {
      result.add(root);
    }
    return result;
  }

  private static TreeNode delNodesRec(TreeNode root, Set<Integer> delSet, List<TreeNode> result) {
    if(root == null)
      return null;
    root.left = delNodesRec(root.left, delSet, result);
    root.right = delNodesRec(root.right, delSet, result);
    if(delSet.contains(root.val)) {
      if(root.left != null)
        result.add(root.left);
      if(root.right != null)
        result.add(root.right);
      return null;
    }
    return root;
  }

  private static void levelOrder(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
      TreeNode remNode = q.poll();
      System.out.print(remNode.val + " ");

      if(remNode.left != null)
        q.add(remNode.left);

      if(remNode.right != null)
        q.add(remNode.right);
    }
    System.out.println();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    int[] to_delete = {3,5};
    List<TreeNode> result = delNodes(root, to_delete);

    for(TreeNode curr: result) {
      levelOrder(curr);
    }
  }
}
