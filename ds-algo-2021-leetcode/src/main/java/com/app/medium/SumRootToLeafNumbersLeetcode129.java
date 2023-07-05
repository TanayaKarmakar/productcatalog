package com.app.medium;

import com.app.common.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 04/07/23
 * @project ds-algo-2021-leetcode
 */
public class SumRootToLeafNumbersLeetcode129 {
  static class TreeItem {
    TreeNode currentNode;
    int numSoFar;

    public TreeItem(TreeNode currentNode, int numSoFar) {
      this.currentNode = currentNode;
      this.numSoFar = numSoFar;
    }
  }

  private static int sumNumbers(TreeNode root) {
    int sum = 0;
    Queue<TreeItem> q = new LinkedList<>();
    q.add(new TreeItem(root, root.val));

    while(!q.isEmpty()) {
      TreeItem remItem = q.poll();
      if(remItem.currentNode.left == null && remItem.currentNode.right == null) {
        sum += remItem.numSoFar;
        continue;
      }

      if(remItem.currentNode.left != null) {
        q.add(new TreeItem(remItem.currentNode.left, remItem.numSoFar * 10
            + remItem.currentNode.left.val));
      }

      if(remItem.currentNode.right != null) {
        q.add(new TreeItem(remItem.currentNode.right, remItem.numSoFar * 10
            + remItem.currentNode.right.val));
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);

    int ans = sumNumbers(root);

    System.out.println(ans);
  }
}
