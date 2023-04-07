package com.app.easy;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author t0k02w6 on 28/02/23
 * @project ds-algo-2021-leetcode
 */
public class LeafSimilarTreesLeetcode872 {
  private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null)
      return true;
    if(root1 == null || root2 == null)
      return false;
    List<Integer> tree1List = bottomTraversal(root1);
    List<Integer> tree2List = bottomTraversal(root2);
    if(tree1List.size() != tree2List.size())
      return false;
    return tree1List.equals(tree2List);
    //for(int i = 0; i < tree1List.size(); i++)
  }

  private static List<Integer> bottomTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root.left == null && root.right == null) {
      result.add(root.val);
    } else {
      dfs(root, result);
    }
    return result;
  }

  private static void dfs(TreeNode root, List<Integer> result) {
    if(root == null)
      return;
    if(root.left == null && root.right == null) {
      result.add(root.val);
      return;
    }

    dfs(root.left, result);
    dfs(root.right, result);
  }

  public static void main(String[] args) {

  }
}
