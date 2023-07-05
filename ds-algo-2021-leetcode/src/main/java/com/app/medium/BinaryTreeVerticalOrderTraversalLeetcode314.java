package com.app.medium;


import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author t0k02w6 on 03/07/23
 * @project ds-algo-2021-leetcode
 */
public class BinaryTreeVerticalOrderTraversalLeetcode314 {
  static class TreeItem {
    TreeNode node;
    int currentLevel;

    public TreeItem(TreeNode node, int currentLevel) {
      this.node = node;
      this.currentLevel = currentLevel;
    }
  }

  private static List<List<Integer>> verticalOrder(TreeNode root) {
    if(root == null)
      return new ArrayList<>();
    TreeMap<Integer, List<Integer>> levelMap = new TreeMap<>();

    verticalOrderRec(root, levelMap);
    List<List<Integer>> result = new ArrayList<>();
    for(Map.Entry<Integer, List<Integer>> entry: levelMap.entrySet()) {
      result.add(entry.getValue());
    }
    return result;
  }

  private static void verticalOrderRec(TreeNode root, TreeMap<Integer, List<Integer>> levelMap) {
    Queue<TreeItem> q = new LinkedList<>();
    q.add(new TreeItem(root, 0));

    while(!q.isEmpty()) {
      TreeItem remItem = q.poll();
      if(!levelMap.containsKey(remItem.currentLevel))
        levelMap.put(remItem.currentLevel, new ArrayList<>());
      levelMap.get(remItem.currentLevel).add(remItem.node.val);

      if(remItem.node.left != null)
        q.add(new TreeItem(remItem.node.left, remItem.currentLevel - 1));
      if(remItem.node.right != null)
        q.add(new TreeItem(remItem.node.right, remItem.currentLevel + 1));
    }
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    List<List<Integer>> result = verticalOrder(root);

    System.out.println(result);
  }
}
