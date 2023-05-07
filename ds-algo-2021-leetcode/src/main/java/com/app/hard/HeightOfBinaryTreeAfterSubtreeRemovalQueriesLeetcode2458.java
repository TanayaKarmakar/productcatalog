package com.app.hard;

import com.app.common.BinaryTree.TreeNode;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author t0k02w6 on 06/05/23
 * @project ds-algo-2021-leetcode
 */
public class HeightOfBinaryTreeAfterSubtreeRemovalQueriesLeetcode2458 {
  private static int[] treeQueries(TreeNode root, int[] queries) {
    Map<Integer, TreeNode> parentMap = new HashMap<>();
    populateMap(root, null, parentMap);

    int n = queries.length;
    int[] result = new int[n];
    for(int i = 0; i < queries.length; i++) {
      TreeNode parent = parentMap.get(queries[i]);
      TreeNode left = null;
      TreeNode right = null;
      if(parent.left != null && parent.left.val == queries[i]) {
        left = parent.left;
        parent.left = null;
      } else if(parent.right != null && parent.right.val == queries[i]) {
        right = parent.right;
        parent.right = null;
      }
      result[i] = getHeight(root) - 1;

      if(left != null) {
        parent.left = left;
      }
      if(right != null) {
        parent.right = right;
      }

    }
    return result;
  }

  private static int getHeight(TreeNode root) {
    if(root == null)
      return 0;
    int lh = getHeight(root.left);
    int rh = getHeight(root.right);
    return 1 + Integer.max(lh, rh);
  }


  private static void populateMap(TreeNode root, TreeNode parent, Map<Integer, TreeNode> parentMap) {
    if(root == null)
      return;
    parentMap.put(root.val, parent);
    populateMap(root.left, root, parentMap);
    populateMap(root.right, root, parentMap);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(8);
    root.right = new TreeNode(9);
    root.left.left = new TreeNode(2);
    root.left.right = new TreeNode(1);
    root.left.left.left = new TreeNode(4);
    root.left.left.right = new TreeNode(6);
    root.right.left = new TreeNode(3);
    root.right.right = new TreeNode(7);

    int[] queries = {3,2,4,8};

    int[] result = treeQueries(root, queries);

    System.out.println(Arrays.toString(result));
  }
}
