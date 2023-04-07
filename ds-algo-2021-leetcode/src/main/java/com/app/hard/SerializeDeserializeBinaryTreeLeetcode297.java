package com.app.hard;

import com.app.common.BinaryTree;
import com.app.common.BinaryTree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author t0k02w6 on 16/02/23
 * @project ds-algo-2021-leetcode
 */

class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    StringBuilder sb = new StringBuilder();
    while(!q.isEmpty()) {
      int size = q.size();
      for(int i = 0; i < size; i++) {
        TreeNode remNode = q.poll();
        if(remNode != null) {
          sb.append(remNode.val);
          sb.append(",");
          q.add(remNode.left);
          q.add(remNode.right);
        } else {
          sb.append("null,");
        }
      }
    }

    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<TreeNode> q = new LinkedList<>();
    String[] tokens = data.split(",");
    if(tokens.length == 0 || tokens[0].equals("null"))
      return null;
    TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
    q.add(root);

    int indx = 0;
    while(!q.isEmpty()) {
      TreeNode curr = q.poll();

      TreeNode left = tokens[++indx].equals("null") ? null: new TreeNode(Integer.parseInt(tokens[indx]));
      TreeNode right = tokens[++indx].equals("null") ? null: new TreeNode(Integer.parseInt(tokens[indx]));

      curr.left = left;
      curr.right = right;
      if(left != null)
        q.add(left);
      if(right != null)
        q.add(right);
    }
    return root;
  }
}

public class SerializeDeserializeBinaryTreeLeetcode297 {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    Codec codec = new Codec();
    String ans = codec.serialize(root);

    System.out.println(ans);
  }
}
