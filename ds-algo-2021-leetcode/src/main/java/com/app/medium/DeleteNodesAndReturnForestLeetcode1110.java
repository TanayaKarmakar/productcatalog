package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author t0k02w6 on 05/12/22
 * @project ds-algo-2021
 */
public class DeleteNodesAndReturnForestLeetcode1110 {
  private static TreeNode delRec(TreeNode root, Set<Integer> delSet, List<TreeNode> nodes) {
    if(root == null)
      return null;
    root.left = delRec(root.left, delSet, nodes);
    root.right = delRec(root.right, delSet, nodes);

    if(delSet.contains(root.val)) {
      if(root.left != null)
        nodes.add(root.left);
      if(root.right != null)
        nodes.add(root.right);
      return null;
    }
    return root;
  }

  private static List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    Set<Integer> delSet = new HashSet<>();
    for(int el: to_delete) {
      delSet.add(el);
    }

    List<TreeNode> treeNodes = new ArrayList<>();
    delRec(root, delSet, treeNodes);
    if(!delSet.contains(root.val)) {
      treeNodes.add(root);
    }
    return treeNodes;
  }

  public static void main(String[] args) {

  }
}
