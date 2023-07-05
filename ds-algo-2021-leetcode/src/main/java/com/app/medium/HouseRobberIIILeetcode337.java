package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 04/07/23
 * @project ds-algo-2021-leetcode
 */
public class HouseRobberIIILeetcode337 {
  private static Map<TreeNode, Integer> robMap;
  private static Map<TreeNode, Integer> notRobMap;

  private static int rob(TreeNode root) {
    if(root == null)
      return 0;
    robMap = new HashMap<>();
    notRobMap = new HashMap<>();
    return Integer.max(robRec(root, true), robRec(root, false));
  }

  private static int robRec(TreeNode root, boolean canRob) {
    if(root == null)
      return 0;
    if(canRob) {
      if(!robMap.containsKey(root)) {
        int value = root.val + robRec(root.left, !canRob) + robRec(root.right, !canRob);
        robMap.put(root, value);
      }
      return robMap.get(root);
    } else {
      if(!notRobMap.containsKey(root)) {
        int value1 = Integer.max(robRec(root.left, canRob), robRec(root.left, !canRob));
        int value2 = Integer.max(robRec(root.right, canRob), robRec(root.right, !canRob));
        notRobMap.put(root, value1 + value2);
      }
      return notRobMap.get(root);
    }
  }

  public static void main(String[] args) {

  }
}
