package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author t0k02w6 on 22/05/23
 * @project ds-algo-2021-leetcode
 */
public class MinTimeToInfectTheWholeTreeLeetcode2385 {
  private static int amountOfTime(TreeNode root, int start) {
    Map<Integer, Pair<TreeNode, TreeNode>> nodeParentMap = new HashMap<>();
    populateMap(root, null, nodeParentMap);
    int time = 0;
    Queue<TreeNode> q = new LinkedList<>();
    Set<Integer> burnedSets = new HashSet<>();
    burnedSets.add(start);
    q.add(nodeParentMap.get(start).first);

    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        TreeNode remNode = q.poll();
        if(remNode.left != null && !burnedSets.contains(remNode.left.val)) {
          q.add(remNode.left);
          burnedSets.add(remNode.left.val);
        }

        if(remNode.right != null && !burnedSets.contains(remNode.right.val)) {
          q.add(remNode.right);
          burnedSets.add(remNode.right.val);
        }

        TreeNode parentNode = nodeParentMap.get(remNode.val).second;
        if(parentNode != null && !burnedSets.contains(parentNode.val)) {
          q.add(parentNode);
          burnedSets.add(parentNode.val);
        }
      }
      time++;
    }
    return time;
  }

  private static void populateMap(TreeNode root, TreeNode parent, Map<Integer,
      Pair<TreeNode, TreeNode>> nodeParentMap) {
    if(root == null)
      return;
    Pair<TreeNode, TreeNode> currentPair = new Pair<>(root, parent);
    nodeParentMap.put(root.val, currentPair);
    populateMap(root.left, root, nodeParentMap);
    populateMap(root.right, root, nodeParentMap);
  }

  public static void main(String[] args) {

  }
}
