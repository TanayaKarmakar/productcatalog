package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 08/06/23
 * @project ds-algo-2021-leetcode
 */
public class FindDuplicateSubtreesLeetcode652 {
  private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> result = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    findDuplicateSubtreesRec(root, map, result);
    return result;
  }

  private static String findDuplicateSubtreesRec(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
    if(root == null)
      return "";
    String leftStr = findDuplicateSubtreesRec(root.left, map, result);
    String rightStr = findDuplicateSubtreesRec(root.right, map, result);
    StringBuilder sb = new StringBuilder();
    sb.append(leftStr);
    sb.append("#");
    sb.append(rightStr);
    sb.append("#");
    sb.append(root.val);
    map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
    if(map.get(sb.toString()) == 2) {
      result.add(root);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    root.right.left.left = new TreeNode(4);

    List<TreeNode> result = findDuplicateSubtrees(root);

    for(TreeNode node: result) {
      System.out.println(node.val);
    }
  }
}
