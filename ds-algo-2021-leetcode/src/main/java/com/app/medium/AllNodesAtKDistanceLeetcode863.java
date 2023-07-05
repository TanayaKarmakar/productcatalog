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
 * @author t0k02w6 on 21/06/23
 * @project ds-algo-2021-leetcode
 */
public class AllNodesAtKDistanceLeetcode863 {
  private static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    Map<TreeNode, TreeNode> nodeMap = new HashMap<>();
    populateParentChildMap(root, null, nodeMap);

    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    Set<TreeNode> visited = new HashSet<>();

    queue.add(target);
    visited.add(target);

    while(!queue.isEmpty()) {
      int size = queue.size();
      for(int i = 0; i < size; i++) {
        TreeNode remItem = queue.poll();
        if(k == 0) {
          result.add(remItem.val);
          continue;
        }

        if(remItem.left != null && !visited.contains(remItem.left)) {
          queue.add(remItem.left);
          visited.add(remItem.left);
        }

        if(remItem.right != null && !visited.contains(remItem.right)) {
          queue.add(remItem.right);
          visited.add(remItem.right);
        }

        TreeNode parent = nodeMap.get(remItem);
        if(parent != null && !visited.contains(parent)) {
          queue.add(parent);
          visited.add(parent);
        }
      }
      k--;
    }
    return result;
  }

  private static void populateParentChildMap(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> nodeMap) {
    if(root == null)
      return;
    nodeMap.put(root, parent);
    populateParentChildMap(root.left, root, nodeMap);
    populateParentChildMap(root.right, root, nodeMap);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left= new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);

    List<Integer> result = distanceK(root, root.left, 2);

    System.out.println(result);
  }
}
