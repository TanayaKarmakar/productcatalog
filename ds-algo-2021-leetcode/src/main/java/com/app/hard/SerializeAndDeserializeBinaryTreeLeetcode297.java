package com.app.hard;

import com.app.common.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode remNode = queue.poll();
            if(remNode != null) {
                sb.append(remNode.val);
                sb.append(",");
                queue.add(remNode.left);
                queue.add(remNode.right);
            } else {
                sb.append("null,");
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        if(tokens[0].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int indx = 0;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = tokens[++indx].equals("null") ? null: new TreeNode(Integer.parseInt(tokens[indx]));
            TreeNode right = tokens[++indx].equals("null") ? null: new TreeNode(Integer.parseInt(tokens[indx]));

            node.left = left;
            node.right = right;

            if(left != null)
                queue.add(left);
            if(right != null)
                queue.add(right);
        }

        return root;
    }
}

public class SerializeAndDeserializeBinaryTreeLeetcode297 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String serialized = codec.serialize(root);

        System.out.println(serialized);
    }
}
