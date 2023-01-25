package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 05/12/22
 * @project ds-algo-2021
 */
public class SumRootToLeafNumbersLeetcode129 {
  static class Item {
    TreeNode node;
    int numSoFar;
  }

  private static int sumNumbers(TreeNode root) {
    if(root == null)
      return 0;
    Queue<Item> q = new LinkedList<>();
    Item item = new Item();
    item.node = root;
    item.numSoFar = root.val;

    q.add(item);


    int total = 0;
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        Item node = q.poll();
        if(node.node.left == null && node.node.right == null) {
          //System.out.println(node.numSoFar);
          total += node.numSoFar;
          continue;
        }

        if(node.node.left != null) {
          Item leftItem = new Item();
          leftItem.node = node.node.left;
          leftItem.numSoFar = node.numSoFar * 10 + node.node.left.val;
          q.add(leftItem);
        }

        if(node.node.right != null) {
          Item rightItem = new Item();
          rightItem.node = node.node.right;
          rightItem.numSoFar = node.numSoFar * 10 + node.node.right.val;
          q.add(rightItem);
        }
      }
    }
    return total;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(9);
    root.right = new TreeNode(0);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(1);

    int ans = sumNumbers(root);

    System.out.println(ans);
  }
}
