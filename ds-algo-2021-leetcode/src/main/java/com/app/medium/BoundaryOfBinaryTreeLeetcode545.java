package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 08/07/23
 * @project ds-algo-2021-leetcode
 */
public class BoundaryOfBinaryTreeLeetcode545 {
  private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    result.add(root.val);

    traverseLeft(root.left, result);
    traverseBottom(root.left, result);
    traverseBottom(root.right, result);
    traverseRight(root.right, result);

    return result;
  }

  private static void traverseLeft(TreeNode root, List<Integer> result) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
      TreeNode remItem = q.poll();
      if(remItem.left == null && remItem.right == null)
        continue;
      result.add(remItem.val);

      if(remItem.left != null)
        q.add(remItem.left);
      else if(remItem.right != null)
        q.add(remItem.right);
    }
  }

  private static void traverseBottom(TreeNode root, List<Integer> result) {
    if(root == null)
      return;
    if(root.left == null && root.right == null) {
      result.add(root.val);
    }
    if(root.left != null)
      traverseBottom(root.left, result);
    if(root.right != null)
      traverseBottom(root.right, result);
  }

  private static void traverseRight(TreeNode root, List<Integer> result) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    List<Integer> temp = new ArrayList<>();

    while(!q.isEmpty()) {
      TreeNode remItem = q.poll();
      if(remItem.left == null && remItem.right == null)
        continue;
      temp.add(remItem.val);

      if(remItem.right != null)
        q.add(remItem.right);
      else if(remItem.left != null)
        q.add(remItem.left);
    }

    Collections.reverse(temp);
    result.addAll(temp);
  }

  public static void main(String[] args) {

  }
}
