package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 08/04/23
 * @project ds-algo-2021-leetcode
 */
public class BoundaryOfBinaryTreeLeetcode545 {
  private static List<Integer> boundaryOfBinaryTree(TreeNode root) {
    if(root == null)
      return new ArrayList<>();

    List<Integer> result = new ArrayList<>();

    result.add(root.val);
    traverseLeft(root.left, result);
    traverseBottom(root, result);
    traverseRight(root.right, result);

    return result;
  }

  private static void traverseBottom(TreeNode root, List<Integer> result) {
    if(root == null)
      return;
    if(isLeaf(root)) {
      result.add(root.val);
      return;
    }
    if(root.left != null)
      traverseBottom(root.left, result);
    if(root.right != null)
      traverseBottom(root.right, result);
  }

  private static void traverseLeft(TreeNode root, List<Integer> result) {
    if(root == null)
      return;
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode temp = root;
    q.add(temp);
    while(!q.isEmpty()) {
        TreeNode node = q.poll();
        if(!isLeaf(node)) {
          result.add(node.val);
        }

        if(node.left != null) {
          q.add(node.left);
        } else if(node.right != null) {
          q.add(node.right);
        }
    }
  }

  private static void traverseRight(TreeNode root, List<Integer> result) {
    if(root == null)
      return;
    Queue<TreeNode> q = new LinkedList<>();
    TreeNode temp = root;
    List<Integer> tempResult = new ArrayList<>();
    q.add(temp);
    while(!q.isEmpty()) {
        TreeNode node = q.poll();
        if(!isLeaf(node)) {
          tempResult.add(node.val);
        }

        if(node.right != null) {
          q.add(node.right);
        } else if(node.left != null) {
          q.add(node.left);
        }
    }

    Collections.reverse(tempResult);
    result.addAll(tempResult);
  }

  private static boolean isLeaf(TreeNode root) {
    return root.left == null && root.right == null;
  }



  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(4);

    List<Integer> ans = boundaryOfBinaryTree(root);

    System.out.println(ans);
  }
}
