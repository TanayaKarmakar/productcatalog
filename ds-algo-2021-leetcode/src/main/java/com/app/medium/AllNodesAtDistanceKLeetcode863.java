package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 16/04/23
 * @project ds-algo-2021-leetcode
 */
public class AllNodesAtDistanceKLeetcode863 {
  private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> nodeMap = new HashMap<>();
    populateMap(root, null, nodeMap);

    Set<TreeNode> visited = new HashSet<>();
    visited.add(target);

    Queue<TreeNode> q = new LinkedList<>();
    q.add(target);
    while(!q.isEmpty() && k > 0) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        TreeNode remItem = q.poll();

        if(remItem.left != null && !visited.contains(remItem.left)) {
          q.add(remItem.left);
          visited.add(remItem.left);
        }

        if(remItem.right != null && !visited.contains(remItem.right)) {
          q.add(remItem.right);
          visited.add(remItem.right);
        }

        TreeNode parent = nodeMap.get(remItem);
        if(parent != null && !visited.contains(parent)) {
          q.add(parent);
          visited.add(parent);
        }
      }
      k--;
    }

    List<Integer> result = new ArrayList<>();

    while(!q.isEmpty()) {
      result.add(q.poll().val);
    }

    return result;
  }

  private static void populateMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> nodeMap) {
    if(root == null)
      return;
    nodeMap.put(root, parent);
    populateMap(root.left, root, nodeMap);
    populateMap(root.right, root, nodeMap);
  }

  public static void main(String[] args) {

  }
}
