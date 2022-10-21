package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import com.app.common.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author t0k02w6 on 16/10/22
 * @project ds-algo-2021-leetcode
 */
public class FindDuplicateSubtreesLeetcode652 {
  private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    Map<String, Pair<TreeNode, Integer>> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    findDuplicateSubtreesRec(root, map, result);
    return result;
  }

  private static String findDuplicateSubtreesRec(TreeNode root, Map<String, Pair<TreeNode, Integer>> map, List<TreeNode> result) {
    if(root == null)
      return "";
    String leftStr = findDuplicateSubtreesRec(root.left, map, result);
    String rightStr = findDuplicateSubtreesRec(root.right, map, result);
    StringBuilder sb = new StringBuilder();
    sb.append(leftStr).append("#");
    sb.append(rightStr).append("#");
    sb.append(root.val);
    String key = sb.toString();
    Pair<TreeNode, Integer> pair = null;
    if(!map.containsKey(key)) {
      pair = new Pair<>(root, 1);
    } else {
      pair = map.get(key);
      pair.second = pair.second + 1;
      if(pair.second == 2)
        result.add(root);
    }
    map.put(key, pair);
    return key;
  }

  public static void main(String[] args) {

  }
}
