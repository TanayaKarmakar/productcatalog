package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 08/07/23
 * @project ds-algo-2021-leetcode
 */
public class InfectingBinaryTreesLeetcode2385 {
  private static int amountOfTime(TreeNode root, int start) {
    if(root == null)
      return 0;
    Map<Integer, TreeNode> nodeMap = new HashMap<>();
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();
    populateMaps(root, null, nodeMap, parentMap);

    TreeNode node = nodeMap.get(start);
    Set<TreeNode> visited = new HashSet<>();

    Queue<TreeNode> q = new LinkedList<>();
    q.add(node);
    visited.add(node);

    int count = -1;
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        TreeNode remNode = q.poll();

        if(remNode.left != null && !visited.contains(remNode.left)) {
          q.add(remNode.left);
          visited.add(remNode.left);
        }

        if(remNode.right != null && !visited.contains(remNode.right)) {
          q.add(remNode.right);
          visited.add(remNode.right);
        }

        TreeNode parentNode = parentMap.get(remNode);
        if(parentNode != null && !visited.contains(parentNode)) {
          q.add(parentNode);
          visited.add(parentNode);
        }
      }
      count++;
    }
    return count;
  }

  private static void populateMaps(TreeNode root, TreeNode parent, Map<Integer, TreeNode> nodeMap, Map<TreeNode, TreeNode> parentMap) {
    if(root == null) {
      return;
    }
    nodeMap.put(root.val, root);
    parentMap.put(root, parent);
    populateMaps(root.left, root, nodeMap, parentMap);
    populateMaps(root.right, root, nodeMap, parentMap);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(5);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(9);
    root.left.right.right = new TreeNode(2);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(6);

    int ans = amountOfTime(root, root.right.val);

    System.out.println(ans);
  }
}
