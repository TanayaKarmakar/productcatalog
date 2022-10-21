package com.app.medium;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 17/10/22
 * @project ds-algo-2021-leetcode
 */
public class HouseRobberIIILeetcode337 {
//  private static int rob(TreeNode root) {
//    if(root == null)
//      return 0;
//    return Integer.max(robRec(root, true), robRec(root, false));
//  }
//
//  private static int robRec(TreeNode root, boolean canRob) {
//    if(root == null)
//      return 0;
//    if(canRob)
//      return root.val + robRec(root.left, false) + robRec(root.right, false);
//    else {
//      int option1 = Integer.max(robRec(root.left,canRob), robRec(root.left, !canRob));
//      int option2 = Integer.max(robRec(root.right, canRob), robRec(root.right, !canRob));
//      return option1 + option2;
//    }
//  }

  private static Map<TreeNode, Integer> robMap = null;
  private static Map<TreeNode, Integer> notRobMap = null;

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
        int option1 = Integer.max(robRec(root.left, canRob), robRec(root.left, !canRob));
        int option2 = Integer.max(robRec(root.right, canRob), robRec(root.right, !canRob));
        notRobMap.put(root, option1 + option2);
      }
      return notRobMap.get(root);
    }
  }

  public static void main(String[] args) {

  }
}
