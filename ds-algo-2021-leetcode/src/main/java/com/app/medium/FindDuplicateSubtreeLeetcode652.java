package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 20/04/23
 * @project ds-algo-2021-leetcode
 */
public class FindDuplicateSubtreeLeetcode652 {
  private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    if(root == null)
      return new ArrayList<>();
    List<TreeNode> result = new ArrayList<>();
    Map<String, Pair<TreeNode, Integer>> map = new HashMap<>();
    findDuplicateRec(root, result, map);
    return result;
  }

  private static String findDuplicateRec(TreeNode root, List<TreeNode> result, Map<String, Pair<TreeNode, Integer>> map) {
    if(root == null)
      return "";
    String leftStr = findDuplicateRec(root.left, result, map);
    String rightStr = findDuplicateRec(root.right, result, map);

    StringBuilder sb = new StringBuilder();
    if(!leftStr.isEmpty()) {
      sb.append(leftStr);
      sb.append("#");
    }

    if(!rightStr.isEmpty()) {
      sb.append(rightStr);
      sb.append("#");
    }

    sb.append(root.val);
    String newStr = sb.toString();
    if(map.containsKey(newStr)) {
      Pair<TreeNode, Integer> valueNode = map.get(newStr);
      if(valueNode.second == 2) {
        result.add(valueNode.first);
      }
      valueNode.second = valueNode.second + 1;
      map.put(newStr, valueNode);
    } else {
      Pair<TreeNode, Integer> newNode = new Pair<>(root, 1);
      map.put(newStr, newNode);
    }
    return newStr;
  }

  public static void main(String[] args) {

  }
}
