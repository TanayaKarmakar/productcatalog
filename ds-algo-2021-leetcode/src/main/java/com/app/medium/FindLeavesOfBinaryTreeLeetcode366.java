package com.app.medium;


import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 01/07/23
 * @project ds-algo-2021-leetcode
 */
public class FindLeavesOfBinaryTreeLeetcode366 {
  private static List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Map<TreeNode, TreeNode> nodeMap = new LinkedHashMap<>();
    while(root != null) {
      nodeMap = new LinkedHashMap<>();
      populateLeaves(root, null, nodeMap);
      List<Integer> current = new ArrayList<>();
      for(Map.Entry<TreeNode, TreeNode> entry: nodeMap.entrySet()) {
        TreeNode currentLeaf = entry.getKey();
        TreeNode parent = entry.getValue();
        if(parent != null) {
          if(parent.left == currentLeaf) {
            parent.left = null;
          } else {
            parent.right = null;
          }
        } else {
          root = null;
        }
        current.add(currentLeaf.val);
      }
      result.add(current);
    }
    return result;
  }

  private static void populateLeaves(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> nodeMap) {
    if(root == null)
      return;
    if(root.left == null && root.right == null) {
      nodeMap.put(root, parent);
    }
    populateLeaves(root.left, root, nodeMap);
    populateLeaves(root.right, root, nodeMap);
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
