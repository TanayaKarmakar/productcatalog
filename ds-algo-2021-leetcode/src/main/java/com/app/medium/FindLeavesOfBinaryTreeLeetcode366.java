package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 17/04/23
 * @project ds-algo-2021-leetcode
 */
public class FindLeavesOfBinaryTreeLeetcode366 {
  private static List<List<Integer>> findLeaves(TreeNode root) {
    if(root == null)
      return new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    Map<TreeNode, TreeNode> parentMap = null;

    List<Integer> current = null;
    while(root != null) {
      current = new ArrayList<>();
      parentMap = new HashMap<>();
      populateParentMap(root, null, parentMap);
      for(Map.Entry<TreeNode, TreeNode> entry: parentMap.entrySet()) {
        TreeNode currentLeaf = entry.getKey();
        TreeNode parentNode = entry.getValue();

        if(parentNode != null) {
          if(parentNode.left == currentLeaf)
            parentNode.left = null;
          else
            parentNode.right = null;
        } else
          root = null;
        current.add(currentLeaf.val);
      }
      result.add(current);
    }
    return result;
  }

  private static void populateParentMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
    if(root == null)
      return;
    if(root.left == null && root.right == null)
      parentMap.put(root, parent);
    populateParentMap(root.left, root, parentMap);
    populateParentMap(root.right, root, parentMap);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    List<List<Integer>> result = findLeaves(root);

    System.out.println(result);
  }
}
