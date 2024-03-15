package com.app.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.app.common.BinaryTree.TreeNode;

public class BinaryTreeZigzagOrderTraversalLeetcode103 {
    private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean reverse = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentResult = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode remNode = queue.poll();
                if(reverse) {
                    currentResult.add(0, remNode.val);
                } else {
                    currentResult.add(remNode.val);
                }
                if(remNode.left != null)
                    queue.add(remNode.left);
                if(remNode.right != null)
                    queue.add(remNode.right);
            }
            reverse = !reverse;
            result.add(currentResult);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);

        System.out.println(result);
    }
}
