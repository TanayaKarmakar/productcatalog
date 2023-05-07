package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 06/05/23
 * @project ds-algo-2021-leetcode
 */
public class DeleteNodesAndReturnForestLeetcode1110 {
  private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> delSet = new HashSet<>();

    for(int el: to_delete) {
      delSet.add(el);
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

  public static void main(String[] args) {

  }
}
